package ru.arsik.a12012021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ru.arsik.a12012021.course.Valute;
import ru.arsik.a12012021.course.ValuteTask;

public class MainActivity extends AppCompatActivity {

    private TextView mainData;
    private TextView usd;
    private TextView eur;
    private EditText login;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainData = findViewById(R.id.tv_main_data);
        LocalDateTime dateTime = LocalDateTime.now();
        mainData.setText(dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        usd = findViewById(R.id.tv_usd);
        eur = findViewById(R.id.tv_eur);
        login = findViewById(R.id.et_login);
        password = findViewById(R.id.et_password);

        getSupportActionBar().hide();

        ValuteTask valuteTask = new ValuteTask(valutes -> {
            if (!valutes.isEmpty()){
                for (Valute valute : valutes){
                    if (valute.getCharCode().equals("USD")){
                        usd.setText(String.format("%.1f", valute.getValue()));
                    }
                    if (valute.getCharCode().equals("EUR")){
                        eur.setText(String.format("%.1f", valute.getValue()));
                    }
                }
            }
        });

        valuteTask.execute();


    }

    private AlertDialog dialog;
    public void onLoginClick(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.DarkDialog);
        dialogBuilder.setView(R.layout.login_item);
        dialogBuilder.setTitle("Авторизация");
        dialog = dialogBuilder.create();
        dialog.show();


    }

    public void onCourseClick(View view) {
        Intent intent = new Intent(this, CourseActivity.class);
        startActivity(intent);
    }

    public void onLocationClick(View view) {
        Intent intent = new Intent(this, BankomatsActivity.class);
        startActivity(intent);
    }

    public void onAddClick(View view) {
        login = dialog.findViewById(R.id.et_login);
        password = dialog.findViewById(R.id.et_password);
        if (login.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            Intent intent = new Intent(this, NavigationActivity.class);
            startActivity(intent);
            dialog.hide();
        }
        else {
            Toast.makeText(this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
        }

    }

    public void onCancelClick(View view) {
        dialog.hide();
    }
}