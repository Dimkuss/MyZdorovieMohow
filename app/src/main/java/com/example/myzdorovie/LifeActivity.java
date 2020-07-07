package com.example.myzdorovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class LifeActivity extends AppCompatActivity {
    EditText userWeight;
    EditText userSteps;
    ArrayList<Life> valuesMain = new ArrayList<>();
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        userWeight = findViewById(R.id.inputWeight);
        userSteps = findViewById(R.id.inputSteps);
        init();
    }

    private void init() {

        Button btnSave = findViewById(R.id.btnSaveLife);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");
                String userWeightValue = userWeight.getText().toString();
                String userStepsValue = userSteps.getText().toString();
                try {
                    double userWeightValueD = Double.parseDouble(userWeightValue);
                    int userStepsValueI = Integer.parseInt(userStepsValue);
                    Life life = new Life(userWeightValueD, userStepsValueI);
                    valuesMain.add(life);
                } catch (Exception ex) {
                    Toast.makeText(LifeActivity.this, "Введены неверные данные", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Получено исключение", ex);
                }
            }
        });
    }
}