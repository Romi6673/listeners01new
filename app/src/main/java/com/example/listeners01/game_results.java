package com.example.listeners01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class game_results extends AppCompatActivity {
    Intent gi;

    int xRed, xBlue;

    TextView winnerTitle;
    TextView red_player_score;
    TextView blue_player_score;

    Button playAgainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_results);
        playAgainBtn= findViewById(R.id.playAgainBtn);
        winnerTitle=findViewById(R.id.winnerTitle);
        red_player_score=findViewById(R.id.red_player_score);
        blue_player_score=findViewById(R.id.blue_player_score);

        gi = getIntent();
        xRed = gi.getIntExtra("playerScoreRed",-1);
        xBlue = gi.getIntExtra("playerScoreBlue",-1);

        red_player_score.setText(xRed+"");
        blue_player_score.setText(xBlue+"");

        if (xRed>xBlue){
            winnerTitle.setText("RED");
            winnerTitle.setTextColor(Color.RED);



        }else if (xBlue>xRed) {
            winnerTitle.setText("BLUE");
            winnerTitle.setTextColor(Color.BLUE);
        }else{
            winnerTitle.setText("A TIE");
            winnerTitle.setTextColor(Color.GREEN);
        }
    }


    public void goToGamePlay(View view) {
        Intent pi = new Intent(this,MainActivity.class);
        startActivity(pi);
    }
}