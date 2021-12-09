package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.vishnusivadas.advanced_httpurlconnection.PutData;


/**
 * this class is used as the login page , it is the first page that the user meets
 */
public class MainActivity extends AppCompatActivity {

    EditText loginUsername,loginPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = findViewById(R.id.startbtn);
        Button registerBtnMM = findViewById(R.id.RegisterBtnMM);

        /*this listener for register button is used to open the registeration page */
        registerBtnMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRG();
            }
        });

        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);

    /* this start button listener is used to login */
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Password = String.valueOf(loginPassword.getText());
                final String Username = String.valueOf(loginUsername.getText());

                //Start ProgressBar first (Set visibility VISIBLE)
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[2];
                        field[0] = "username";
                        field[1] = "password";
                        //Creating array for data
                        String[] data = new String[2];
                        data[0] = Username;
                        data[1] = Password;

                        PutData putData = new PutData("http://192.168.1.13/LoginRegister/login.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if(result.equals("Login Success")){
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

                                    /* when login is success go to the main menu page */
                                    Intent intent = new Intent(getApplicationContext(),activityMM.class);
                                    final EditText  edUsername  = findViewById(R.id.loginUsername);
                                    intent.putExtra("username",edUsername.getText().toString());//is used to get the username to the main menu page
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                    }
                });
            }
        });
    }//end of onCreate

    /**
     * this method is used to open the register page
     */
    public void openActivityRG(){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }

    public void showHelp(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Enter your credentials and press Start button to begin with the lesson.", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
