package com.example.carbgg;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Home activity of the app
 */
public class MainActivity extends AppCompatActivity {
    float x1, x2, y1, y2;
    private TextView tv;
    private ListView lv;
    float totalCarbs = 0, insulinEfficiency = 1;
    private String defaultMsg = "Please enter meals";
    ArrayAdapter<Meal> adapter;
    ArrayList<DataPointToSave> listForLoading;
    private static boolean flag = true;

    /**
     * Loads history data from shared preferences only once per starting of the app and sets up xml elements to be used
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(flag){
            loadHistory();
        }
        flag=false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tvInsulinAmount);
        lv = findViewById(R.id.LvSelectedMealsToCalc);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListToSend.getInstance().getNames());

        if(ListToSend.getInstance() != null){
            lv.setAdapter(adapter);
        }else{
            lv.setAdapter(null);
            tv.setText(defaultMsg);
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(ListToSend.getInstance().getNames().size() > 0) {
                    ListToSend.getInstance().removeOne(position);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    /**
     * Gets total carbohydrates from singleton array "ListToSend", insulinEfficiency from shared preferences and calculates an insulin amount to be displayed on a textview with these numbers.
     * Saves an arraylist of objects containing date and amount of carbohydrates calculated into shared preferences for usage in history tab.
     * Clears the arraylist that was used to get meal data into the calculation
     * @param view
     */
    public void btnCalculate(View view) {
        for(int i=0; i<ListToSend.getInstance().getNames().size(); i++){
            Meal mealToAdd = ListToSend.getInstance().getNames().get(i);
            Float carbsOfMealToAdd=mealToAdd.getMealCarbs();
            totalCarbs += carbsOfMealToAdd;
            Log.d("test",String.valueOf(totalCarbs));
        }
        SharedPreferences prefGet = getSharedPreferences("configs" , Context.MODE_PRIVATE);
        float insulinEfficiency = prefGet.getFloat("inEfKey", Context.MODE_PRIVATE);
        float insulinAmount = (totalCarbs / 10) * insulinEfficiency;
        if (insulinAmount == 0){
            insulinAmount = (totalCarbs / 10) * 1;
        }
        String insulinDisplay = Float.toString(insulinAmount);
        tv.setText("Suggested insulin intake: "+ insulinDisplay+ " units");
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        SingletonClassHistory.getInstance().addNew(date,totalCarbs);
        saveHistory();
        ListToSend.getInstance().eraseList();
    }

    /**
     * Saves an arraylist of objects "DataPointToSave" containing dates of data samples and amount of carbohydrates into shared preferences
     */
    private void saveHistory(){
        SharedPreferences historyPut = getSharedPreferences("History",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = historyPut.edit();
        Gson gson = new Gson();
        String json = gson.toJson(SingletonClassHistory.getInstance().getAll());
        editor.putString("HistoryKey",json);
        editor.apply();
    }

    /**
     * Loads an arraylist of objects "DataPointToSave" containing dates of data samples and amount of carbohydrates for showing in history tab
     */
    private void loadHistory(){
        SharedPreferences historyGet = getSharedPreferences("History",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = historyGet.getString("HistoryKey", null);
        Type type = new TypeToken<ArrayList<DataPointToSave>>() {}.getType();
        listForLoading = gson.fromJson(json, type);
        if(listForLoading == null){
            listForLoading = new ArrayList<>();
        }
        for(int i = 0; i<listForLoading.size();i++){
            DataPointToSave tempData = listForLoading.get(i);
            SingletonClassHistory.getInstance().addNew(tempData.getTime(),tempData.getCarbs());
        }
    }

    /**
     * Touch event with slide animations for swiping between activities
     * @param touchevent
     * @return
     */
    public boolean onTouchEvent(MotionEvent touchevent){
        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if (x1 < x2) {
                    Intent i = new Intent(MainActivity.this, SwipeLeft.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                }else if(x2 < x1){
                Intent i = new Intent(MainActivity.this, SwipeRight.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }break;
        }
        return false;
    }

    /**
     * Button for changing activity
     * @param view
     */
    public void btnSettings(View view) {
        Intent j = new Intent(MainActivity.this,SettingsPage.class);
        startActivity(j);
    }

    /**
     * Button for changing activity
     * @param view
     */
    public void btnMeals(View view){
        Intent j = new Intent(MainActivity.this,SwipeLeft.class);
        startActivity(j);
    }

    /**
     * Button for changing activity
     * @param view
     */
    public void btnHistory(View view){
        Intent j = new Intent(MainActivity.this,SwipeRight.class);
        startActivity(j);
    }
}