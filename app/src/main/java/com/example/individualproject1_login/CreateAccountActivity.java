package com.example.individualproject1_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class CreateAccountActivity extends AppCompatActivity {
    EditText firstNameEdit;
    EditText lastNameEdit;
    EditText dobEdit;
    EditText emailEdit;
    EditText userNameEdit;
    EditText passwordEdit;
    String firstName;
    String lastName;
    String dob;
    String email;
    String userName;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //assign edittext fields
        firstNameEdit = (EditText) findViewById(R.id.first_name_field);
        lastNameEdit = (EditText) findViewById(R.id.last_name_field);
        dobEdit = (EditText) findViewById(R.id.dob_field);
        emailEdit = (EditText) findViewById(R.id.email_field);
        userNameEdit = (EditText) findViewById(R.id.username_field_edit);
        passwordEdit = (EditText) findViewById(R.id.password_field_edit);

        firstName = getResources().getString(R.string.first_name);
        lastName = getResources().getString(R.string.last_name);
        dob = getResources().getString(R.string.dob);
        email = getResources().getString(R.string.email);
        userName = "";
        password = "";

    }

    public void saveData(View view) {
        //as long as fields are not blank, save data as strings and return to login page
        if (!fieldEmpty(firstNameEdit) && !fieldEmpty(lastNameEdit) && !fieldEmpty(dobEdit) && !fieldEmpty(emailEdit) && !fieldEmpty(userNameEdit) && !fieldEmpty(passwordEdit)) {
            firstName = firstNameEdit.getText().toString();
            lastName = lastNameEdit.getText().toString();
            dob = dobEdit.getText().toString();
            userName = userNameEdit.getText().toString();
            email = emailEdit.getText().toString();
            password = passwordEdit.getText().toString();
            returnToLogin(view); //return to login page
        } else {
            Toast.makeText(CreateAccountActivity.this, "Cannot leave any fields blank", Toast.LENGTH_LONG).show(); //prompt user to not leave fields blank
            highlightEmptyFields(firstNameEdit);
            highlightEmptyFields(lastNameEdit);
            highlightEmptyFields(dobEdit);
            highlightEmptyFields(emailEdit);
            highlightEmptyFields(userNameEdit);
            highlightEmptyFields(passwordEdit);
        }
    }


    //return to login screen if form filled out properly
    public void returnToLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("savedUsername", userName);
        intent.putExtra("savedPassword", password);
        this.startActivity(intent);

    }

    //check if field is empty or not
    public boolean fieldEmpty(EditText field) {
        String fieldText = field.getText().toString();
        boolean result = false;
        if (fieldText.matches("")) // if field is empty
            result = true;
        return result;
    }

    //highlight any empty fields red
    public void highlightEmptyFields(EditText field) {
        String fieldText = field.getText().toString();

        if (fieldText.matches("")) { // if field is empty
            field.setBackgroundColor(getResources().getColor(R.color.red));
        }
        else{
            field.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }
}