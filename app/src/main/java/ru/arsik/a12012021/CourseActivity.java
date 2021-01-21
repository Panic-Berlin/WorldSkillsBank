package ru.arsik.a12012021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ru.arsik.a12012021.adapter.CourseAdapter;
import ru.arsik.a12012021.course.ValuteTask;

public class CourseActivity extends AppCompatActivity {

    private TextView courseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        LocalDateTime dateTime = LocalDateTime.now();
        courseData = findViewById(R.id.course_data);
        courseData.setText(dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        getSupportActionBar().hide();
        RecyclerView recyclerView =findViewById(R.id.course_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ValuteTask valuteTask = new ValuteTask(valutes -> {
            recyclerView.setAdapter(new CourseAdapter(valutes));
        });
        valuteTask.execute();
    }

}
