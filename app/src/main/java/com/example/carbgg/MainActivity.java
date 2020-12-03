package com.example.carbgg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    float x1, x2, y1, y2;                                                   // values for swipe

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                }
                break;
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
