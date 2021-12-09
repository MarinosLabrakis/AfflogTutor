package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

/**
 * this class is used for handling the tests
 */
public class Test extends AppCompatActivity {

    ArrayList<String> Tests;
    ArrayList<String> myList ;
   // ArrayList<String> DoneList;
   // String myAnswer;
    String TestList ;
    String username,mood;
    TextView titleText;
    TextView questiontext;
  //  Button BtnA,BtnB,BtnC;
    Button EndTest;
    TextView AnswerTxTView;
    TextView testText;
    TextView AnswerTextA,AnswerTextB,AnswerTextC;
    boolean flag = false;

    @SuppressWarnings("unchecked")
    @SuppressLint({"WrongViewCast", "SetTextI18n"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);



        //toDo
        //like the tutorials here we have to check the completedtests for each user and remove the duplicates from myList

        myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");
       // Tests = (ArrayList<String>) getIntent().getSerializableExtra("tutorials");

        username =  getIntent().getExtras().getString("username");
        mood = getIntent().getExtras().getString("mood");
     //  System.out.println("TEst mood is = "+mood);

        titleText=findViewById(R.id.testTitle);
        questiontext = findViewById(R.id.testQuestionTxt);
        testText = findViewById(R.id.testHint);
        EndTest = findViewById(R.id.EndTest);
        EndTest.setVisibility(View.INVISIBLE);
        AnswerTextA = findViewById(R.id.AnswerTxtViewA);
        AnswerTextB = findViewById(R.id.AnswerTxtViewB);
        AnswerTextC = findViewById(R.id.AnswerTxtViewC);


        if(!myList.isEmpty()){

            TestList = myList.get(0);
            switch(TestList){
                case "test01":
                    titleText.setText("Test 01");
                    questiontext.setText("1) How many Victory Points do you need in order to win the game?");
                    AnswerTextA.setText("A) 10");
                    AnswerTextB.setText("B) 12");
                    AnswerTextC.setText("C) 15");
                    break;
                case "test02":
                    titleText.setText("Test 02");
                    questiontext.setText("What is a correct way of placing the Hexes?");
                    AnswerTextA.setText("A) Place all the hexes face down.");
                    AnswerTextB.setText("B) Place all the hexes so that the desert hex is in the middle and there are not two hexes adjacent to one another.");
                    AnswerTextC.setText("C) Both A and B are correct. ");
                    break;
                case "test03":
                    titleText.setText("Test 03");
                    questiontext.setText("Can a setlement be placed on an intersection adjacent to another intersection?");
                    AnswerTextA.setText("A) Yes.");
                    AnswerTextB.setText("B) Yes, Conditionally.");
                    AnswerTextC.setText("C) No.");
                    break;
                case "test04":
                    titleText.setText("Test 04");
                    questiontext.setText("What is the minimum number of resource cards that you can have in the beginning?");
                    AnswerTextA.setText("A) 3.");
                    AnswerTextB.setText("B) 5.");
                    AnswerTextC.setText("C) 6.");
                    break;
                case "test05":
                    titleText.setText("Test 05");
                    questiontext.setText("What does the Knight card do?");
                    AnswerTextA.setText("A)Moves the thief to a tile of your choice.");
                    AnswerTextB.setText("B) Lets you get a card from a player.");
                    AnswerTextC.setText("C) Both A and B. ");
                    break;
                case "test06":
                    titleText.setText("Test 06");
                    questiontext.setText("If a player rolls a seven:");
                    AnswerTextA.setText("A) Each player with 7 or more cards must discard half of them.");
                    AnswerTextB.setText("B) The person who rolled  gets to put the robber on whatever number token he/she desires, and then, gets to take one card from any player");
                    AnswerTextC.setText("C) Both are correct.");
                    break;
                case "test07":
                    titleText.setText("Test 07");
                    questiontext.setText("Is there a single best strategy for the settlers of Catan?");
                    AnswerTextA.setText("A) Yes, always target the strongest player.");
                    AnswerTextB.setText("B) Yes, always go for longest road and largest army.");
                    AnswerTextC.setText("C) No");
                    break;

            }
        }
        //gets the name of the test from the previous activity (for example Test 01 for ch1)
     //   Test = getIntent().getExtras().getString("Test");
        AnswerTextA.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(checkAnswerA()){
                TestAnswerCorrect();
              //  BtnB.setVisibility(View.INVISIBLE);
              //  BtnC.setVisibility(View.INVISIBLE);
                AnswerTextA.setTextColor(Color.parseColor("#00D300"));
                AnswerTextB.setVisibility(View.INVISIBLE);
                AnswerTextC.setVisibility(View.INVISIBLE);
                testText.setVisibility(View.INVISIBLE);
                openCorrectIntent();
                flag = true;

            }else {
               //questiontext.setVisibility(View.INVISIBLE);
             //  BtnA.setVisibility(View.INVISIBLE);
             //  BtnB.setVisibility(View.INVISIBLE);
             //  BtnC.setVisibility(View.INVISIBLE);
               AnswerTextA.setVisibility(View.INVISIBLE);
               AnswerTextB.setVisibility(View.INVISIBLE);
               AnswerTextC.setVisibility(View.INVISIBLE);
               testText.setVisibility(View.INVISIBLE);
                TestAnswerWrong();
                flag = false;

            }
        }
    });
        AnswerTextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAnswerB()){
                    TestAnswerCorrect();
                 //   BtnA.setVisibility(View.INVISIBLE);
                 //   BtnC.setVisibility(View.INVISIBLE);
                    AnswerTextB.setTextColor(Color.parseColor("#00D300"));
                    AnswerTextA.setVisibility(View.INVISIBLE);
                    AnswerTextC.setVisibility(View.INVISIBLE);
                    testText.setVisibility(View.INVISIBLE);
                    openCorrectIntent();
                    flag = true;
                }else{
                    TestAnswerWrong();
                 //   BtnA.setVisibility(View.INVISIBLE);
                 //   BtnB.setVisibility(View.INVISIBLE);
                 //   BtnC.setVisibility(View.INVISIBLE);
                    AnswerTextA.setVisibility(View.INVISIBLE);
                    AnswerTextB.setVisibility(View.INVISIBLE);
                    AnswerTextC.setVisibility(View.INVISIBLE);
                    testText.setVisibility(View.INVISIBLE);
                    flag = false ;
                }
            }
        });
        AnswerTextC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAnswerC()){
                    TestAnswerCorrect();
                 //   BtnA.setVisibility(View.INVISIBLE);
                 //   BtnB.setVisibility(View.INVISIBLE);
                    AnswerTextC.setTextColor(Color.parseColor("#00D300"));
                    AnswerTextA.setVisibility(View.INVISIBLE);
                    AnswerTextB.setVisibility(View.INVISIBLE);
                    testText.setVisibility(View.INVISIBLE);
                    openCorrectIntent();
                    flag = true;
                }else{
                    TestAnswerWrong();
                 //   BtnA.setVisibility(View.INVISIBLE);
                 //   BtnB.setVisibility(View.INVISIBLE);
                 //   BtnC.setVisibility(View.INVISIBLE);
                    AnswerTextA.setVisibility(View.INVISIBLE);
                    AnswerTextB.setVisibility(View.INVISIBLE);
                    AnswerTextC.setVisibility(View.INVISIBLE);
                    testText.setVisibility(View.INVISIBLE);
                    flag = false ;
                }

            }
        });

        EndTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag) {
                    openCorrectIntent();
                }else {
                    openWrongAnswerIntent();
                }
            }
        });

    }//end onCreate
    public boolean checkAnswerA(){
      String temp = titleText.getText().toString();
        if(temp.equals("Test 01")){
            return true;
        }else return temp.equals("Test 02");
    }
    public boolean checkAnswerB(){
        String temp = titleText.getText().toString();
        return temp.equals("Test 04");
    }

    public boolean checkAnswerC() {
        String temp = titleText.getText().toString();
        switch (temp) {
            case "Test 06":
            case "Test 05":
            case "Test 03":
            case "Test 07":
                return true;
            default:
                return false;
        }

    }
    @SuppressLint("SetTextI18n")
    public void TestAnswerCorrect(){
        AnswerTxTView = findViewById(R.id.AnswerTxTView);
        AnswerTxTView.setVisibility(View.VISIBLE);
        AnswerTxTView.setText("Your answer is correct!");
        AnswerTxTView.setTextColor(Color.parseColor("#00D300"));

    }

    public void TestAnswerWrong(){

        TextView WrongAnswertextView = findViewById(R.id.WrongAnswertextView);
        String temp = titleText.getText().toString();
        switch(temp){
            case "Test 01":
                WrongAnswertextView.setText("The object of Settlers of Catan is to be the first to gain 10 victory points.");
                WrongAnswertextView.setVisibility(View.VISIBLE);
                break;
            case "Test 02":
                WrongAnswertextView.setText("A variation of laying out the hexes is to place all of the hexes face down. They may only be turned upwards when someone places a road or a settlement on that hex.");
                WrongAnswertextView.setVisibility(View.VISIBLE);
                break;
            case "Test 03":
                WrongAnswertextView.setText("A settlement cannot be placed on an intersection adjacent to another intersection occupied by a settlement. There must be enough space for at least two roads between each settlement.");
                WrongAnswertextView.setVisibility(View.VISIBLE);
                break;
            case "Test 04":
                WrongAnswertextView.setText("The correct answer is 5. You get three cards from your first colony, and you may build your second colony at sea so you will get only two resource cards from that.");
                WrongAnswertextView.setVisibility(View.VISIBLE);
                break;
            case "Test 05":
                WrongAnswertextView.setText("A \"Knight\" card allows a player to move the robber to any spot on the board and then gets to take a card from any player that has a settlement or city on the blocked resource.");
                WrongAnswertextView.setVisibility(View.VISIBLE);
                break;
            case "Test 06":
                WrongAnswertextView.setText("Both are correct.");
                WrongAnswertextView.setVisibility(View.VISIBLE);
                break;
            case "Test 07":
                WrongAnswertextView.setText("There are many strategies to choose from. The best strategy depends on the current state of the game.");
                WrongAnswertextView.setVisibility(View.VISIBLE);
                break;
            default:
                WrongAnswertextView.setVisibility(View.INVISIBLE);
                break;
        }

        EndTest.setVisibility(View.VISIBLE);
        AnswerTxTView = findViewById(R.id.AnswerTxTView);
        AnswerTxTView.setVisibility(View.VISIBLE);
        AnswerTxTView.setText("Your answer is incorrect!");
        AnswerTxTView.setTextColor(Color.parseColor("#9A2B28"));

    }

    public void openCorrectIntent(){

      //  String temp ;
      //  temp = myList.get(0);


        //toDo
        //here we have to upload the completed test (when the user answers correct a test)


       // DoneList.add(temp);
       // String temp = titleText.getText().toString();
        //Tests.add(temp);
        if(!myList.isEmpty()) {
            myList.remove(0);
        }
      //  if(myList != null) {
           // System.out.println("myList Completed : ");
           // for (String item2 : myList) {
              //  System.out.println(item2);
          //  }
      //  }

      //  System.out.println("next= "+myList.get(0));
        Intent intent = new Intent(this,Tutorial.class);
        intent.putExtra("mylist", myList);
        //intent.putExtra("test",temp);
       // intent.putExtra("tutorials", Tests);
        intent.putExtra("username",username);
        intent.putExtra("mood",mood);
        startActivity(intent);
    }

    public void openWrongAnswerIntent(){
      //  myList.remove(0);
       // myList.remove(0);
           // if(myList != null) {
            //    System.out.println("myList Completed : ");
             //   for (String item2 : myList) {
              //      System.out.println(item2);
            //    }
          //  }
            ArrayList<String> finished = new ArrayList<String>();
            finished.addAll(myList);
      //  if(finished != null) {
          //  System.out.println("myList Completed : ");
         //   for (String item3 : finished) {
         //       System.out.println(item3);
         //   }
      //  }
        Intent intent = new Intent(this,Plan.class);
       // intent.putExtra("Uniqid","From_Test");
       // intent.putExtra("mylist", myList);
        intent.putExtra("myList", finished);
        intent.putExtra("mood",mood);
        intent.putExtra("username",username);
        String tempName = titleText.getText().toString();
        if(tempName != null){
            System.out.println("titleText = "+tempName);
            intent.putExtra("testName",tempName);
        }

      //  intent.putExtra("tutorials", Tests);

        //TODO
        //for replanning i need to pass some information back to planner

        //String temp = titleText.getText().toString();
       // intent.putExtra("replanning",temp);

     //   intent.putExtra("answer#",myAnswer);
        //intent.putExtra("DoneList",DoneList);
        startActivity(intent);
    }
}


