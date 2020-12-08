package com.example.carbgg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SwipeRight extends AppCompatActivity {

    float x1, x2, y1, y2;                                                   // values for swipe
    LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_right);
        chart = (LineChart) findViewById(R.id.chart);
        LineDataSet LineDataSet1 = new LineDataSet(dataSet1(),"Data Set 1");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(LineDataSet1);

        LineData data = new LineData(dataSets);
        chart.setData(data);
        chart.invalidate();
    }
    

    private ArrayList<Entry> dataSet1(){

        ArrayList<Entry> pointdata = new ArrayList<Entry>();
        ListToSend.getInstance().getNames();

        for(int i=0; i<SingletonClassHistory.getInstance().getAll().size(); i++){
            DataPointToSave datapoint = SingletonClassHistory.getInstance().getAll().get(i);
            Float carbs=datapoint.getCarbs();
            String date=datapoint.getTime();
            pointdata.add(new Entry(i,carbs));

        }
        return pointdata;
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
                    Intent i = new Intent(SwipeRight.this, MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                }
                break;
        }
        return false;
    }
    public void btnCalculator(View view){
        Intent j = new Intent(SwipeRight.this,MainActivity.class);
        startActivity(j);
    }
    public void btnMeals(View view){
        Intent j = new Intent(SwipeRight.this,SwipeLeft.class);
        startActivity(j);
    }
}