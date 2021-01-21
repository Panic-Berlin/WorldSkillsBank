package ru.arsik.a12012021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class ReplenishCardActivity extends AppCompatActivity {
    AppCompatRadioButton rbLeft, rbRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replenish_card);
        getSupportActionBar().hide();
        rbLeft = findViewById(R.id.rbLeft);
        rbRight = findViewById(R.id.rbRight);
        getSupportActionBar().hide();
    }

    public void onRadioButtonClicked(View view) {
        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.rbLeft:
                if (isSelected){
                    rbRight.setTextColor(getColor(R.color.radio_button));
                    rbLeft.setTextColor(Color.WHITE);
                }
                break;
            case  R.id.rbRight:
                if (isSelected){
                rbRight.setTextColor(Color.WHITE);
                rbLeft.setTextColor(getColor(R.color.radio_button));
                    Intent intent = new Intent(this, PayActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    public void onCardsPayClick(View view) {
        Intent intent = new Intent(this, PayActivity.class);
        startActivity(intent);
    }
}