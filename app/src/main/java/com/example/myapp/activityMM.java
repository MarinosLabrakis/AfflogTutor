package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.FetchData;
import com.vishnusivadas.advanced_httpurlconnection.PutData;



/**
 * this class is originaly the main menu of the application , everything starts here
 */
public class activityMM extends AppCompatActivity  {

    @SuppressLint("StaticFieldLeak")
    private static ImageView imageView;
    @SuppressLint("StaticFieldLeak")
   // private static Button changebtn01,changebtn02;
    private int curr_img;
    @SuppressLint("StaticFieldLeak")
    private static TextView emotiontext,dimensiontext;
    private int counter = 0;
    private int dimFlag = 0;
    Button infoBtn;
    int[] images = {R.drawable.joyful, R.drawable.happy, R.drawable.delightful, R.drawable.confused, R.drawable.upset, R.drawable.angry};// add all emotions states;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mm);


        emotionChange();
        dimensionChange();

        /* this textview is used to display the username in the main menu page */
        final TextView tv = findViewById(R.id.UsernameTxt);
        username=getIntent().getExtras().getString("username");
        tv.setText(String.format("%s", username));//Welcome <User>



        infoBtn = findViewById(R.id.InfoBtn);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHelp(v);
            }});

        /* this listener is for the EXECUTE button */
        /*when we click the execute button we use clingo to create the plan for the user */
        /* if the user already exist we don't */
        Button execBtn = findViewById(R.id.execBtn);
        execBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        String myUrl = null;
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        /*we use this if to determine the users current mood */
                       if(emotiontext.getText() == "neutral") { //neutral (DEFAULT)
                           myUrl = "http://192.168.1.13/clingo/clingo2.php";
                       }else if (emotiontext.getText() == "flow"){ //flow
                               myUrl = "http://192.168.1.13/clingo/clingo2.php" ;
                       }else if (emotiontext.getText() == "confusion"){ //confusion
                           myUrl = "http://192.168.1.13/clingo/clingo2.php" ;
                       }else if (emotiontext.getText() == "joy" ){ //Confused
                           myUrl = "http://192.168.1.13/clingo/clingo2.php" ;
                       }else if(emotiontext.getText() == "surprise") { //surprise
                           myUrl = "http://192.168.1.13/clingo/clingo2.php" ;
                       }else if(emotiontext.getText() == "frustration") { // frustration
                           myUrl = "http://192.168.1.13/clingo/clingo2.php" ;
                       } else if(emotiontext.getText() == "boredom") { // boredom
                        myUrl = "http://192.168.1.13/clingo/clingo2.php" ;
                       }

                        String[] field = new String[1];
                        field[0] = "username";
                        //Creating array for data
                        String[] data = new String[1];
                        data[0] = tv.getText().toString();
                        //data[1] = Emotion;

                        PutData putData = new PutData(myUrl, "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {

                                String result = putData.getResult();
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                                initPlan();
                                openPlan();

                            }
                        }
                    }
                });
            }
        });

        /*this listener is used for opening the users profile */
        @SuppressLint("CutPasteId") TextView UsernameTxt1 = findViewById(R.id.UsernameTxt);
        UsernameTxt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });

        /*profile button  listener is used for opening the users profile */
      //  Button profileBtn = findViewById(R.id.ProfileBtn);
    //    profileBtn.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View v) {
      //          openProfile();
      //      }
     //   });
        /*users image listener is used to open users profile */
        ImageView profileImgBtn = findViewById(R.id.UserProfilePic);
        profileImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });

        /*opens tutorial */
        Button tutorialBTN = findViewById(R.id.tutorialbtnCh00);
        tutorialBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChapter0();
            }
        });


        /*a spinner with all 4 chapters ,
        each value of this spinner open a activity to the corresponding chapter ,
        currently NOT in use.
        */

        Spinner myDropdown = findViewById(R.id.chapters);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(activityMM.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.chapters));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myDropdown.setAdapter(myAdapter);
        myDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Chapter 1")){
                    Intent intentCh01 = new Intent(activityMM.this,Chapter1.class);
                    startActivity(intentCh01);
                }
                else if(parent.getItemAtPosition(position).equals("Chapter 2")){
                    Intent intentCh02 = new Intent(activityMM.this,Chapter2.class);
                    startActivity(intentCh02);
                }else if(parent.getItemAtPosition(position).equals("Chapter 3")){
                    Intent intentCh03 = new Intent(activityMM.this,Chapter3.class);
                    startActivity(intentCh03);

                }else if(parent.getItemAtPosition(position).equals("Chapter 4")){
                    Intent intentCh04 = new Intent(activityMM.this,Chapter4.class);
                    startActivity(intentCh04);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    //do nothing
            }
        });

    } //end of onCreate

    /**
     * this method is used to store the data of the planner to each user
     */
    public void initPlan(){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                final TextView tv2 = findViewById(R.id.UsernameTxt);
                String[] field = new String[2];
                field[0] = "username";
                field[1] = "dimension";
                String[] data = new String[2];
                data[0] = tv2.getText().toString();
                data[1] = String.valueOf(dimFlag);
                PutData putData2 = new PutData("http://192.168.1.13/clingo/StoreData.php", "POST", field, data);
                if (putData2.startPut()) {
                    if (putData2.onComplete()) {
                        String result2 = putData2.getResult();
                       // Toast.makeText(getApplicationContext(),result2,Toast.LENGTH_SHORT).show();
                        if(result2.equals("Plan already exists for user.") ){
                            Toast.makeText(getApplicationContext(),result2,Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }


    /**
     * this method is used to select the favorite dimension of the user
     */
    @SuppressLint("SetTextI18n")
    public void dimensionChange() {
            dimensiontext = findViewById(R.id.dimensiontext);
            dimensiontext.setText("Active /Reflective");
            dimensiontext.setOnClickListener(
         //   changebtn02 = findViewById(R.id.changebtn02);
           // changebtn02.setOnClickListener(
                new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View v) {
                        switch (counter){
                            case 0:
                                dimensiontext.setText("Active /Reflective");
                                dimFlag = counter;
                                break;
                            case 1:
                                dimensiontext.setText("Visual /Verbal");
                                dimFlag = counter;
                                break;
                            case 2:
                                dimensiontext.setText("Sensing /Intuitive");
                                dimFlag = counter;
                                break;
                            case 3:
                                dimensiontext.setText("Sequental /Global");
                                dimFlag = counter;
                                break;
                            default:

                               // dimensiontext.setText("Something");
                                dimFlag = counter;
                                counter = -1;
                                break;
                        }
                        counter++;
                    }
                });
    }

    /**
     * this method is use to select the current mood of the user
     */
    @SuppressLint("SetTextI18n")
    public void emotionChange(){//function that enables emotion change
        imageView = findViewById(R.id.emotionviewCh2);
        emotiontext = findViewById(R.id.EmotionTxt);
        emotiontext.setText("neutral");
        emotiontext.setOnClickListener(
      //  changebtn01 = findViewById(R.id.emotionbtnCh2);
       // changebtn01.setOnClickListener(
                new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View v) {
                        curr_img++;
                        curr_img = curr_img % images.length;
                        imageView.setImageResource(images[curr_img]);
                        switch (curr_img) {
                            case 1:
                                emotiontext.setText("flow");
                                break;
                            case 2:
                                emotiontext.setText("confusion");
                                break;
                            case 3:
                                emotiontext.setText("joy");
                                break;
                            case 4:
                                emotiontext.setText("surprise");
                                break;
                            case 5:
                                emotiontext.setText("frustration");
                                break;
                            case 6:
                                emotiontext.setText("boredom");
                                break;
                            case 0:
                            default :
                                emotiontext.setText("neutral");
                        }
                    }
                }
        );
    }

    /**
     * this method is used to open the tutorial , it is not use in this example
     */
    public void openChapter0() {
        Intent intent = new Intent(this, Chapter0.class);
        startActivity(intent);
    }

    /**
     * this method is used to open the profile menu of the user
     */
    public void openProfile(){
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }

    /**
     * this method is used to open the plan activity
     */
    public void openPlan(){
        Intent intent = new Intent(this,Plan.class);
        final TextView edUsername  = findViewById(R.id.UsernameTxt);
        intent.putExtra("username",edUsername.getText().toString());
        intent.putExtra("Uniqid","From_Main");
        String mood = emotiontext.getText().toString();
        intent.putExtra("mood",mood);
        startActivity(intent);
    }


    public void showHelp(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Select your current mood and your favorite dimension and then press execute.", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}//end of class






