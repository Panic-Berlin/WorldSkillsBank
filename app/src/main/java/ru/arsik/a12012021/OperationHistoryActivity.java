package ru.arsik.a12012021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class OperationHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_history);
        getSupportActionBar().hide();
    }
}