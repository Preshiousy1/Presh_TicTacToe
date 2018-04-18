package com.example.android.presh_tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
    }

//    public void resumeGame(View view) {
//
//        Intent intent = new Intent(this, _3X3Activity.class);
//        startActivity(intent);
//        onResume();
//
//    }

    public void newGame(View view) {
        if (SettingsActivity.Spinner1ItemSelected.equals("1 Player")
                && SettingsActivity.Spinner2ItemSelected.equals("3")
                 ) {
            Intent intent = new Intent(this, _3X3Activity.class);
            // _3X3Activity.resetGame();
            startActivity(intent);

        }


        else if (SettingsActivity.Spinner2ItemSelected.equals("3")
                && SettingsActivity.Spinner1ItemSelected.equals("2 Players")) {
            Intent intent = new Intent(this, _3X3Activity.class);
            // _3X3Activity.resetGame();
            startActivity(intent);
        }


        else if (SettingsActivity.Spinner2ItemSelected.equals("4")
                && SettingsActivity.Spinner1ItemSelected.equals("1 Player"))
        {
            Intent intent = new Intent(this, _4x4Activity.class);
            startActivity(intent);
            _4x4Activity.numOfPlayers = "1 Player";
        }


        else if (SettingsActivity.Spinner2ItemSelected.equals("4")
                && SettingsActivity.Spinner1ItemSelected.equals("2 Players"))
        {
            Intent intent = new Intent(this, _4x4Activity.class);
            startActivity(intent);
            _4x4Activity.numOfPlayers = "2 Players";
        }

        else if (SettingsActivity.Spinner2ItemSelected.equals("5")
                && SettingsActivity.Spinner1ItemSelected.equals("1 Player"))
        {
            Intent intent = new Intent(this, _5x5Activity.class);
            startActivity(intent);
            _5x5Activity.numOfPlayers = "1 Player";
        }

        else
        {
            Intent intent = new Intent(this, _5x5Activity.class);
            startActivity(intent);
        }

    }
  public void settingsPage(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
