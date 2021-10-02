package com.example.individualproject1_login;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AccessActivity extends AppCompatActivity {
    String userName;
    String firstName;
    String lastName;
    String DOB;
    String email;

    TextView displayInfoTitle;
    TextView displayInfoFirstName;
    TextView displayInfoLastName;
    TextView displayInfoEmail;
    TextView displayInfoDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);
        Intent recString = getIntent();
        userName = recString.getStringExtra("username");
        firstName =recString.getStringExtra("firstName");
        lastName = recString.getStringExtra("lastName");
        email = recString.getStringExtra("email");
        DOB = recString.getStringExtra("dob");

        displayInfoTitle = (TextView) findViewById(R.id.access_display_info);
        displayInfoFirstName = (TextView) findViewById(R.id.access_display_firstName);
        displayInfoLastName = (TextView) findViewById(R.id.access_display_lastName);
        displayInfoEmail = (TextView) findViewById(R.id.access_display_email);
        displayInfoDOB = (TextView) findViewById(R.id.access_display_DOB);

        displayInfoTitle.setText(getResources().getString(R.string.welcome) + userName);
        displayInfoFirstName.setText(getResources().getString(R.string.display_firstName) + firstName);
        displayInfoLastName.setText(getResources().getString(R.string.display_lastName) + lastName);
        displayInfoEmail.setText(getResources().getString(R.string.display_email) + email);
        displayInfoDOB.setText(getResources().getString(R.string.display_DOB) + DOB);
    }


}