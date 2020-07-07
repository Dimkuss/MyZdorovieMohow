package com.example.myzdorovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText inputName;
    EditText inputAge;
    ArrayList<Person> valuesMain = new ArrayList<>();
    private static final String TAG = "MyApp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = findViewById(R.id.inputName);
        inputAge = findViewById(R.id.inputAge);
        init();
    }

    public void init() {

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку Сохранить");
                String userSurnameValue = inputName.getText().toString();
                String userAgeValue = inputAge.getText().toString();


                try {
                    int ageUserValueInt = Integer.parseInt(userAgeValue);
                    Person person = new Person(userSurnameValue, ageUserValueInt);
                    valuesMain.add(person);
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Введены неверные данные", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Получено исключение", ex);
                }


            }
        });
        Button btnPressure = findViewById(R.id.btnPressure);
        btnPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });
        Button btnLife = findViewById(R.id.btnLifeStatus);
        btnLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LifeActivity.class);
                startActivity(intent);
            }
        });
    }
}