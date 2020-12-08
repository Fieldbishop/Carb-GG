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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    float x1, x2, y1, y2;                                                   // values for swipe
    private TextView tv;
    private ListView lv;
    float totalCarbs = 0, insulinEfficiency = 1;
    private String defaultMsg = "Please enter meals";
    ArrayAdapter<Meal> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                ListToSend.getInstance().removeOne(position);
                adapter.notifyDataSetChanged();
            }
        });

    }
    public void btnCalculate(View view) {

        for(int i=0; i<ListToSend.getInstance().getNames().size(); i++){
            Meal mealToAdd = ListToSend.getInstance().getNames().get(i);
            Float carbsOfMealToAdd=mealToAdd.getMealCarbs();
            totalCarbs += carbsOfMealToAdd;
            Log.d("test",String.valueOf(totalCarbs));

        }

        SharedPreferences prefGet = getSharedPreferences("configs.txt" , Context.MODE_PRIVATE);
        float insulinEfficiency = prefGet.getFloat("inEfKey", Context.MODE_PRIVATE);
        float insulinAmount = (totalCarbs / 10) * insulinEfficiency;
        if (insulinAmount == 0){
            insulinAmount = (totalCarbs / 10) * 1;
        }
        String insulinDisplay = Float.toString(insulinAmount);
        tv.setText("Suggested amount of insulin intake: "+ insulinDisplay+ " units");

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        SingletonClassHistory.getInstance().addNew(date,totalCarbs);
        ListToSend.getInstance().eraseList();
    }
























    public boolean onTouchEvent(MotionEvent touchevent){                    //ghetto swipe 2001
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

    public void btnSettings(View view) {
        Intent j = new Intent(MainActivity.this,SettingsPage.class);
        startActivity(j);
    }

    public void btnMeals(View view){
        Intent j = new Intent(MainActivity.this,SwipeLeft.class);
        startActivity(j);
    }

    public void btnHistory(View view){
        Intent j = new Intent(MainActivity.this,SwipeRight.class);
        startActivity(j);
    }
}