package com.example.android.presh_tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class _4x4Activity extends AppCompatActivity implements View.OnClickListener {
    private static Button[][] game_buttons = new Button[4][4];

    private static boolean player1Turn = true;

    private static int roundCount;

    private static int player1Points;
    private static int player2Points;

    public static boolean numOfPlayers;

    private static TextView textViewPlayer1;
    private static TextView textViewPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__4x4);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                game_buttons[i][j] = findViewById(resID);
                game_buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (numOfPlayers){

            do {
                ((Button) v).setText("X");
                if (checkForWin()) {
                    if (player1Turn) {
                        player1Wins();
                    } else {
                        player2Wins();
                    }
                }
                roundCount++;
                player1Turn = !player1Turn;
            }
            while (player1Turn);
            ComputerPlays();

//                if(ComputerPlays()){
//                    resetBoard();
            //}
//                else{
//                    player1Turn=true;
//                }
        }


        else {

            if (player1Turn) {
                ((Button) v).setText("X");
            } else {
                ((Button) v).setText("O");
            }
            roundCount++;
        }



        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 16) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }

    }

    private void ComputerPlays()
    {
        Random rand;
        rand = new Random();

        if (roundCount!=16) {
            int i;
            int j;
//          String[][] field = new String[3][3];

            do {
                i = rand.nextInt( 4 );
                j = rand.nextInt(4);
            }while (!game_buttons[i][j].getText().toString().equals(""));
            game_buttons[i][j].setText("O");
            roundCount++;

//          field [i][j] = String.valueOf(game_buttons[i][j]);

//          return checkForWin();
        }
//      return checkForWin();
    }

    private boolean checkForWin() {
        String[][] field = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                field[i][j] = game_buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 4; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && field[i][0].equals(field[i][3])
                    && !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && field[0][i].equals(field[3][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && field[0][0].equals(field[3][3])
                && !field[0][0].equals("")) {
            return true;
        }

        if (field[0][3].equals(field[1][2])
                && field[0][3].equals(field[2][1])
                && field[0][3].equals(field[3][0])
                && !field[0][3].equals("")) {
            return true;
        }

        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }

        if (field[1][3].equals(field[2][2])
                && field[1][3].equals(field[3][1])
                && !field[1][3].equals("")) {
            return true;
        }

        if (field[1][0].equals(field[2][1])
                && field[1][0].equals(field[3][2])
                && !field[1][0].equals("")) {
            return true;
        }

        if (field[0][1].equals(field[1][2])
                && field[0][1].equals(field[2][3])
                && !field[0][1].equals("")) {
            return true;
        }

        return false;
    }

    private void player1Wins() {
        player1Points++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins() {
        player2Points++;
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private static void updatePointsText() {
        if (numOfPlayers){
            textViewPlayer1.setText("HUMAN: " + player1Points);
            textViewPlayer2.setText("COMPUTER: " + player2Points);
        }
        else{
            textViewPlayer1.setText("Player 1: " + player1Points);
            textViewPlayer2.setText("Player 2: " + player2Points);
        }
    }

    public static void resetBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                game_buttons[i][j].setText("");
            }
        }

        roundCount = 0;
        player1Turn = true;
    }

    public static void resetGame() {
        player1Points = 0;
        player2Points = 0;
        updatePointsText();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putBoolean("player1Turn", player1Turn);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("roundCount");
        player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");
        player1Turn = savedInstanceState.getBoolean("player1Turn");
    }
    public void WelcomeActivity(View view) {
        onPause();
        Intent intent = new Intent(this, WelcomePage.class);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
