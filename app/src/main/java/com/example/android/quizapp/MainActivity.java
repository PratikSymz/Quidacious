package com.example.android.quizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Using a custom TypeFace "Nunito" (or "Avenir") for the header TextView
         */
        TextView descriptionHeader = (TextView) findViewById(R.id.descriptionHeader);
        TextView goodLuckView = (TextView) findViewById(R.id.goodLuck);

        Typeface headerTypeFace = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Nunito-Regular.ttf");
        Typeface goodLuckTypeFace = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Nunito-Light.ttf");

        descriptionHeader.setTypeface(headerTypeFace);
        goodLuckView.setTypeface(goodLuckTypeFace);


        /**
         * Setting an OnClickListener for the "Continue" button to launch another acitivity named "QuizActivity".
         */
        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(quizIntent);
            }
        });
    }

}
