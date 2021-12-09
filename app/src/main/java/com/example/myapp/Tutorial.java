package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.vishnusivadas.advanced_httpurlconnection.FetchData;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


/**
 * this class is used for handling the tutorials
 */
public class Tutorial extends AppCompatActivity {

    /* component variables */
    @SuppressLint("StaticFieldLeak")
    private static TextView titleText;
    @SuppressLint("StaticFieldLeak")
    private static TextView text ;
    @SuppressLint("StaticFieldLeak")
    private static TextView myText1 ;

    /* array of tutorial images */
    int[] TutorialImages ={R.drawable.ch1,R.drawable.ch2,R.drawable.ch3,R.drawable.ch4};
    Button infoBtn;
    ImageView myImgTuts ;
    String username ,Chapter ,myAnswer;
    int TutorialNumber = 0;
    int flag =0 ;
    TextView moodTxT;
    String mood;
    private int moodCount;
    TextView ResultmoodTxt;
    int myMoodCount=0 ;


    /*ArrayList used to store the order of the course's tutorials / test
        this order is based by the planner.
     */
    ArrayList<String> myList ;
    ArrayList<String> DoneList = new ArrayList<String>() ;
   // ArrayList<String> completedItems = new ArrayList<String>() ;

    ArrayList<String> Tuts = new ArrayList<String>();

    @SuppressLint("SetTextI18n")
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        /*get some info from oher activities */
        Chapter = getIntent().getExtras().getString("Chapter");
        myAnswer = getIntent().getExtras().getString("answer#");
        username =  getIntent().getExtras().getString("username");
        mood = getIntent().getExtras().getString("mood");

        // Storing data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

        // Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        // here we initialize the
        if(myMoodCount == 1) { //first time the user is using the app
            myEdit.putInt("moodCount", myMoodCount); //this should be 0
            myEdit.putString("mood", mood); // this should be neutral
            //System.out.println("myMoodCount init = "+myMoodCount);
          //  System.out.println("mood init = "+mood);
        }



        /*get the mood for the user*/
        ResultmoodTxt = findViewById(R.id.ResultmoodTxt);
        switch (mood) {
            case "frustration":
              //  ResultmoodTxt.setText("Keep calm, you can do it!");
                ResultmoodTxt.setVisibility(View.VISIBLE);
                String s1 = sharedPreferences.getString("mood","");
                int a1 =  sharedPreferences.getInt("moodCount", 0);
                if(s1 != "neutral" && a1!= 0){ // not users first time so we have to reset the shared data
                    myMoodCount = 0 ;
                    myEdit.putInt("moodCount", myMoodCount); //this should be 0
                    myEdit.putString("mood", mood); // this should be neutral
                }
                if ((a1 % 2) == 0 ){//every 2 of the same mood do sth.
                    ResultmoodTxt.setText("Keep calm, you can do it!");
                }
                if(s1 != null){
                    if(s1.equals(mood) ) {
                        myMoodCount = a1+1;
                        myEdit.putInt("moodCount", myMoodCount);
                    }
                }


               // System.out.println("myMoodCount commit = "+myMoodCount);
             //   System.out.println("mood commit = "+mood);

                // Once the changes have been made,
                // we need to commit to apply those changes made,
                // otherwise, it will throw an error
                myEdit.commit();
                break;
            case "joy":
               // ResultmoodTxt.setText("Fantastic job , keep going!");
                ResultmoodTxt.setVisibility(View.VISIBLE);
                String s2 = sharedPreferences.getString("mood","");
                int a2 =  sharedPreferences.getInt("moodCount", 0);
                if(s2 != "neutral" || a2!= 0){ // not users first time so we have to reset the shared data
                    myMoodCount = 0 ;
                    myEdit.putInt("moodCount", myMoodCount); //this should be 0
                    myEdit.putString("mood", mood); // this should be neutral
                }
                if ((a2 % 2) == 0 ){//every 2 of the same mood do sth.
                    ResultmoodTxt.setText("Fantastic job , keep going!");
                }
                if(s2 != null){
                    if(s2.equals(mood) ) {
                        myMoodCount = a2+1;
                        myEdit.putInt("moodCount", myMoodCount);
                    }
                }



             //   System.out.println("myMoodCount commit = "+myMoodCount);
             //   System.out.println("mood commit = "+mood);
                myEdit.commit();
                break;
            case "boredom":
             //   ResultmoodTxt.setText("You have done so well, keep going!");
                ResultmoodTxt.setVisibility(View.VISIBLE);
                String s3 = sharedPreferences.getString("mood","");
                int a3 =  sharedPreferences.getInt("moodCount", 0);
                if(s3 != "neutral" || a3!= 0){ // not users first time so we have to reset the shared data
                    myMoodCount = 0 ;
                    myEdit.putInt("moodCount", myMoodCount); //this should be 0
                    myEdit.putString("mood", mood); // this should be neutral
                }
                if ((a3 % 2) == 0 ){//every 2 of the same mood do sth.
                    ResultmoodTxt.setText("You have done so well, keep going!");
                }
                if(s3 != null){
                    if(s3.equals(mood) ) {
                        myMoodCount = a3+1;
                        myEdit.putInt("moodCount", myMoodCount);
                    }
                }
                //TODO save the mood and count


              //  System.out.println("myMoodCount commit = "+myMoodCount);
             //   System.out.println("mood commit = "+mood);
                myEdit.commit();
                break;
            case "flow":
               // ResultmoodTxt.setText("Great job!");
               ResultmoodTxt.setVisibility(View.VISIBLE);
                String s4= sharedPreferences.getString("mood","");
                int a4 =  sharedPreferences.getInt("moodCount", 0);
                if(s4 != "flow" || a4!= 0){ // not users first time so we have to reset the shared data
                    myMoodCount = 0 ;
                    myEdit.putInt("moodCount", myMoodCount); //this should be 1
                    myEdit.putString("mood", mood); // this should be neutral

                }
                //System.out.println("a4  = "+a4);

                if ((a4 % 2) == 0 ){//every 2 of the same mood do sth.
                    ResultmoodTxt.setText("Great job!");
                }
                if(s4 != null){
                    if(s4.equals(mood) ) {
                        myMoodCount = a4+1;
                        myEdit.putInt("moodCount", myMoodCount);
                    }
                }
                //TODO save the mood and count
              //  if((a4 % 2 )== 0 && s4 == "frustration") {

                   // ResultmoodTxt.setText("Great job!");
               // }

             //   System.out.println("myMoodCount commit = "+myMoodCount);
             //   System.out.println("mood commit = "+mood);
                myEdit.commit();
                break;
            case "confusion":
                //ResultmoodTxt.setText("You can do it !");
                ResultmoodTxt.setVisibility(View.VISIBLE);
                String s5 = sharedPreferences.getString("mood","");
                int a5 =  sharedPreferences.getInt("moodCount", 0);
                if(s5 != "neutral" || a5!= 1){ // not users first time so we have to reset the shared data
                    myMoodCount = 1 ;
                    myEdit.putInt("moodCount", myMoodCount); //this should be 0
                    myEdit.putString("mood", mood); // this should be neutral
                }
                if ((a5 % 2) == 0 ){//every 2 of the same mood do sth.
                    ResultmoodTxt.setText("You can do it !");
                }
                if(s5 != null){
                    if(s5.equals(mood) ) {
                        myMoodCount = a5+1;
                        myEdit.putInt("moodCount", myMoodCount);
                    }
                }



                //System.out.println("myMoodCount commit = "+myMoodCount);
               // System.out.println("mood commit = "+mood);
                myEdit.commit();
                break;
            case "suprise":
               // ResultmoodTxt.setText("You are almost there");
                ResultmoodTxt.setVisibility(View.VISIBLE);
                String s6 = sharedPreferences.getString("mood","");
                int a6 =  sharedPreferences.getInt("moodCount", 0);
                if(s6 != "neutral" || a6!= 1){ // not users first time so we have to reset the shared data
                    myMoodCount = 1 ;
                    myEdit.putInt("moodCount", myMoodCount); //this should be 0
                    myEdit.putString("mood", mood); // this should be neutral
                }
                if ((a6 % 2) == 0 ){//every 2 of the same mood do sth.
                    ResultmoodTxt.setText("You are almost there");
                }
                if(s6 != null){
                    if(s6.equals(mood) ) {
                        myMoodCount = a6+1;
                        myEdit.putInt("moodCount", myMoodCount);
                    }
                }



              //  System.out.println("myMoodCount commit = "+myMoodCount);
              //  System.out.println("mood commit = "+mood);
                myEdit.commit();
                break;
            case "neutral":
            default:
                ResultmoodTxt.setVisibility(View.INVISIBLE);
                String s7 = sharedPreferences.getString("mood","");
                int a7 =  sharedPreferences.getInt("moodCount", 0);
                if(s7 != "neutral" || a7!= 1){ // not users first time so we have to reset the shared data
                    myMoodCount = 1 ;
                    myEdit.putInt("moodCount", myMoodCount); //this should be 0
                    myEdit.putString("mood", mood); // this should be neutral
                }

                myEdit.commit();
                break;
        }

        /*mood listener */
        moodTxT = findViewById(R.id.MoodTxtView);
        moodTxT.setText(mood);
        moodTxT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMood();
            }});

        /*info listener */
        infoBtn = findViewById(R.id.infoBtn);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHelp(v);
            }});

        //there is a start button that starts the section
        Button startSec =  findViewById (R.id.tutorialBtn);

        //this button goes to next tutorial on the list
        Button nextTut =  findViewById(R.id.btnNextTut);

        /* interface components for all tutorials */
        /*all objects are invisible when we start */
        titleText = findViewById(R.id.tutorialTitle);
        titleText.setVisibility(View.INVISIBLE);
        text =  findViewById(R.id.textTut);
        text.setVisibility(View.INVISIBLE);
        myText1 =  findViewById(R.id.myText1);
        myText1.setVisibility(View.GONE);
        myImgTuts =  findViewById(R.id.imageViewTutorials);
        /*local variable */
        String temp ;
        /* get myList from other activities */
        myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");

       /*main logic of the class */
       if(!myList.isEmpty()){ //check that the list is not empty

           Intent intent;
           if(myList.get(0).contains("test")){ //go to test activity

               intent = new Intent(this, Test.class);
               intent.putExtra("mylist", myList);
               intent.putExtra("username",username);
               intent.putExtra("mood",mood);
               startActivity(intent);
           }else { //stay in this activity and do work

                temp = myList.get(0); //get the first item of the list
                switch (temp) { // change the interface based on the temp object above
                    case "tut01":
                        titleText.setText("Tutorial 01");
                        text.setText("Chapter 1: Check to see that you have all of the components of the game");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 1;
                        myImgTuts.setImageResource(TutorialImages[0]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut02":
                        titleText.setText("Tutorial 02");
                        text.setText("Chapter 1: Understand the goal of the game.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 2;
                        myImgTuts.setImageResource(TutorialImages[0]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut03":
                        titleText.setText("Tutorial 03");
                        text.setText("Chapter 1: Make the outer frame.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 3;
                        myImgTuts.setImageResource(TutorialImages[0]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut04":
                        titleText.setText("Tutorial 04");
                        text.setText("Chapter 1: Place the hexes.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 4;
                        myImgTuts.setImageResource(TutorialImages[0]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut05":
                        titleText.setText("Tutorial 05");
                        text.setText("Chapter 1: Place the tokens.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 5;
                        myImgTuts.setImageResource(TutorialImages[0]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut06":
                        titleText.setText("Tutorial 06");
                        text.setText("Chapter 1: Place the robber. ");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 6;
                        myImgTuts.setImageResource(TutorialImages[0]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut07":
                        titleText.setText("Tutorial 07");
                        text.setText("Chapter 1: Place the cards.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 7;
                        myImgTuts.setImageResource(TutorialImages[0]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut08":
                        titleText.setText("Tutorial 08");
                        text.setText("Chapter 2: Determine the turn order.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 8;
                        myImgTuts.setImageResource(TutorialImages[1]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut09":
                        titleText.setText("Tutorial 09");
                        text.setText("Chapter 2: Place the first settlements.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 9;
                        myImgTuts.setImageResource(TutorialImages[1]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut10":
                        titleText.setText("Tutorial 10");
                        text.setText("Chapter 2: Place the final settlements.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 10;
                        myImgTuts.setImageResource(TutorialImages[1]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut11":
                        titleText.setText("Tutorial 11");
                        text.setText("Chapter 2: Get your first resource cards.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 11;
                        myImgTuts.setImageResource(TutorialImages[1]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut12":
                        titleText.setText("Tutorial 12");
                        text.setText("Chapter 3: Roll the dice.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 12;
                        myImgTuts.setImageResource(TutorialImages[2]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut13":
                        titleText.setText("Tutorial 13");
                        text.setText("Chapter 3: Take your turn actions.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 13;
                        myImgTuts.setImageResource(TutorialImages[2]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut14":
                        titleText.setText("Tutorial 14");
                        text.setText("Chapter 3: Build structures.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 14;
                        myImgTuts.setImageResource(TutorialImages[2]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut15":
                        titleText.setText("Tutorial 15");
                        text.setText("Chapter 3: Play a development card.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 15;
                        myImgTuts.setImageResource(TutorialImages[2]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut16":
                        titleText.setText("Tutorial 16");
                        text.setText("Chapter 3: Pay attention to the instructions on development cards.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 16;
                        myImgTuts.setImageResource(TutorialImages[2]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut17":
                        titleText.setText("Tutorial 17");
                        text.setText("Chapter 3: Trade as needed.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 17;
                        myImgTuts.setImageResource(TutorialImages[2]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut18":
                        titleText.setText("Tutorial 18");
                        text.setText("Chapter 3: Watch out for sevens.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 18;
                        myImgTuts.setImageResource(TutorialImages[2]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut19":
                        titleText.setText("Tutorial 19");
                        text.setText("Chapter 4: Use strategy to increase your chances of winning.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 19;
                        myImgTuts.setImageResource(TutorialImages[3]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut20":
                        titleText.setText("Tutorial 20");
                        text.setText("Chapter 3: Announce when you have 10 victory points.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 20;
                        myImgTuts.setImageResource(TutorialImages[2]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut21":
                        titleText.setText("Tutorial 21");
                        text.setText("Chapter 1: Youtube Video on how to play Settlers of Catan.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 21;
                        break;

                    case "tut22":
                        titleText.setText("Tutorial 22");
                        text.setText("Chapter 4: There are a number of strategies to pursue.");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 22;
                        myImgTuts.setImageResource(TutorialImages[3]);
                        myImgTuts.setVisibility(View.VISIBLE);
                        break;

                    case "tut23":
                        titleText.setText("Tutorial 23");
                        text.setText("Chapter 3: Winning Conditions Video");
                        titleText.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                        TutorialNumber = 23;
                        break;

                    default:
                        titleText.setText(R.string.NotValidTUT);
                        text.setText(R.string.SthWentWrongTUT);
                        text.setVisibility(View.VISIBLE);
                        titleText.setVisibility(View.VISIBLE);
                }

           }
    }else{ /*if myList.isEmpty() */
           /*we made it to the end of the course */
           /* we have to make next/ start buttons invisible*/
           /* the end button must become visible */
           /* we must change the texts ,images and make the visible */

            nextTut.setVisibility(View.INVISIBLE);
            startSec.setVisibility(View.INVISIBLE);
            infoBtn.setVisibility(View.INVISIBLE);
            ImageView tutorImage = findViewById(R.id.TutorimageView);
            tutorImage.setVisibility(View.INVISIBLE);

            Button endBtn = findViewById(R.id.EndCourseBTN);
            endBtn.setVisibility(View.VISIBLE);

            titleText.setText(username);
            titleText.setVisibility(View.VISIBLE);
            text.setText(R.string.SuSCourTUT);
            text.setVisibility(View.VISIBLE);
            myImgTuts.setImageResource(R.drawable.congratulations) ;
            myImgTuts.setVisibility(View.VISIBLE);

            /*make mood invisible*/
            moodTxT.setVisibility(View.INVISIBLE);
            TextView currentMoodtxt = findViewById(R.id.CurrentMoodTxt);
            currentMoodtxt.setVisibility(View.INVISIBLE);
            ResultmoodTxt.setVisibility(View.INVISIBLE);

            /*end course listener*/
             endBtn.setOnClickListener(new View.OnClickListener() {
              @Override
                    public void onClick(View v) {
                    EndCourse(); //this method is used to end the course
                    }
             });
       }

        /*listener for next tutorial button */
       nextTut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempTut ;
                tempTut = titleText.getText().toString();
                if( tempTut != null){
                    Tuts.add(tempTut);
                }
                nextTutorial();
            }
       });

       //listener for starting sections
       startSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSections();
            }
       });

    }//end OnCreate

    /*
     * Loads the tutorials from server for the user .
     */
  /*  public void LoadTutsToServer(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("tutorials", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        Tuts = gson.fromJson(json,type);
        if (Tuts == null) {
            // if the array list is empty
            // creating a new array list.
            Tuts = new ArrayList<>();
        }

    } */

    /*
     * saves the tutorials to the server
     */
  /*  public void SaveTutsToServer(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Tuts);
        editor.putString("tutorials", json);
        editor.apply();
        Toast.makeText(this, "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT).show();


    } */

    public void uploadTutsToServer(final ArrayList<String> tut){
        if(!tut.isEmpty()) {


            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    //Starting Write and Read data with URL
                    //Creating array for parameters
                    String[] field = new String[2];
                    field[0] = "username";
                    field[1] = "tutorial";
                    //Creating array for data
                    String[] data = new String[2];
                    data[0] = username;
                    data[1] = String.valueOf(tut);

                    PutData putData = new PutData("http://192.168.1.13/clingo/UploadToServer.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            String result = putData.getResult();
                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            });
        }
    }

    public void loadFromServer(){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {

                String url = "http://192.168.1.13/clingo/LoadFromServer.php?username="+username;
                FetchData fetchData = new FetchData(url);
                if (fetchData.startFetch()) {
                    if (fetchData.onComplete()) {
                        String result = fetchData.getResult();
                        System.out.println("RESULT ="+result);
                    }
                }
            }
        });
    }


    /* Helpful methods */

    /**
     * Change to the next tutorial,
     * removes the first item from the array and gets the next one
     */
    public void nextTutorial() {


        if(!myList.isEmpty()){//check if list is empty

            myList.remove(0);//remove previous tutorial
            Intent intent;

            if(myList.get(0).contains("test")){ //go to test activity
                intent = new Intent(this, Test.class);
            }else{ //stay here
                intent = new Intent(this, Tutorial.class);
            }

            String mood = moodTxT.getText().toString();
            intent.putExtra("mylist", myList);
            intent.putExtra("username",username);
            intent.putExtra("mood",mood);
            startActivity(intent);

        }
    }
    /*
    public void addItemstoList(String s){
        if(s!= null){
            switch(s){
                case "tut01":
                    completedItems.add("Tutorial 01");
                    break;
                case "tut02":
                    completedItems.add("Tutorial 02");
                    break;
                case "tut03":
                    completedItems.add("Tutorial 03");
                    break;
                case "tut04":
                    completedItems.add("Tutorial 04");
                    break;
                case "tut05":
                    completedItems.add("Tutorial 05");
                    break;
                case "tut06":
                    completedItems.add("Tutorial 06");
                    break;
                case "tut07":
                    completedItems.add("Tutorial 07");
                    break;
            }
        }

    }*/

    /**
     * this method is used to open activity_sections
     */
    public void openSections(){

        Intent intent = new Intent(this,Sections.class);
        final TextView  text  = findViewById(R.id.tutorialTitle);

        intent.putExtra("text",text.getText().toString());
        intent.putExtra("mylist", myList);
        intent.putExtra("username",username);

        String mood = moodTxT.getText().toString();
        intent.putExtra("mood",mood);

        startActivity(intent);
    }

    /**
     * this method is used for the End of course screen
     */
    public void EndCourse(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    @SuppressLint("SetTextI18n")
    public void changeMood(){
        //SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
      //  String s ;
      //  int a ;
                moodCount++;
        moodCount = moodCount % 7;
        switch (moodCount){
            case 1:
                moodTxT.setText("flow");
               // ResultmoodTxt.setVisibility(View.VISIBLE);
                ResultmoodTxt.setVisibility(View.INVISIBLE);
               //  s = sharedPreferences.getString("mood","");
               //  a =  sharedPreferences.getInt("moodCount", 0);
               // System.out.println("a at change mood is = "+a);
               // System.out.println("s at change mood is = "+s);
               // if(a == 2 && s == "flow") {
                   // ResultmoodTxt.setText("Great job!");
              // }
                break;
            case 2:
                moodTxT.setText("confusion");
                ResultmoodTxt.setVisibility(View.INVISIBLE);
               // ResultmoodTxt.setVisibility(View.VISIBLE);
             //   s = sharedPreferences.getString("mood","");
              //  a =  sharedPreferences.getInt("moodCount", 0);
              //  System.out.println("a at change mood is = "+a);
              //  System.out.println("s at change mood is = "+s);
             //   if(a == 2 && s == "confusion") {
                 //   ResultmoodTxt.setText("You can do it !");
             //   }

                break;
            case 3:
                moodTxT.setText("joy");
                ResultmoodTxt.setVisibility(View.INVISIBLE);
                //ResultmoodTxt.setVisibility(View.VISIBLE);
               //s = sharedPreferences.getString("mood","");
              //  a =  sharedPreferences.getInt("moodCount", 0);
              //  System.out.println("a at change mood is = "+a);
              //  System.out.println("s at change mood is = "+s);
             //   if(a == 2 && s == "joy") {
                //    ResultmoodTxt.setText("Fantastic job , keep going!");
              //  }

                break;
            case 4:
                moodTxT.setText("surprise");
                ResultmoodTxt.setVisibility(View.INVISIBLE);
              //  ResultmoodTxt.setVisibility(View.INVISIBLE);
              //  s = sharedPreferences.getString("mood","");
              //  a =  sharedPreferences.getInt("moodCount", 0);
               // System.out.println("a at change mood is = "+a);
             //   System.out.println("s at change mood is = "+s);
              //  if(a == 2 && s == "surprise") {
                //    ResultmoodTxt.setText("Fantastic job , keep going!");
              //  }
                break;
            case 5:
                moodTxT.setText("frustration");
                ResultmoodTxt.setVisibility(View.INVISIBLE);
              //  ResultmoodTxt.setVisibility(View.VISIBLE);
             //   s = sharedPreferences.getString("mood","");
            //    a =  sharedPreferences.getInt("moodCount", 0);
              //  System.out.println("a at change mood is = "+a);
              // System.out.println("s at change mood is = "+s);
              //  if(a == 2 && s == "frustration") {
                //    ResultmoodTxt.setText("Keep calm, you can do it!");
             //   }

                break;
            case 6:
                moodTxT.setText("boredom");
                ResultmoodTxt.setVisibility(View.INVISIBLE);
              //  ResultmoodTxt.setVisibility(View.VISIBLE);
             //   s = sharedPreferences.getString("mood","");
              //  a =  sharedPreferences.getInt("moodCount", 0);
             //   System.out.println("a at change mood is = "+a);
             //   System.out.println("s at change mood is = "+s);
              //  if(a == 2 && s == "boredom") {
                 //   ResultmoodTxt.setText("You have done so well, keep going!");
             //   }

                break;
            case 0:
            default :
                moodTxT.setText("neutral");
                ResultmoodTxt.setVisibility(View.INVISIBLE);

                break;
        }

    }


    public void showHelp(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Press start to begin the tutorial , when you finish click button next to continue the course. Keep in mind that you can change your mood by clicking the current emotion text.", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
