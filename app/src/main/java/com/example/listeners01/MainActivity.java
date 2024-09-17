package com.example.listeners01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Button btnRed;
    Button btnBlue;
    int playerRedScore=0;
    int playerBlueScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRed= findViewById(R.id.btnRed);
        btnBlue= findViewById(R.id.btnBlue);

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "+1", Toast.LENGTH_SHORT).show();
                playerBlueScore++;
            }
        });
        ;

        btnRed.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                playerRedScore += 2;
                Toast.makeText(getApplicationContext(), "+2", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    public void getResult(View view) {
        Intent si = new Intent(this,game_results.class);

        si.putExtra("playerScoreRed",playerRedScore);
        si.putExtra("playerScoreBlue",playerBlueScore);
        startActivity(si);
        playerRedScore=0;
        playerBlueScore=0;

    }
}