/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pratiksymz.android.quizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView descriptionHeader, goodLuckView, descriptionTextView;
    private Button startButton;
    private float x1, y1;
    private float x2, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Using a custom TypeFace for TextViews
         */
        descriptionHeader = (TextView) findViewById(R.id.descriptionHeader);
        goodLuckView = (TextView) findViewById(R.id.goodLuck);
        descriptionTextView = (TextView) findViewById(R.id.descriptionLines);

        Typeface headerTypeFace = Typeface.createFromAsset(
                getApplicationContext().getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Black-webfont.ttf"
        );

        Typeface goodLuckTypeFace = Typeface.createFromAsset(
                getApplicationContext().getAssets(),
                "fonts/Mark Simonson - Proxima Nova Alt Bold-webfont.ttf"
        );

        Typeface descriptionLinesTypeFace = Typeface.createFromAsset(
                getApplicationContext().getAssets(),
                "fonts/Mark Simonson - Proxima Nova Thin-webfont.ttf"
        );

        descriptionHeader.setTypeface(headerTypeFace);
        goodLuckView.setTypeface(goodLuckTypeFace);
        descriptionTextView.setTypeface(descriptionLinesTypeFace);


        /**
         * Setting an OnClickListener for the "Continue" button to launch another acitivity named "QuizActivity".
         */
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(quizIntent);
            }
        });

    }

}
