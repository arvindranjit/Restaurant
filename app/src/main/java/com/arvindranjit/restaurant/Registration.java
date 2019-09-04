package com.arvindranjit.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Registration extends AppCompatActivity {

    //Declaration EditTexts
    EditText editTextUserName;
    EditText editTextName;
    EditText editTextPassword;
    EditText editTextCPassword;


    //Declaration Button
    Button buttonRegister;

    //Declaration SqliteHelper
    SQLiteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        sqliteHelper = new SQLiteHelper(this);
        initViews();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String UserName = editTextUserName.getText().toString();
                    String Name = editTextName.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    //Check in the database is there any user associated with  this email
                    if (!sqliteHelper.isUserNameExists(UserName)) {

                        //Email does not exist now add new user to database
                        sqliteHelper.addUser(new User(null, UserName, Name, Password));
                        Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                        Intent newIntent2 = new Intent(Registration.this, MainActivity.class);
                        Registration.this.startActivity(newIntent2);
                        finish();

                    }else {

                        //Email exists with email input provided so show error user already exist
                        Snackbar.make(buttonRegister, "User already exists with same email ", Snackbar.LENGTH_SHORT).show();
                    }


            }
        });
    }



    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextCPassword = (EditText) findViewById(R.id.editTextCPassword);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        buttonRegister = (Button) findViewById(R.id.registerButton);

    }









    }


