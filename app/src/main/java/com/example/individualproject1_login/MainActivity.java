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
    String savedFirstname;
    String savedLastname;
    String savedEmail;
    String savedDOB;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent recString = getIntent();
        savedUsername = recString.getStringExtra("savedUsername");
        savedPassword = recString.getStringExtra("savedPassword");
        savedFirstname = recString.getStringExtra("savedFirstName");
        savedLastname = recString.getStringExtra("savedLastName");
        savedEmail = recString.getStringExtra("savedEmail");
        savedDOB = recString.getStringExtra("savedDOB");



    }

    //move to create account activity if create account button is clicked
    public void goToCreateAccount(View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        this.startActivity(intent);

    }


    //create dialog to allow user to login
    public void showDialog(View view){
        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog);

        usernameEdit = dialog.findViewById(R.id.username_field);
        passwordEdit = dialog.findViewById(R.id.password_field);

        dialog.show();
    }

    //check if credentials match, if so proceed to final activity
    public void checkCredentials(View view){
        tempUsername = usernameEdit.getText().toString();
        tempPassword = passwordEdit.getText().toString();

        //if credentials match, proceed to next activity
        if(tempUsername.equals(savedUsername) && tempPassword.equals(savedPassword)){
            successfulLogin(view);
        }
        else {
            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_LONG).show();
        }

    }

    public void successfulLogin(View view){
        Intent intent = new Intent(this, AccessActivity.class);
        intent.putExtra("firstName", savedFirstname);
        intent.putExtra("lastName", savedLastname);
        intent.putExtra("email", savedEmail);
        intent.putExtra("dob", savedDOB);
        intent.putExtra("username", savedUsername);
        this.startActivity(intent);
    }
}