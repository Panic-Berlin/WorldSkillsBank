package ru.arsik.a12012021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CardsActivity extends AppCompatActivity {

    private TextView cardBlock;
    private ImageView cardImage;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        getSupportActionBar().hide();

        cardBlock = findViewById(R.id.tv_cardBlock);
        cardImage = findViewById(R.id.iv_card_icon);

        Intent intent = getIntent();
        if (intent != null){
            int image = intent.getIntExtra("image", R.drawable.mir_card_icon);

            cardImage.setImageResource(image);
        }
    }
    private AlertDialog dialog;
    public void onBlockClick(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.DarkDialog);
        dialogBuilder.setView(R.layout.card_block_item);
        dialogBuilder.setTitle("Блокировка карты");
        dialog = dialogBuilder.create();
        dialog.show();
    }

    public void onCardBlockClick(View view) {
        password = dialog.findViewById(R.id.cardPassword);
        if (password.getText().toString().equals("admin")){
            cardBlock.setText("Карта заблокирована");
            dialog.hide();
        }

    }

    public void onCardCancelClick(View view) {
        dialog.hide();
    }


    public void onOperationHistory(View view) {
        Intent intent = new Intent(this, OperationHistoryActivity.class);
        startActivity(intent);
    }
    private AlertDialog renameDialog;
    public void onRenameCancelClick(View view) {
        renameDialog.hide();
    }

    public void onRenameOptionClick(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.DarkDialog);
        dialogBuilder.setView(R.layout.rename_item);
        dialogBuilder.setTitle("Переименование счета");
        renameDialog = dialogBuilder.create();
        renameDialog.show();
    }

    public void onRenameClick(View view) {
        renameDialog.hide();
    }

    public void onReplenishClick(View view) {
        Intent intent = new Intent(this, ReplenishCardActivity.class);
        startActivity(intent);
    }
}