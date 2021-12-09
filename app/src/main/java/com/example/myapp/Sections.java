package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Sections extends AppCompatActivity {
    ArrayList<String> myList;
    TextView myText ;
    int TutorialNumber = 0;
    String username;

    /* array of images for sections */

    int[] SectionImages = {R.drawable.tut01,R.drawable.tut02,R.drawable.tut03,R.drawable.tut04,R.drawable.tut05,R.drawable.tut06,R.drawable.tut07,
            R.drawable.tut08,R.drawable.tut09,R.drawable.tut10,R.drawable.tut11,R.drawable.tut12,R.drawable.tut13,R.drawable.tut14,R.drawable.tut15,
            R.drawable.tut16,R.drawable.tut17,R.drawable.tut18,R.drawable.tut19,R.drawable.tut20};

    @SuppressLint("SetTextI18n")
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);

        final TextView textTut22 = findViewById(R.id.TxtViewTut22);
        textTut22.setVisibility(View.INVISIBLE);

        final TextView text = findViewById(R.id.textViewCh01Sec);
        text.setVisibility(View.INVISIBLE);
        Button nextSect = findViewById(R.id.buttonch01Sec);
        nextSect.setVisibility(View.INVISIBLE);
        Button prevSect =  findViewById(R.id.buttonch01Sec3prv);
        prevSect.setVisibility(View.INVISIBLE);
        Button endBtn = findViewById(R.id.EndTutButton);
        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToTutorial();
            }
        });


        username =  getIntent().getExtras().getString("username");
        myText =  findViewById(R.id.testText);
        myText.setVisibility(View.GONE);
        myText.setText(getIntent().getExtras().getString("text"));
        myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");
      //  DoneList = (ArrayList<String>) getIntent().getSerializableExtra("DoneList");

            switch (myText.getText().toString()) {
                case "Tutorial 01":
                    TutorialNumber = 1;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);

                    text.setText("      Before you start setting up the game, check to see that you have everything. Doing so will also help you to become more familiar with the game pieces and parts.\n " +
                            "19 terrain hexes (four sheep, four wheat, four wood, three brick, three ore, and one desert). \n" +
                            "Six sea frame pieces.\n" +
                            "18 circular number tokens.\n" +
                            "A black/grey robber pawn.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                   // title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 02":
                    TutorialNumber = 2;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    text.setText("      The object of Settlers of Catan is to be the first to gain 10 victory points. Points are earned by building structures, buying cards, and earning accomplishment cards such as “Longest Road” and “Largest Army”. \n" +
                            "Each settlement is worth one victory point and each city is worth two victory points.\n " +
                            "Each \"Victory Point\" card is worth one victory point. " );
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                   // title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                   // title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 03":
                    TutorialNumber =3;
                    nextSect.setVisibility(View.INVISIBLE);
                    prevSect.setVisibility(View.INVISIBLE);
                    text.setText("      Before you lay down the hexes to create the game board, place the outer frame pieces.\n"+
                            "Each frame has a small number on the edges where it connects to other pieces.\n"+
                            "Put the frames together by matching the numbers up.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                   // title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();

                    break;
                case "Tutorial 04":
                    TutorialNumber = 4;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    text.setText("      Put a random terrain hex on the inside of the frame so that its edges are touching the sea frame.\n"+
                            "Keep putting down random terrains in a clockwise fashion until you have reached the center and\n"+
                            "all of the terrain hexes fill are inside the frame.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                  //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                   // title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 05":
                    TutorialNumber = 5;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    text.setText("      Each token has a small letter above its number. \n"+
                            "Place the number token with the letter \"A\" on one of the edge terrain hexes, "+
                            "put the token with the letter  to the right of the first placed token "+
                            "and continue on putting down tokens in alphabetical order in a clockwise fashion until you have reached the center.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                   // title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                   // title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });

                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 06":
                    TutorialNumber = 6;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    text.setText("      Place the robber on the desert tile. The robber is the small gray piece that resembles a bowling pin.\n" +
                            "The robber starts out on the desert tile, but may be moved whenever someone rolls a seven or plays a Knight card.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                  //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                  //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();

                    break;
                case "Tutorial 07":
                    TutorialNumber = 7;
                    nextSect.setVisibility(View.INVISIBLE);
                    prevSect.setVisibility(View.INVISIBLE);
                    text.setText("      The resource cards and development cards should be placed near the board where they are easily accessible to all players.\n" +
                            " Keep the resource cards separated by type (sheep, lumber, bricks, rocks, and wheat) and keep the development cards separate from the resource cards." +
                            " Place the resource cards in five separate piles facing up and place the development cards in a separate pile facing down.\n"+
                           " You should shuffle the development cards, but do not shuffle the resource cards!");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 08":
                    TutorialNumber = 8;
                    nextSect.setVisibility(View.INVISIBLE);
                    prevSect.setVisibility(View.INVISIBLE);
                    text.setText("      Every player rolls two dice to start. " +
                            "The player who rolls the highest number gets to select his or her color and take the first turn.\n " +
                            "There are four colors included with the Base Catan 3-4 player set: red, blue, white, and orange.\n" +
                            "After the player with the highest dice roll has chosen his or her color, have everyone else choose and then begin the turns.\n" +
                            "Turns progress in a clockwise manner.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 09":
                    TutorialNumber = 9;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    text.setText("      The first player places one of his settlements at an intersection, " +
                            "where three terrain hexes meet, the adjoining hexes are the resources he will earn if the number on that hex is rolled (so choose wisely!).\n" +
                            " Next, he places one of his roads on one of the three possible places next to his first settlement.\n" +
                            " The next player then takes her turn in the same way, but must place her settlement in a different area.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 10":
                    TutorialNumber = 10;
                    nextSect.setVisibility(View.INVISIBLE);
                    prevSect.setVisibility(View.INVISIBLE);
                    text.setText("      The last player gets to place two settlements and two roads (one for each settlement) and then going counter-clockwise," +
                            " the first players place their second settlement and second road until each player has two settlements and two roads down on the board.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 11":
                    TutorialNumber = 11;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    text.setText("      After all players have placed both of their settlements and roads, you all get some resource cards to start.\n" +
                            "Take one resource card for each hex tile that is adjacent to each of your two settlements.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 12":
                    TutorialNumber = 12;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    text.setText("      Each player's settlement will be touching three terrain hexes with three numbers.\n" +
                            "If the number that is rolled corresponds to the number that a player's settlement is on, " +
                            "then that player gets to pick up a resource card of that terrain hex.\n" +
                            "The same is true for a player with a city (instead of a settlement), except that they would get to pick up two resource cards. " +
                            "You also get more resource cards if you have more than one settlement bordering a hex." );
                            nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 13":
                    TutorialNumber = 13;
                    nextSect.setVisibility(View.INVISIBLE);
                    prevSect.setVisibility(View.INVISIBLE);
                    text.setText("      After the dice are rolled, " +
                            "the player then has the option of either building structures like roads or upgrading settlements to cities," +
                            " playing a development card, or trading. Players may choose to do all or none of these actions.\n" +
                            "When a player has finished taking his or her actions, the player then passes the dice to the right. " +
                            "You may only play one development card per turn." );
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 14":
                    TutorialNumber = 14;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    text.setText("      During their turn, players can use resources that they have to build structures, such as roads, settlement, and cities. " +
                            "See your building cost card to figure out what you can build with the resources that you have.\n" +
                            "Keep in mind that each settlement is worth 1 point and each city is worth 2 points, but you have to upgrade settlements to cities. " +
                            "You cannot just build a city without first having a settlement.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 15":
                    TutorialNumber = 15;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    text.setText("      Players may play development cards at the beginning or end of their turn.\n" +
                            "Development cards do different things but their effects are clearly stated on the card itself. " +
                            "Development cards come in the following types:\n" +
                            "A \\\"Knight\\\" card allows a player to move the robber to any spot on the board and then gets to take a card from any player that has a settlement or city on the blocked resource." );
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 16":
                    TutorialNumber = 16;
                    nextSect.setVisibility(View.INVISIBLE);
                    prevSect.setVisibility(View.INVISIBLE);
                    text.setText("      Pay attention to the instructions on development cards because each card type has a different function." +
                            "For example, if you play a knight card, you must turn it face up and move the robber right away. " +
                            "You may move the robber to any hex and then collect one resource (at random) from the opponent who owns that hex. " +
                            "If two opponents have settlements bordering that hex, then you may choose who to rob. " +
                            "Keep any victory point cards that you draw face down so that your opponents cannot see them." );
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 17":
                    TutorialNumber = 17;
                    nextSect.setVisibility(View.INVISIBLE);
                    prevSect.setVisibility(View.INVISIBLE);
                    text.setText("      The player can also trade for resources, either with any other players or with the bank.\n " +
                            "A player may trade in four of the same resource card for any resource card. If player is on a special harbor, " +
                            "that player may trade in two of that harbor's resource for any resource card." +
                            " At a generic harbor a player may trade in three of the same resource card for any resource card." );
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 18":
                    TutorialNumber = 18;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    text.setText("      If a player rolls a seven, then each player must make sure that he/she does not have more than seven cards in his or her hand. " +
                            "If a player does have more than seven cards, that player must discard half of them." +
                            " The person that rolled the seven then gets to put the robber on whatever number token he/she desires, and then, gets to take one card from any player that has a settlement or city touching the terrain hex with the robber on it.\n" );
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 19":
                    TutorialNumber = 19;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    text.setText("      There are a number of strategies that you can use to help you get the upper hand and win the game. " +
                            "The most basic strategy is to get your starting settlement in an area that give you access to the most commonly rolled resources (the resources with the red or physically larger numbers). " +
                            "Some other strategies include:\n" +
                            "Setting yourself up to build roads and settlements by aiming for lots of brick and wood hexes in the beginning.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 20":
                    TutorialNumber = 20;
                    nextSect.setVisibility(View.INVISIBLE);
                    prevSect.setVisibility(View.INVISIBLE);
                    text.setText("      To win the game, you need to be the first one to get 10 victory points." +
                            " Once you achieve this number, announce it to your fellow players. " +
                            "Keep in mind that your victory points cards and any special cards, such as “Longest Road” or “Largest Army”, " +
                            "will count towards your 10 point total. " +
                            "Keep a running total of your points as you play the game so that you don’t surpass 10 points without noticing.\n" +
                            "You can extend the game by playing until someone achieves a higher number of points, like 12 or 14 points." );
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    text.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    text.setText(setText1());
                                }
                            });
                    text.setVisibility(View.VISIBLE);
                    changeImage();
                    break;
                case "Tutorial 21":
                    TutorialNumber = 21;
                    nextSect.setVisibility(View.INVISIBLE);
                    prevSect.setVisibility(View.INVISIBLE);
                    VideoView videoView = findViewById(R.id.videoViewTut21);
                    videoView.setVisibility(View.VISIBLE);
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.tut21);
                    MediaController mediaController = new MediaController(Sections.this);
                    mediaController.setAnchorView(videoView);
                    videoView.setMediaController(mediaController);
                    videoView.start();

                    break;
                case "Tutorial 22":
                    TutorialNumber = 22;
                    nextSect.setVisibility(View.VISIBLE);
                    prevSect.setVisibility(View.VISIBLE);
                    textTut22.setText("     Number diversity strategy.\n" +
                            "Given there is a limit of 7 cards before you are at risk of losing half your cards, it can be advantageous to have a steady " +
                            "stream of resources coming into your hand throughout the game. The best way to do this is to place your two first settlements" +
                            "on intersections with six different numbers total with ideally, the highest probability.  If you can manage it, the best " +
                            "numbers to be on from the beginning would be 4,5,6,8,9,10 or some combination as close to that as possible.  Ideally you" +
                            "would avoid being on a number twice and would expand such that your first settlement gains you two more numbers like 3 and 11 " +
                            "given the example above.\n\n"+
                            "       Tip: Carefully consider initial road placement.\n" +
                            "Amateur players often think very little about which way to point their first roads.  You will quickly learn that pointing a " +
                            "road directly to a dead end or another opponent's settlement is very costly.  Make sure you point your road toward an area " +
                            "you want to expand that also is likely to be open after all the initial settlements have been laid.  I generally think it's a" +
                            "bad idea to \"fight it out\" for a settlement spot when two people have their roads pointed toward the same place.  If you lose " +
                            "that first battle, there's a very high chance you'll lose the whole game.");
                    nextSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle());
                                    textTut22.setText(setText());
                                }
                            });
                    prevSect.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //  title.setText(setTitle1());
                                    textTut22.setText(setText1());
                                }
                            });
                    textTut22.setVisibility(View.VISIBLE);
                    break;
                case "Tutorial 23":
                    TutorialNumber = 23;
                    nextSect.setVisibility(View.INVISIBLE);
                    prevSect.setVisibility(View.INVISIBLE);

                    VideoView videoView2 = findViewById(R.id.videoViewTut21);
                    videoView2.setVisibility(View.VISIBLE);
                    videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.tut23);
                    mediaController = new MediaController(Sections.this);
                    mediaController.setAnchorView(videoView2);
                    videoView2.setMediaController(mediaController);
                    videoView2.start();
                    break;
                default:
                    nextSect.setVisibility(View.INVISIBLE);
                    prevSect.setVisibility(View.INVISIBLE);
                    text.setText("Something went wrong!");
                    text.setVisibility(View.VISIBLE);
                    break;

            }


    }//end of onCreate

    /**
     * this method is used to go to the next sect of the tutorial.
     * @return the text for the next section
     */
    private String setText( ){

        final String[] text = new String[1];

        if(TutorialNumber == 1) {
            text[0] = "     Four sets of wooden player pieces in four different colors each containing five settlements, four cities, and 15 roads.\n" +
                    "25 development cards consisting of 14 knight/soldier cards, 6 progress cards, and 5 victory points. " +
                    "Resource cards of each terrain hex except for the desert." +
                    "Four building costs cards, one for each player. " +
                    "\"Longest Road\" and \"Largest Army\" award cards. " +
                    "Two dice, one red, one yellow.\n" +
                    "Extra harbor pieces for placement of random harbors (optional).";
        }else if( TutorialNumber == 2){
            text[0] ="      Each special card is worth two victory points. The \"Longest Road\" card will be awarded to the first person to successfully "+
                    "build a continuous five roads. The card will switch hands whenever a player's number of connecting roads surpasses the longest "+
                    "continuous road of the cardholder. The \"Largest Army\" card will be awarded to the first person to play three \"Knight\" cards.\n"+
                    "The card will switch hands whenever a player plays more \"Knight\" cards than the \"Largest Army\" cardholder.";
        }else if (TutorialNumber == 4){
            text[0] ="      You may want to place the desert hex on an outside edge, away from any trade ports, to make the game a bit easier. " +
                    "A variation on this way of laying out the hexes is to place all of the hexes face down.\n" +
                    "They may only be turned upwards when someone places a road or a settlement on that hex.";
        }else if(TutorialNumber == 5){
            text[0] ="      All of the terrain hexes should now have a token on them. " +
                    "These numbers determine which roll will grant which player resources to use. " +
                    "Do not place a number on the desert hex. " +
                    "You may also place tokens at random without paying attention to the letters, but this will make the game more challenging. ";
        }else if(TutorialNumber == 6){
            text[0] ="      The player who rolled the number takes the Robber and moves it to a hex of his or her choice.\n" +
                    " That player then steals a resource or commodity from the hand of one of the opponents bordering that hex. " +
                    " Until another \"7\" is rolled or another situation occurs where the Robber may be moved, " +
                    "the hex on which the Robber stands does not produce any resources or commodities.";
        }else if(TutorialNumber == 9){
            text[0] ="      Roads must always be placed where two hexes meet and border the player's settlement.\n" +
                    "A settlement cannot be placed on an intersection adjacent to another intersection occupied by a settlement. " +
                    "There must be enough space for at least two roads between each settlement.";
        }else if(TutorialNumber == 11){
            text[0] = "     For example, if one of your settlements is bordering a wheat, lumber, and sheep tile," +
                    " then you get to take one wheat, one lumber and one sheep card. " +
                    "Do the same for your other settlement.";
        }else if(TutorialNumber == 12){
            text[0] = "     For example, if you have two settlements on the edges of a hex and that hex’s number is rolled, then you get two of that hex’s resource cards. " +
                    "All players are eligible to get resource cards even if they are not rolling the dice. " +
                    "If a number is rolled by another player and you have a settlement bordering that hex, then you get a resource card.\n" +
                    "The only exception is if the robber is on your hex." +
                    " In that case, you are blocked from receiving any resources from that hex until someone moves the robber again.";
        }
        else if(TutorialNumber == 14){
            text[0] = "     To build a road you need: One wood and one brick.\n" +
                    "To build a settlement you need: One wood, one brick, one sheep, and one wheat.\n" +
                    "To build a city you need: Three ore and two wheat. Cities can only be built in place of an already existing settlement.\n" +
                    "To buy a development card you need: One sheep, one wheat, and one ore ." ;
        }else if(TutorialNumber == 15){
            text[0] = "     A \"Road Building\" card allows a player to place two roads on the board.\n" +
                    "A \"Year of Plenty\" card gives a player any two resource cards.\n" +
                    "After a player plays the \"Monopoly\" card, that player announces one type of resource. Every player must then give that player all of that type of resource card(s) in their hand.\n" +
                    "A \"Victory Point\" card automatically gives the player one victory point.";
        }else if(TutorialNumber == 18){
            text[0] ="      Keep in mind that the robber blocks players from getting resource from a hex.\n " +
                    "In other words, if the hex number occupied by the robber is rolled," +
                    " players with settlements or cities on that number do not get to collect the resource the robber is blocking." ;
        }else if(TutorialNumber == 19){
            text[0] = "     Monopolizing ports. Try to get a port and at least two cities on different hexes with the same resource," +
                    " so that you can trade for whatever you need. " +
                    "Targeting the winning player(s) with the robber and Knight cards. " +
                    "Robbing your opponents can keep them from progressing too much while also gaining yourself some extra resources. " +
                    "Building cities (and settlements) as soon as you can. When you have lots of resources to work with, " +
                    "you'll be able to trade and build easily." ;
        }
        else if(TutorialNumber == 22){

            text[0] = "     Cities first strategy\n" +
                    "Since cities double your earning power, an effective strategy can be to optimize for as much wheat and rock as you can get " +
                    "early in the game, upgrade to two cities as quickly as possible, and then trade out some of your abundant wheat and rock for " +
                    "wood and brick later to build roads and expand."+"If you can get access to sheep with this strategy, you can also quickly and " +
                    "easily pursue a strategy of buying a lot of development cards before building more settlements.\n\n"+
                    "       Corner scarce resources strategy\n" +
                    "Depending on where the numbers land, it is always good to take a scan of which resources will be the most scarce in the game." +
                    "Brick and rock only have 3 tiles on the board whereas others have 4 so they are usually the best candidates.  However, if you " +
                    "see that wood only has one strong number and three very weak numbers, then you may want to corner out that strong number on " +
                    "wood, bolstering your trading power in the game.";

        }


        return text[0];
    }

    /**
     * this method is use to return to the previous sec
     * @return the text for the previous section
     */
    private String setText1(){
        final String[] text = new String[1];
        if (TutorialNumber == 1){
            text[0] = "      Before you start setting up the game, check to see that you have everything. Doing so will also help you to become more familiar with the game pieces and parts.\n " +
                    "19 terrain hexes (four sheep, four wheat, four wood, three brick, three ore, and one desert). \n" +
                    "Six sea frame pieces.\n" +
                    "18 circular number tokens.\n" +
                    "A black/grey robber pawn.";
        }else if(TutorialNumber == 2){
            text[0] = "      The object of Settlers of Catan is to be the first to gain 10 victory points. Points are earned by building structures, buying cards, and earning accomplishment cards such as “Longest Road” and “Largest Army”. \n" +
                    "Each settlement is worth one victory point and each city is worth two victory points.\n " +
                    "Each \"Victory Point\" card is worth one victory point. ";
        }else if(TutorialNumber == 4){
            text[0] = "      Put a random terrain hex on the inside of the frame so that its edges are touching the sea frame.\n"+
                    "Keep putting down random terrains in a clockwise fashion until you have reached the center and\n"+
                    "all of the terrain hexes fill are inside the frame.";

        }else if(TutorialNumber == 5){
            text[0] = "      Each token has a small letter above its number. \n"+
                    "Place the number token with the letter \"A\" on one of the edge terrain hexes, "+
                    "put the token with the letter  to the right of the first placed token "+
                    "and continue on putting down tokens in alphabetical order in a clockwise fashion until you have reached the center.";

        }else if(TutorialNumber == 6){
            text[0] = "      Place the robber on the desert tile. The robber is the small gray piece that resembles a bowling pin.\n" +
                    "The robber starts out on the desert tile, but may be moved whenever someone rolls a seven or plays a Knight card.";

        }else if(TutorialNumber == 9){
            text[0] ="      The first player places one of his settlements at an intersection, " +
                    "where three terrain hexes meet, the adjoining hexes are the resources he will earn if the number on that hex is rolled (so choose wisely!).\n" +
                    " Next, he places one of his roads on one of the three possible places next to his first settlement.\n" +
                    " The next player then takes her turn in the same way, but must place her settlement in a different area.";
        }
        else if(TutorialNumber == 11){

            text[0] ="      After all players have placed both of their settlements and roads, you all get some resource cards to start.\n" +
                    "Take one resource card for each hex tile that is adjacent to each of your two settlements.";
        }
        else if(TutorialNumber == 12){

            text[0] ="      Each player's settlement will be touching three terrain hexes with three numbers.\n" +
                    "If the number that is rolled corresponds to the number that a player's settlement is on, " +
                    "then that player gets to pick up a resource card of that terrain hex.\n" +
                    "The same is true for a player with a city (instead of a settlement), except that they would get to pick up two resource cards. " +
                    "You also get more resource cards if you have more than one settlement bordering a hex." ;

        }
        else if(TutorialNumber == 14){

            text[0] ="      During their turn, players can use resources that they have to build structures, such as roads, settlement, and cities. " +
                    "See your building cost card to figure out what you can build with the resources that you have.\n" +
                    "Keep in mind that each settlement is worth 1 point and each city is worth 2 points, but you have to upgrade settlements to cities. " +
                    "You cannot just build a city without first having a settlement.";

        } else if(TutorialNumber == 15){
            text[0] = "      Players may play development cards at the beginning or end of their turn.\n" +
                    "Development cards do different things but their effects are clearly stated on the card itself. " +
                    "Development cards come in the following types:\n" +
                    "A \\\"Knight\\\" card allows a player to move the robber to any spot on the board and then gets to take a card from any player that has a settlement or city on the blocked resource."  ;


        }else if(TutorialNumber == 18){
            text[0] = "     If a player rolls a seven, then each player must make sure that he/she does not have more than seven cards in his or her hand. " +
                    "If a player does have more than seven cards, that player must discard half of them." +
                    " The person that rolled the seven then gets to put the robber on whatever number token he/she desires, and then, gets to take one card from any player that has a settlement or city touching the terrain hex with the robber on it."  ;


        }else if(TutorialNumber == 19){

            text[0] ="      There are a number of strategies that you can use to help you get the upper hand and win the game. " +
                    "The most basic strategy is to get your starting settlement in an area that give you access to the most commonly rolled resources (the resources with the red or physically larger numbers). " +
                    "Some other strategies include:\n" +
                    "Setting yourself up to build roads and settlements by aiming for lots of brick and wood hexes in the beginning.";

        }
        else if(TutorialNumber == 22){
            text[0] ="     Number diversity strategy.\n" +
                    "Given there is a limit of 7 cards before you are at risk of losing half your cards, it can be advantageous to have a steady " +
                    "stream of resources coming into your hand throughout the game. The best way to do this is to place your two first settlements" +
                    "on intersections with six different numbers total with ideally, the highest probability.  If you can manage it, the best " +
                    "numbers to be on from the beginning would be 4,5,6,8,9,10 or some combination as close to that as possible.  Ideally you" +
                    "would avoid being on a number twice and would expand such that your first settlement gains you two more numbers like 3 and 11 " +
                    "given the example above.\n\n"+
                    "       Tip: Carefully consider initial road placement.\n" +
                    "Amateur players often think very little about which way to point their first roads.  You will quickly learn that pointing a " +
                    "road directly to a dead end or another opponent's settlement is very costly.  Make sure you point your road toward an area " +
                    "you want to expand that also is likely to be open after all the initial settlements have been laid.  I generally think it's a" +
                    "bad idea to \"fight it out\" for a settlement spot when two people have their roads pointed toward the same place.  If you lose " +
                    "that first battle, there's a very high chance you'll lose the whole game.";
        }



        return text[0];
    }
/*
    private String setTitle() {

        final String[] title = new String[1];
        if(TutorialNumber == 1) {
            title[0] = "Section 02";
        }else if(TutorialNumber == 2){
            title[0] ="Section 04";
        }else if (TutorialNumber == 4){
            title[0] ="Section 07";
        }else if (TutorialNumber == 5){
            title[0] = "Section 09";
        }else if (TutorialNumber == 6){
            title[0] = "Section 11";
        }
        return title[0];
    }

    private String setTitle1(){
        final String[] title = new String[1];
        if(TutorialNumber == 1){
            title[0] = "Section 01";
        }else if(TutorialNumber == 2){
            title[0] = "Section 03";
        }else if(TutorialNumber == 4){
            title[0] = "Section 06";
        }else if(TutorialNumber == 5){
            title[0] = "Section 08";
        }else if(TutorialNumber == 6){
            title[0] = "Section 10";
        }
        return title[0];
    } */
    public void backToTutorial(){
        Intent intent = new Intent(this,Tutorial.class);
        intent.putExtra("mylist", myList);
        intent.putExtra("username",username);

        String mood = getIntent().getExtras().getString("mood");
        intent.putExtra("mood",mood);
       // intent.putExtra("DoneList", DoneList);
        startActivity(intent);
    }

    public void changeImage(){
        ImageView myImg = findViewById(R.id.imageViewSections1);
        if(TutorialNumber > 0) {
            myImg.setImageResource(SectionImages[TutorialNumber - 1]) ;

            myImg.setVisibility(View.VISIBLE);
        }
    }

}
