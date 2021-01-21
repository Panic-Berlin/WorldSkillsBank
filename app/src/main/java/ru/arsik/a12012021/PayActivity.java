package ru.arsik.a12012021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {

    private EditText sum;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        getSupportActionBar().hide();
        sum = findViewById(R.id.et_sum);
        password = findViewById(R.id.password_check);
    }

    private AlertDialog dialog;
    public void onPayClick(View view) {
        if (sum.getText().toString().equals("")){
            Toast.makeText(this, "Поле \"Сумма\" не должно быть пустым", Toast.LENGTH_SHORT).show();
        }
        else{
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.DarkDialog);
            dialogBuilder.setView(R.layout.check_confirmation_item);
            dialogBuilder.setTitle("Подтверждение");
            dialog = dialogBuilder.create();
            dialog.show();
        }
    }

    public void onCheckClick(View view) {
        password = dialog.findViewById(R.id.password_check);
        if (password.getText().toString().equals("admin")){
            Intent intent = new Intent(this, ChoiceCardActivity.class);
            startActivity(intent);
            dialog.hide();
        }
        else {
            Toast.makeText(this, "Не верный пароль", Toast.LENGTH_SHORT).show();
        }

    }

    public void onCheckCancelClick(View view) {
        dialog.hide();
    }



}