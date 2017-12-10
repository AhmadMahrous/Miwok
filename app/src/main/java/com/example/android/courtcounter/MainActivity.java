package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitScore(View view){
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    public void submitScore1(View view){
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);
    }

    public void submitScore2(View view){
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    public void displayForTeamA(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void submitScoreB(View view){
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    public void submitScore1B(View view){
        scoreTeamB +=2;
        displayForTeamB(scoreTeamB);
    }

    public void submitScore2B(View view){
        scoreTeamB +=1;
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamB(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void reset(View view){
        scoreTeamA =  0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
