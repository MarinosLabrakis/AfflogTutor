package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


/**
 * this class is used to dynamically change the layout of the profile page
 * depending the button /text we click the layout changes to the correpsonding one.
 * e.x. if i click the profile (text) the layout that is VISIBLE is the one that is used for the profile
 */
public class user_settings extends AppCompatActivity {

    int mode;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_settings);

        //simple if to determine where i go next
        if(getIntent()!=null && getIntent().getExtras()!=null){
            if(getIntent().getStringExtra("profile") != null){
                mode = 1;
            }else if(getIntent().getStringExtra("settings") != null){
                mode = 2;
            }else if(getIntent().getStringExtra("notifications") != null){
                mode = 3;
            }else {
                Toast.makeText(user_settings.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
            }
        }

        /* all the items are invisible when we start */

        //profile attributes
        TextView TitleTxt = findViewById(R.id.TitleTxt);
        Spinner dropdown = findViewById(R.id.GenderSpinner);
        TextView firstname = findViewById(R.id.TextPersonFName);
        TextView lastname = findViewById(R.id.TextPersonLName);
        TextView birthdate = findViewById(R.id.TextDate);
        TextView mobile = findViewById(R.id.TextPhone);
        firstname.setVisibility(View.GONE);
        lastname.setVisibility(View.GONE);
        birthdate.setVisibility(View.GONE);
        mobile.setVisibility(View.GONE);
        dropdown.setVisibility(View.GONE);

        //setting attributes
        TextView AccountSetTxt = findViewById(R.id.AccountSetTxt);
        TextView ChngPassTxt = findViewById(R.id.ChngPassTxt);
        TextView NotificationsTxt = findViewById(R.id.NotificationsTxt);
        TextView SecurityTxt = findViewById(R.id.SecurityTxt);
        TextView HelpTxt = findViewById(R.id.HelpTxt);
        AccountSetTxt.setVisibility(View.GONE);
        ChngPassTxt.setVisibility(View.GONE);
        NotificationsTxt.setVisibility(View.GONE);
        SecurityTxt.setVisibility(View.GONE);
        HelpTxt.setVisibility(View.GONE);

        //about us
        TextView txtAboutus = findViewById(R.id.txtAboutus);
        txtAboutus.setVisibility(View.GONE);
        //contact us
        TextView ContactTxt = findViewById(R.id.ContactTxt);
        ContactTxt.setVisibility(View.GONE);
        TextView ContactTtitle = findViewById(R.id.ContactTtitle);
        ContactTtitle.setVisibility(View.GONE);

        //we get the mode from the if we encountered above
        switch (mode){
            case 1: //PROFILE menu case
                TitleTxt.setText("Profile");
                firstname.setVisibility(View.VISIBLE);
                lastname.setVisibility(View.VISIBLE);
                birthdate.setVisibility(View.VISIBLE);
                mobile.setVisibility(View.VISIBLE);
                dropdown.setVisibility(View.VISIBLE);
                String[] items = new String[]{" ","Male", "Female"};
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
                dropdown.setAdapter(adapter);
                break;
            case 2: //SETTINGS  menu case
                TitleTxt.setText("Settings");
                TitleTxt.setVisibility(View.GONE);
                AccountSetTxt.setVisibility(View.VISIBLE);
                ChngPassTxt.setVisibility(View.VISIBLE);
                NotificationsTxt.setVisibility(View.VISIBLE);
                SecurityTxt.setVisibility(View.VISIBLE);
                HelpTxt.setVisibility(View.VISIBLE);
                break;
            case 3: // ABOUT US menu case
                TitleTxt.setText("About Us");
                txtAboutus.setVisibility(View.VISIBLE);
                ContactTxt.setVisibility(View.VISIBLE);
                ContactTtitle.setVisibility(View.VISIBLE);
                break;
        }
    }//end of onCreate
}//end of class
