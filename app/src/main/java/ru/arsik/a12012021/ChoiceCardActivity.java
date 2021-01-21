package ru.arsik.a12012021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ChoiceCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_card);
        getSupportActionBar().hide();
    }
}