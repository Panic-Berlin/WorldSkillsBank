package ru.arsik.a12012021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
    }

    private AlertDialog dialog;
    public void onPasswordRemoveClick(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.DarkDialog);
        dialogBuilder.setView(R.layout.password_remove_item);
        dialogBuilder.setTitle("Изменение пароля");
        dialog = dialogBuilder.create();
        dialog.show();
    }

    public void onLoginRemoveClick(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.DarkDialog);
        dialogBuilder.setView(R.layout.login_remove_item);
        dialogBuilder.setTitle("Изменение логина");
        dialog = dialogBuilder.create();
        dialog.show();
    }

    public void onLoginRemoveCancelClick(View view) {
        dialog.hide();
    }

    public void onPasswordRemoveCancelClick(View view) {
        dialog.hide();
    }

    public void onHistoryClick(View view) {
        Intent intent = new Intent(this, ActivityVisitHistory.class);
        startActivity(intent);
    }

    public void onInfoClick(View view) {
        Intent intent = new Intent(this, InfoApplicationActivity.class);
        startActivity(intent);
    }
}