package com.arvindranjit.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    //Declaration EditTexts
    EditText editTextUserName;
    EditText editTextPassword;
    TextView RegisterTV;


    //Declaration Button
    Button buttonLogin;

    //Declaration SqliteHelper
    SQLiteHelper sqliteHelper;

    SharedPreferences loginstatus;
    SharedPreferences Settings;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqliteHelper = new SQLiteHelper(this);
       initViews();





        loginstatus = getApplicationContext()
                .getSharedPreferences("login", MODE_PRIVATE);

        final SharedPreferences.Editor editorlogin = loginstatus.edit();

        if (loginstatus.getString("username", null) == null ||
                loginstatus.getInt("login", 0) == 0) {
            editorlogin.putInt("login",0);



            editorlogin.commit();

        } else if (loginstatus.getInt("login",0)==1) {


            Intent newIntent2 = new Intent(MainActivity.this, Menu.class);
            MainActivity.this.startActivity(newIntent2);
            finish();




        }






        RegisterTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(MainActivity.this, Registration.class);
                MainActivity.this.startActivity(newIntent);

            }
        });

        //set click event of login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check user input is correct or not


                //Get values from EditText fields
                String UserName = editTextUserName.getText().toString();
                String Password = editTextPassword.getText().toString();
              // String UserName = "Arvind";
                //String Password = "passwgdgford";



                //Authenticate user
                User currentUser = sqliteHelper.Authenticate(new User(null, UserName, null, Password));

                //Check Authentication is successful or not
                if (currentUser != null) {
                    Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();

                    editorlogin.putInt("login",1);
                    editorlogin.putString("username",UserName);

                    editorlogin.commit();




                    Intent newIntent2 = new Intent(MainActivity.this, Menu.class);
                    MainActivity.this.startActivity(newIntent2);
                    finish();


                } else {

                    //User Logged in Failed
                    Snackbar.make(buttonLogin, "Failed to log in , please check credentials", Snackbar.LENGTH_LONG).show();

                }

            }
        });


    }


    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        RegisterTV = findViewById(R.id.RegisterTextView);

    }




}
