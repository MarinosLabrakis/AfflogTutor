package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

/**
 * this class is used for the registeration of the user to the DB
 */
public class Register extends AppCompatActivity {

    EditText username,email,password;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button RegisterBtn;
        username = findViewById(R.id.Username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        RegisterBtn = findViewById(R.id.RegisterBtn);
        TextView textLogin = findViewById(R.id.alreadyAcc);

        /*this listener is used for the login text and opens the first page (login page ) when used */
        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //handling register button
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String  Email,Password,Username;
                Email = String.valueOf(email.getText());
                Password = String.valueOf(password.getText());
                Username = String.valueOf(username.getText());

                /* check if the username , password and email are empty */
                if (!Username.equals("") && !Password.equals("") && !Email.equals("")) {

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[3];
                            field[0] = "email";
                            field[1] = "username";
                            field[2] = "password";
                            //Creating array for data
                            String[] data = new String[3];
                            data[0] = Email;
                            data[1] = Username;
                            data[2] = Password;

                            PutData putData = new PutData("http://192.168.1.13/LoginRegister/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                   // if (result.equals("Sign Up Success")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                //    } else {
                                //        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                  //  }

                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }else {
                    Toast.makeText(getApplicationContext(),"All fields required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }//end of onCreate

}//end of class
