package com.example.myapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.vishnusivadas.advanced_httpurlconnection.FetchData;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;


public class Plan extends AppCompatActivity {

    String[] ExecutionList = new String[24];
    ArrayList<String> myList = new ArrayList<>();
    ArrayList<String> ListOfCompleted ;
    ArrayList<String> replanningList = new ArrayList<>();
    ArrayList<String> x = new ArrayList<String>();
    ArrayList<String> Ch01List = new ArrayList<>();
    ArrayList<String> Ch02List= new ArrayList<>();
    ArrayList<String> Ch03List= new ArrayList<>();
    ArrayList<String> Ch04List= new ArrayList<>();

    Button infoBtn;
    String username;
    String testName ;
    TextView answerText ;
    int excCount =0;
    int flag =0;
    final String[] ntemp = new String[1];

    TextView frame1,frame2 ,frame3,frame4,frame5,frame6,frame7, frame8,frame9,frame10,frame11,frame12;
    TextView frame13,frame14,frame15,frame16 ,frame17,frame18,frame19,frame20,frame21,frame22,frame23,frame24,frame25;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        username = getIntent().getExtras().getString("username");
        ListOfCompleted = (ArrayList<String>) getIntent().getSerializableExtra("myList");
        testName = getIntent().getExtras().getString("testName");

        System.out.println("username ="+username);
        int mistake  ;

        if(testName != null){
          /// System.out.println("User made a mistake at "+testName);
            switch(testName){ //let us know where the user made the mistake
                case "Test 03":
                case "Test 04":
                    System.out.println("User made a mistake on CH02");
                    mistake = 2;
                    break;
                case "Test 05":
                case "Test 06":
                    System.out.println("User made a mistake on CH03");
                    mistake = 3;
                    break;
                case "Test 07":
                    System.out.println("User made a mistake on CH04");
                    mistake = 4;
                    break;
                default:
                    System.out.println("User made a mistake on CH01");
                    mistake = 1;
                    break;
            }
           // System.out.println("mistake = " +mistake);

            Ch01List.addAll(Arrays.asList("tut01", "tut02", "tut03", "tut04", "tut05","tut06","tut07","tut21","test01","test02"));
            Ch02List.addAll(Arrays.asList("tut08", "tut09", "tut10", "tut11","test03","test04"));
            Ch03List.addAll(Arrays.asList("tut12", "tut13", "tut14", "tut15", "tut16","tut17","tut18","tut20","tut23","test05","test06"));
            Ch04List.addAll(Arrays.asList("tut19", "tut22", "test07"));

            BufferedReader reader;

            try{
                final InputStream file = getAssets().open("AnswersAsLines.txt");
                reader = new BufferedReader(new InputStreamReader(file));
                String line = reader.readLine();
                while(line != null){
                   // System.out.println("line = "+line);
                    x.addAll(Arrays.asList(line));
                    line = reader.readLine();
                }
            } catch(IOException ioe){
                ioe.printStackTrace();
            }

          // System.out.println(x);
            String tempList;
            int random = getRandomAnswer();
           // System.out.println("random= "+random);
            if(random <20){
                tempList = x.get(random);
            }else {
                tempList = x.get(0);
            }

            String[] parts = tempList.split(",");

            for (String element : parts) {
              //  System.out.println("element = "+element);
                replanningList.add(element);

            }
           // System.out.println("Replanning list = "+replanningList);
            if(mistake == 1){
                System.out.println("case 1");
                //for (String element : parts) {
                //    replanningList.add(element);
                //}

            }else if(mistake == 2){
                System.out.println("case 2");
                replanningList.removeAll(Ch01List);
            }else if(mistake == 3){
                System.out.println("case 3");
                replanningList.removeAll(Ch01List);
                replanningList.removeAll(Ch02List);
            }else if(mistake == 4){
                System.out.println("case 4");
                replanningList.removeAll(Ch01List);
                replanningList.removeAll(Ch02List);
                replanningList.removeAll(Ch03List);
            }
            if(replanningList != null) {
                System.out.println("This is the new list from the replanning: ");
                System.out.println(replanningList);
            }
        }

        if(ListOfCompleted != null) {
         //   System.out.println("The user completed this : ");
          //  for (String item : ListOfCompleted) {
          //      System.out.print(item);
         //  }
            flag = 1;

       }
        final TextView tv = findViewById(R.id.UsernameTxt2);
        tv.setText(String.format("%s", username));//Welcome <User>

        frame1 = findViewById(R.id.planFrameTxt1);
        frame2 = findViewById(R.id.planFrameTxt2);
        frame3 = findViewById(R.id.planFrameTxt3);
        frame4 = findViewById(R.id.planFrameTxt4);
        frame5 = findViewById(R.id.planFrameTxt5);
        frame6 = findViewById(R.id.planFrameTxt6);
        frame7 = findViewById(R.id.planFrameTxt7);
        frame8 = findViewById(R.id.planFrameTxt8);
        frame9 = findViewById(R.id.planFrameTxt9);
        frame10 = findViewById(R.id.planFrameTxt10);
        frame11 = findViewById(R.id.planFrameTxt11);
        frame12 = findViewById(R.id.planFrameTxt12);
        frame13 = findViewById(R.id.planFrameTxt13);
        frame14 = findViewById(R.id.planFrameTxt14);
        frame15 = findViewById(R.id.planFrameTxt15);
        frame16 = findViewById(R.id.planFrameTxt16);
        frame17 = findViewById(R.id.planFrameTxt17);
        frame18 = findViewById(R.id.planFrameTxt18);
        frame19 = findViewById(R.id.planFrameTxt19);
        frame20 = findViewById(R.id.planFrameTxt20);
        frame21 = findViewById(R.id.planFrameTxt21);
        frame22 = findViewById(R.id.planFrameTxt22);
        frame23 = findViewById(R.id.planFrameTxt23);
        frame24 = findViewById(R.id.planFrameTxt24);
        frame25 = findViewById(R.id.planFrameTxt25);

        answerText  = findViewById(R.id.example1);
        infoBtn = findViewById(R.id.infoBtn2);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHelp(v);
            }});

        if(flag == 1){//here i do the replan and i select a differnet answer than whats stored in the server
            FilltheFrames();
        }else {
            if (GetAnswerFromServer()) {//this method creates the frames with the answer for the specific user
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAIL");
            }
        }

        Button StartTUTbtn = findViewById(R.id.planStartBtn);
        StartTUTbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //check always the first item on the list
               if (flag == 1) {
                   // if(ListOfCompleted.get(0).contains("test")){
                   if(replanningList.get(0).contains("test")){
                        openTests();
                    }else{
                        openTutorials();
                    }
               } else {
                   if (ExecutionList[0].contains("test")) {
                       openTests();
                   } else {
                       openTutorials();
                   }
               }
           }
        });


    }//end of onCreate


    public int getRandomAnswer(){
        int min = 0;
        int max = 47;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public void GetAnswer(){

        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                String url = "http://192.168.1.13/clingo/GetData.php?username=" + username;
                FetchData fetchData = new FetchData(url);
                if (fetchData.startFetch()) {
                    if (fetchData.onComplete()) {
                        String result = fetchData.getResult();
                        //System.out.println("result = "+result);
                        ntemp[0] = result;
                        System.out.println("ntemp = "+ntemp[0]);
                    }
                }
            }

        });
    }
    public void FilltheFrames(){
        int counter =0;
        TextView tempframe;
        //System.out.println("First element of replanning list before = "+replanningList.get(0).toString());
        if(replanningList.get(0).contains("test")){ //if the first item of the list is a test we use tut21 as filler
            replanningList.add(0,"tut21");
          //  System.out.println("First element of replanning list after = "+replanningList.get(0).toString());
          //  System.out.println("Second element of replanning list after = "+replanningList.get(1).toString());
        }
        //for(int m =0; m< ListOfCompleted.size(); m++) {
            for(int m =0; m< replanningList.size(); m++) {
        switch (counter) {
            case 0:
                tempframe = frame1;
                break;
            case 1:
                tempframe = frame2;
                break;
            case 2:
                tempframe = frame3;
                break;
            case 3:
                tempframe = frame4;
                break;
            case 4:
                tempframe = frame5;
                break;
            case 5:
                tempframe = frame6;
                break;
            case 6:
                tempframe = frame7;
                break;
            case 7:
                tempframe = frame8;
                break;
            case 8:
                tempframe = frame9;
                break;
            case 9:
                tempframe = frame10;
                break;
            case 10:
                tempframe = frame11;
                break;
            case 11:
                tempframe = frame12;
                break;
            case 12:
                tempframe = frame13;
                break;
            case 13:
                tempframe = frame14;
                break;
            case 14:
                tempframe = frame15;
                break;
            case 15:
                tempframe = frame16;
                break;
            case 16:
                tempframe = frame17;
                break;
            case 17:
                tempframe = frame18;
                break;
            case 18:
                tempframe = frame19;
                break;
            case 19:
                tempframe = frame20;
                break;
            case 20:
                tempframe = frame21;
                break;
            case 21:
                tempframe = frame22;
                break;
            case 22:
                tempframe = frame23;
                break;
            case 23:
                tempframe = frame24;
                break;
            case 24:
                tempframe = frame25;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " );

        }

           // tempframe.setText(ListOfCompleted.get(m));
            tempframe.setText(replanningList.get(m));

            tempframe.setVisibility(View.VISIBLE);
            counter++;
        }

    }

    /**
     * this method returns the tutorial or test in string
     * @param answer is a String that contains the answer
     * @return returns answer string without (,)
     */
    public String[] makeTutTest(String answer){
        String[] tutTest = new String[48];
        String temp ;
            if (answer != null) {
                StringTokenizer tokens = new StringTokenizer(answer, ")(,");
                temp = tokens.nextToken();
                int j = 0;
                while (temp != null) {
                    tutTest[j] = temp;
                    if (tokens.hasMoreTokens()) {
                        temp = tokens.nextToken();
                        j++;
                    } else {
                        break;
                    }
                }
       }
        return tutTest;
    }

    /**
     * this method gets the plan and return an array of strings[]
     * @param plan contains tha raw plan
     * @return returns the plan with " "
     */
    public String[] makeTokens(String plan){

        StringTokenizer tokens = new StringTokenizer(plan," ");
        String answer ;
        String[] answers= new String[48];

        answer = tokens.nextToken();
        int i =0 ;
        while(answer != null){
            answers[i] = answer;
            if(tokens.hasMoreTokens()) {
                answer = tokens.nextToken();
                i++;
            }else{
                break;
            }
        }

        return answers;
    }

    /**
     * this method gets the answer for each user that is stored in the server
     */
    public boolean GetAnswerFromServer(){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {

                String url = "http://192.168.1.13/clingo/GetData.php?username="+username;
                FetchData fetchData = new FetchData(url);
                if (fetchData.startFetch()) {
                    if (fetchData.onComplete()) {
                        String result = fetchData.getResult();
                        String temp;
                        answerText.setText(result);
                        switch (result) {
                            case "Answer 1":
                                temp = "Answer 01";
                                Planner(temp);
                                break;
                            case "Answer 2":
                                temp = "Answer 02";
                                Planner(temp);
                                break;
                            case "Answer 3":
                                temp = "Answer 03";
                                Planner(temp);
                                break;
                            case "Answer 4":
                                temp = "Answer 04";
                                Planner(temp);
                                break;
                            case "Answer 5":
                                temp = "Answer 05";
                                Planner(temp);
                                break;
                            case "Answer 6":
                                temp = "Answer 06";
                                Planner(temp);
                                break;
                            case "Answer 7":
                                temp = "Answer 07";
                                Planner(temp);
                                break;
                            case "Answer 8":
                                temp = "Answer 08";
                                Planner(temp);
                                break;
                            case "Answer 9":
                                temp = "Answer 09";
                                Planner(temp);
                                break;
                            default:
                                Planner(result);
                                break;
                        }

                    }

                }
            }

        });
        return true;

    }

    /**
     * this method is taking as input the number of the answer and with the help of the json from the planner it selects the appropiate answer
     * for each user , with help from method getPlan(String)
     * @param temp is a string that contain the answer
     */
    public void Planner(String temp){
        String plan  ;

        try {
            assert temp != null;
            plan = getPlan(temp);
         //   System.out.println("Plan= "+plan);
            String[] finalanswer;
            finalanswer = makeTokens(plan);
            int counter = 0;

            for (int k = 0; k < finalanswer.length; k++) {

                if (finalanswer[k] != null) {

                    String[] TutorialList;
                    TutorialList = makeTutTest(finalanswer[k]);

                    for (int m = 0; m < TutorialList.length; m++) {

                        if (TutorialList[m] != null) {

                            TextView tempframe;
                            switch (counter) {
                                case 0:
                                    tempframe = frame1;
                                    break;
                                case 1:
                                    tempframe = frame2;
                                    break;
                                case 2:
                                    tempframe = frame3;
                                    break;
                                case 3:
                                    tempframe = frame4;
                                    break;
                                case 4:
                                    tempframe = frame5;
                                    break;
                                case 5:
                                    tempframe = frame6;
                                    break;
                                case 6:
                                    tempframe = frame7;
                                    break;
                                case 7:
                                    tempframe = frame8;
                                    break;
                                case 8:
                                    tempframe = frame9;
                                    break;
                                case 9:
                                    tempframe = frame10;
                                    break;
                                case 10:
                                    tempframe = frame11;
                                    break;
                                case 11:
                                    tempframe = frame12;
                                    break;
                                case 12:
                                    tempframe = frame13;
                                    break;
                                case 13:
                                    tempframe = frame14;
                                    break;
                                case 14:
                                    tempframe = frame15;
                                    break;
                                case 15:
                                    tempframe = frame16;
                                    break;
                                case 16:
                                    tempframe = frame17;
                                    break;
                                case 17:
                                    tempframe = frame18;
                                    break;
                                case 18:
                                    tempframe = frame19;
                                    break;
                                case 19:
                                    tempframe = frame20;
                                    break;
                                case 20:
                                    tempframe = frame21;
                                    break;
                                case 21:
                                    tempframe = frame22;
                                    break;
                                case 22:
                                    tempframe = frame23;
                                    break;
                                case 23:
                                    tempframe = frame24;
                                    break;
                                case 24:
                                    tempframe = frame25;
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + k);

                            }
                                if (TutorialList[m].equals("doTest")) {
                                    tempframe.setText(TutorialList[m + 1]);
                                    tempframe.setVisibility(View.VISIBLE);
                                    counter++;
                                    ExecutionList[excCount++] = TutorialList[m + 1];
                                    myList.add(TutorialList[m + 1]);
                                } else if (TutorialList[m].equals("doTutorial")) {
                                    tempframe.setText(TutorialList[m + 1]);
                                    tempframe.setVisibility(View.VISIBLE);
                                    counter++;
                                    ExecutionList[excCount++] = TutorialList[m + 1];
                                    myList.add(TutorialList[m + 1]);
                                }
                            } else {
                                break;
                            }
                        }

                } else {
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the plan for the user
     * @param nAnswer is the number of the plan selected for the user
     * @return the plan for the users course
     */
    public String getPlan(String nAnswer) throws JSONException {

        /*loads the json using the appropiate method for this example i used loadJSONFromAsser*/
        String json = loadJSONFromAsset(getApplicationContext());

        String Answer = null;
        JSONObject jsonObj;
        jsonObj = new JSONObject(json);


        if(nAnswer.contains("Answer 01")){
            Answer = jsonObj.getString("Answer 1");
        }else if(nAnswer.contains("Answer 02")){
            Answer = jsonObj.getString("Answer 2");
        } else if(nAnswer.contains("Answer 03")){
            Answer = jsonObj.getString("Answer 3");
        }else if(nAnswer.contains("Answer 04")){
            Answer = jsonObj.getString("Answer 4");
        }else if(nAnswer.contains("Answer 05")){
            Answer = jsonObj.getString("Answer 5");
        }else if(nAnswer.contains("Answer 06")){
            Answer = jsonObj.getString("Answer 6");
        }else if(nAnswer.contains("Answer 07")){
            Answer = jsonObj.getString("Answer 7");
        }else if(nAnswer.contains("Answer 08")){
            Answer = jsonObj.getString("Answer 8");
        }else if(nAnswer.contains("Answer 09")){
            Answer = jsonObj.getString("Answer 9");
        }else if(nAnswer.contains("Answer 10")){
            Answer = jsonObj.getString("Answer 10");
        }else if(nAnswer.contains("Answer 11")){
            Answer = jsonObj.getString("Answer 11");
        }else if(nAnswer.contains("Answer 12")){
            Answer = jsonObj.getString("Answer 12");
        }else if(nAnswer.contains("Answer 13")){
            Answer = jsonObj.getString("Answer 13");
        }else if(nAnswer.contains("Answer 14")){
            Answer = jsonObj.getString("Answer 14");
        }else if(nAnswer.contains("Answer 15")){
            Answer = jsonObj.getString("Answer 15");
        }else if(nAnswer.contains("Answer 16")){
            Answer = jsonObj.getString("Answer 16");
        }else if(nAnswer.contains("Answer 17")){
            Answer = jsonObj.getString("Answer 17");
        }else if(nAnswer.contains("Answer 18")){
            Answer = jsonObj.getString("Answer 18");
        }else if(nAnswer.contains("Answer 19")){
            Answer = jsonObj.getString("Answer 19");
        }else if(nAnswer.contains("Answer 20")){
            Answer = jsonObj.getString("Answer 20");
        }else if(nAnswer.contains("Answer 21")){
            Answer = jsonObj.getString("Answer 21");
        }else if(nAnswer.contains("Answer 22")){
            Answer = jsonObj.getString("Answer 22");
        }else if(nAnswer.contains("Answer 23")){
            Answer = jsonObj.getString("Answer 23");
        }else if(nAnswer.contains("Answer 24")){
            Answer = jsonObj.getString("Answer 24");
        }else if(nAnswer.contains("Answer 25")){
            Answer = jsonObj.getString("Answer 25");
        }else if(nAnswer.contains("Answer 26")){
            Answer = jsonObj.getString("Answer 26");
        }else if(nAnswer.contains("Answer 27")){
            Answer = jsonObj.getString("Answer 27");
        }else if(nAnswer.contains("Answer 28")){
            Answer = jsonObj.getString("Answer 28");
        }else if(nAnswer.contains("Answer 29")){
            Answer = jsonObj.getString("Answer 29");
        }else if(nAnswer.contains("Answer 30")){
            Answer = jsonObj.getString("Answer 30");
        }else if(nAnswer.contains("Answer 31")){
            Answer = jsonObj.getString("Answer 31");
        }else if(nAnswer.contains("Answer 32")){
            Answer = jsonObj.getString("Answer 32");
        }else if(nAnswer.contains("Answer 33")){
            Answer = jsonObj.getString("Answer 33");
        }else if(nAnswer.contains("Answer 34")){
            Answer = jsonObj.getString("Answer 34");
        }else if(nAnswer.contains("Answer 35")){
            Answer = jsonObj.getString("Answer 35");
        }else if(nAnswer.contains("Answer 36")){
            Answer = jsonObj.getString("Answer 36");
        }else if(nAnswer.contains("Answer 37")){
            Answer = jsonObj.getString("Answer 37");
        }else if(nAnswer.contains("Answer 38")){
            Answer = jsonObj.getString("Answer 38");
        }else if(nAnswer.contains("Answer 39")){
            Answer = jsonObj.getString("Answer 39");
        }else if(nAnswer.contains("Answer 40")){
            Answer = jsonObj.getString("Answer 40");
        }else if(nAnswer.contains("Answer 41")){
            Answer = jsonObj.getString("Answer 41");
        }else if(nAnswer.contains("Answer 42")){
            Answer = jsonObj.getString("Answer 42");
        }else if(nAnswer.contains("Answer 43")){
            Answer = jsonObj.getString("Answer 43");
        }else if(nAnswer.contains("Answer 44")){
            Answer = jsonObj.getString("Answer 44");
        }else if(nAnswer.contains("Answer 44")){
            Answer = jsonObj.getString("Answer 44");
        }else if(nAnswer.contains("Answer 45")){
            Answer = jsonObj.getString("Answer 45");
        }else if(nAnswer.contains("Answer 46")){
            Answer = jsonObj.getString("Answer 46");
        }else if(nAnswer.contains("Answer 47")){
            Answer = jsonObj.getString("Answer 47");
        }else if(nAnswer.contains("Answer 48")){
            Answer = jsonObj.getString("Answer 48");
        }

        return Answer;
    }

    /**
     * this method loads a json file from the assets folder
     * @param context context
     * @return string json
     */
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("myfile48.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    /**
     * method that is used to save data to internal storage (file)
     * @param message
     */
    private void writeToFile(String message)
    {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("answer.txt",
                    Context.MODE_PRIVATE));
            outputStreamWriter.write(message);
           // outputStreamWriter.flush();
            outputStreamWriter.close();

        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method use to load data from internal storage(file)
     * @return
     * @throws IOException
     */
    private String readFromFile() throws IOException {
        String result = "";
        InputStream inputStream = openFileInput("answer.txt");
        if(inputStream != null)
        {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String temp;
            StringBuilder stringBuilder = new StringBuilder();

            while((temp = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(temp);
                stringBuilder.append("\n");
            }

            inputStream.close();
            result = stringBuilder.toString();
        }
        return result;
    }



    /**
     * this method opens the activity tutorial with the aproppiate tutorial depending the plan
     */
    public void openTutorials(){


        Intent intent = new Intent(this,Tutorial.class);
        intent.putExtra("text",ExecutionList);

        if(flag == 1){
            //intent.putExtra("mylist", ListOfCompleted);
            intent.putExtra("mylist", replanningList);
        }else{
            intent.putExtra("mylist", myList);
        }
       // String username =  getIntent().getExtras().getString("username");
        intent.putExtra("username",username);

        String mood = getIntent().getExtras().getString("mood");
        intent.putExtra("mood",mood);


        startActivity(intent);

    }

    /**
     * opens the activity for tests
     */
    public void openTests(){

        Intent intent = new Intent(this,Test.class);
        intent.putExtra("text",ExecutionList);
        String mood = getIntent().getExtras().getString("mood");
        intent.putExtra("mood",mood);
        intent.putExtra("username",username);
       // intent.putExtra("mylist", myList);
        if(flag == 1){
          //  intent.putExtra("mylist", ListOfCompleted);
            intent.putExtra("mylist", replanningList);
        }else{
            intent.putExtra("mylist", myList);
        }
        startActivity(intent);

    }

    public void showHelp(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Here is a preview of your course , when you are ready click the start button.", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

