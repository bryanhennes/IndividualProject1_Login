package com.example.individualproject1_login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usernameEdit;
    EditText passwordEdit;
    String tempUsername;
    String tempPassword;
    String savedUsername;
    String savedPassword;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent recString = getIntent();
        savedUsername = recString.getStringExtra("savedUsername");
        savedPassword = recString.getStringExtra("savedPassword");

    }

    public void goToCreateAccount(View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        this.startActivity(intent);

    }

    public void showDialog(View view){
        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog);

        usernameEdit = dialog.findViewById(R.id.username_field);
        passwordEdit = dialog.findViewById(R.id.password_field);

        tempUsername = usernameEdit.getText().toString();
        tempPassword = passwordEdit.getText().toString();

        dialog.show();
    }

    //stuck in a loop
    public void checkCredentials(View view){

        if(tempUsername == savedUsername && tempPassword == savedPassword){
            successfulLogin(view);
            dialog.dismiss();
        }
        else {
            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();
        }

    }

    public void successfulLogin(View view){
        Intent intent = new Intent(this, AccessActivity.class);
        this.startActivity(intent);
    }
}