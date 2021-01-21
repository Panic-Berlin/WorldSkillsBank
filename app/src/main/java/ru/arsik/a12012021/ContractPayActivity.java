package ru.arsik.a12012021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ContractPayActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText password;
    private EditText sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract_pay);
        getSupportActionBar().hide();
        password = findViewById(R.id.et_confirm_password);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.cards, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setPrompt("Карта");
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        sum = findViewById(R.id.et_contract_sum);
    }
    private AlertDialog dialog;
    public void onPayConnectionClick(View view) {
        if (sum.getText().toString().equals("")){
            Toast.makeText(this, "Поле \"Сумма\" не должно быть пустым", Toast.LENGTH_SHORT).show();
        }
        else {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.DarkDialog);
        dialogBuilder.setView(R.layout.password_connection_pay);
        dialogBuilder.setTitle("Подтверждение");
        dialog = dialogBuilder.create();
        dialog.show();
        }
    }

    public void onConfirmPasswordClick(View view) {
        password = dialog.findViewById(R.id.et_confirm_password);
        if (password.getText().toString().equals("admin")){
            Toast.makeText(this, "Платеж прошел", Toast.LENGTH_SHORT).show();
            dialog.hide();
        }
    }

    public void onConfirmCancelClick(View view) {
        dialog.hide();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}