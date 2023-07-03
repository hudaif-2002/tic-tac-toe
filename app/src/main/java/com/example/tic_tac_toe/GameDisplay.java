package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {
private TicTacToeBoard ticTacToeBoard;
    Button playAgainBTN,homeBTN;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);


          playAgainBTN=findViewById(R.id.playagainbtn);
       homeBTN=findViewById(R.id.homebtn);
        TextView playerTurn =findViewById(R.id.playerdisplay);


        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        String[] playerNames=getIntent().getStringArrayExtra("PLAYER_NAMES");
        if(playerNames!=null)
        {
            playerTurn.setText(playerNames[0]+"'s Turn");
        }


        ticTacToeBoard=findViewById(R.id.ticTacToeBoard);

        ticTacToeBoard.setUpGame(playAgainBTN,homeBTN,playerTurn,playerNames);






    }
    public void playAgainButtonClick(View view)
    {
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }
    public void homeButtonClick(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}