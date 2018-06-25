package com.example.arvind.tictactoe1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0,flag;
    boolean gameActive=true;
    int gamestate[]={2,2,2,2,2,2,2,2,2};//here 2 denotes that the cell is empty
    int winningPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public void dropIn(View view)
    {

        ImageView counter=(ImageView)view;

        int tappedCounter=Integer.parseInt(counter.getTag().toString());//getTag return the tag associated with that imageview

        if(gamestate[tappedCounter]==2&&gameActive) {
            //counter.setTranslationY(-1500);

            //Value of active player 0 means chance is of yellow whereas 1 means chance is of red


            gamestate[tappedCounter] = activePlayer;

            if (activePlayer == 0) {
                counter.setTranslationY(-1500);
                counter.setImageResource(R.drawable.yellow);
                counter.animate().translationYBy(1500).rotationBy(360).setDuration(375);
                activePlayer = 1;
            } else {
                counter.setTranslationY(1500);
                counter.setImageResource(R.drawable.red);
                counter.animate().translationYBy(-1500).rotationBy(360).setDuration(375);

                activePlayer = 0;
            }
            //counter.animate().translationYBy(1500).rotationBy(360).setDuration(375);

            winning();
        }
    }
    void winning()
    {
        //The below are the winnnning position of player in the 2d matrix
        //int winningPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        flag=0;
        TextView textView=findViewById(R.id.winningTextView);

        Button playButton=findViewById(R.id.playAgainButton);

        for(int winPosition[]:winningPositions)
        {
            if(gamestate[winPosition[0]]==gamestate[winPosition[1]]&&gamestate[winPosition[1]]==gamestate[winPosition[2]]&&gamestate[winPosition[0]]!=2)
            {
                gameActive=false;
                String winner;
                if(activePlayer==1)
                    winner="Yellow";
                else
                    winner="Red";
                //Toast.makeText(getApplicationContext(), winner+" has won the match! ", Toast.LENGTH_SHORT).show();
                textView.setText(winner+" has won the match! ");
                textView.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.VISIBLE);
                flag=1;
            }
        }
        if(checkTie()&&gameActive)
        {
            textView.setText("Match is tie !");
            textView.setVisibility(View.VISIBLE);
            playButton.setVisibility(View.VISIBLE);
        }
    }
    boolean checkTie()
    {
        for(int i=0;i<9;i++)
        {
            if(gamestate[i]==2)
                return false;
        }
        return true;
    }

    public void playAgain(View view)
    {

        TextView textView=findViewById(R.id.winningTextView);

        Button button=findViewById(R.id.playAgainButton);

        textView.setVisibility(View.INVISIBLE);

        button.setVisibility(View.INVISIBLE);

        GridLayout gridLayout=findViewById(R.id.gridLayout);

        for(int i=0;i<gridLayout.getChildCount();i++)//getchildcount return the no. of cells in grid layout
        {
            ImageView counter=(ImageView)gridLayout.getChildAt(i);//it will return the imagview at a particulat cell
            counter.setImageDrawable(null);//it will remove the image from the grid cell
        }
        for(int i=0;i<9;i++)
            gamestate[i]=2;

        if(activePlayer==0)
        activePlayer=1;
        else if(activePlayer==1)
        {
            activePlayer=0;
        }
        gameActive=true;


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
