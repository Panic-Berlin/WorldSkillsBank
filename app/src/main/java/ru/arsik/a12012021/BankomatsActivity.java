package ru.arsik.a12012021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import ru.arsik.a12012021.adapter.BankomatsAdapter;
import ru.arsik.a12012021.course.ValuteTask;

public class BankomatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankomats);
        RecyclerView recyclerView = findViewById(R.id.bankomats_list);
        getSupportActionBar().hide();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ValuteTask valuteTask = new ValuteTask(valutes -> {
           recyclerView.setAdapter(new BankomatsAdapter());
        });
        valuteTask.execute();
    }
}