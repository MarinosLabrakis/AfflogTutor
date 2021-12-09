package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * this class is used for the profile page ,
 * we can use it to store profile options / settings and notifications
 *
 */
public class Profile extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Button Logout = findViewById(R.id.LogoutBtn);

        TextView textProfile = findViewById(R.id.ProfileTxt);
        ImageView ImgProfile = findViewById(R.id.ProfileBtnImg);

        TextView SettingText = findViewById(R.id.SettingText);
        ImageView SettingsBtnImg = findViewById(R.id.SettingsBtnImg);

        TextView AboutUsTxt = findViewById(R.id.AboutUsTxt);
        ImageView AboutUsBtnImg = findViewById(R.id.AboutUsBtnImg);
        //TODO add profile/settings/notifications activity


        //TODO change profile pic

        /* opens profile menu */
        ImgProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                openProfile();
            }
        });
        /* opens profile menu */
        textProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                openProfile();
            }
        });

        /* open settings menu */
        SettingsBtnImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                openSettings();
            }
        });
        /* open settings menu */
        SettingText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                openSettings();
            }
        });

        /*open about us menu */
        AboutUsBtnImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                openNotifications();
            }
        });
        /*open about us menu */
        AboutUsTxt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                openNotifications();
            }
        });

        /*this button is used for the user to logout of the app */
        Logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                logoutActivity();
            }
        });

    }

    /**
     * logout method when called ,opens the first page activity
     */
    public void logoutActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * open profile method , when called open's the profile menu
     */
    public void openProfile(){
        Intent intent = new Intent(this, user_settings.class);
        intent.putExtra("profile","profile");
        startActivity(intent);
    }

    /**
     * settings method , when called open's the settings menu
     */
    public void openSettings(){
        Intent intent = new Intent(this, user_settings.class);
        intent.putExtra("settings","settings");
        startActivity(intent);

    }

    /**
     * notification menu
     */
    public void openNotifications(){
        Intent intent = new Intent(this, user_settings.class);
        intent.putExtra("notifications","notifications");
        startActivity(intent);
    }

}//end of class
