package com.example.carbgg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Float.valueOf;

public class NewMealActivity extends AppCompatActivity {

    private EditText mEditMealView;
    private EditText mEditCarbsView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meal);

        mEditMealView = findViewById(R.id.editTextMealName);
        mEditCarbsView = findViewById(R.id.editTextMealCarbs);

        final Button button = findViewById(R.id.buttonSave);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditMealView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String mealName = mEditMealView.getText().toString();
                float mealCarbs = Float.parseFloat(mEditCarbsView.getText().toString());
                replyIntent.putExtra("mealName", mealName);
                replyIntent.putExtra("mealCarbs", mealCarbs);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}