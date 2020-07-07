package com.example.myzdorovie;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PressureActivity extends AppCompatActivity {
    EditText upPressure;
    EditText downPressure;
    EditText inputPulse;
    EditText inputDate;
    CheckBox tachycardia;
    ArrayList<Pressure> valuesPressure = new ArrayList<>();
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        upPressure = findViewById(R.id.upPressure);
        downPressure = findViewById(R.id.downPressure);
        inputPulse = findViewById(R.id.inputPulse);
        inputDate = findViewById(R.id.inputDate);
        tachycardia = findViewById(R.id.checkTachycardia);

        init();
    }

    private void init() {

        Button btnSave = findViewById(R.id.btnSavePressure);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");
                String userUpPressure = upPressure.getText().toString();
                String userDownPressure = downPressure.getText().toString();
                String userPulse = inputPulse.getText().toString();
                LocalDate dateValue = LocalDate.now();
                inputDate.setText(dateValue.toString());
                String tachycardiaBox = tachycardia.getText().toString();


                try {
                    int userUpPressureValueInt = Integer.parseInt(userUpPressure);
                    int userDownPressureValueInt = Integer.parseInt(userDownPressure);
                    int userPulseValueInt = Integer.parseInt(userPulse);
                    Pressure pressure = new Pressure(userUpPressureValueInt, userDownPressureValueInt,
                            userPulseValueInt, Boolean.parseBoolean(tachycardiaBox), dateValue);
                    valuesPressure.add(pressure);


                } catch (Exception ex) {
                    Toast.makeText(PressureActivity.this, "Введены неверные данные", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Получено исключение", ex);
                }
            }
        });
    }
}