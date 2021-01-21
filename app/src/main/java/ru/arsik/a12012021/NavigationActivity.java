package ru.arsik.a12012021;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import static ru.arsik.a12012021.R.drawable.master_card_icon;
import static ru.arsik.a12012021.R.drawable.mir_card_icon;
import static ru.arsik.a12012021.R.drawable.visa_card_icon;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_pays, R.id.navigation_history, R.id.navigation_dialog)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        getSupportActionBar().hide();
    }

    public void onProfileClick(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }


    public void onMirClick(View view) {

        Intent intent = new Intent(this, CardsActivity.class);
        intent.putExtra("image", mir_card_icon);
        startActivity(intent);
    }

    public void onMasterCardClick(View view) {
        Intent intent = new Intent(this, CardsActivity.class);
        intent.putExtra("image", master_card_icon);
        startActivity(intent);
    }

    public void onVisaCardClick(View view) {
        Intent intent = new Intent(this, CardsActivity.class);
        intent.putExtra("image", visa_card_icon);
        startActivity(intent);
    }

    public void onConnectionClick(View view) {
        Intent intent = new Intent(this, ContractPayActivity.class);
        startActivity(intent);
    }

    public void onTemplateClick(View view) {
        Intent intent = new Intent(this, TemplateListActivity.class);
        startActivity(intent);
    }
}