package com.example.android.quizapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class QuizResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        // Recieving message intents from previous acitivity "QuizActivity".
        Bundle bundle = getIntent().getExtras();
        String TSmessage = bundle.getString("totalScoreMessage");
        String RSmessage = bundle.getString("resultSummaryMessage");

        TextView TStextView = (TextView) findViewById(R.id.totalScore);
        TStextView.setText(TSmessage);

        TextView RStextView = (TextView) findViewById(R.id.resultSummary);
        RStextView.setText(RSmessage);

        // Setting a custom TypeFace for "totalScore" TextView.
        Typeface TStypeFace = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Nunito-Regular.ttf");
        TStextView.setTypeface(TStypeFace);
    }
}
