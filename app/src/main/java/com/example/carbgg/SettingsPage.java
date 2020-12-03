package com.example.carbgg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SettingsPage extends AppCompatActivity {
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        et=findViewById(R.id.etCoefficient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    public void btnSaveCoefficient(View view) {
        float coefficient = Float.parseFloat(et.getText().toString());
        Settings config = new Settings(coefficient);
        Intent j = new Intent(SettingsPage.this,MainActivity.class);
        startActivity(j);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}