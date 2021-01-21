package ru.arsik.a12012021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class InfoApplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_application);
        getSupportActionBar().hide();
    }

    public void onTermsOfUseClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.avangard.ru/rus/docs/rules_cart_use_in_system_mobile_pays.pdf"));
        startActivity(intent);
    }
}