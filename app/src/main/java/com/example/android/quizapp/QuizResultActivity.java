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
package com.example.android.quizapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class QuizResultActivity extends AppCompatActivity {

    private TextView finalResultHeaderTextView, correctAnswerHeaderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        // Recieving message intents from previous acitivity "QuizActivity".
        Bundle bundle = getIntent().getExtras();
        String TSmessage = bundle.getString("totalScoreMessage");
        String RSmessage = bundle.getString("resultSummaryMessage");

        TextView TsTextView = (TextView) findViewById(R.id.totalScore);
        TsTextView.setText(TSmessage);

        TextView RsTextView = (TextView) findViewById(R.id.resultSummary);
        RsTextView.setText(RSmessage);

        // Setting a custom TypeFace for "totalScore" TextView.
        Typeface scoreTypeFace = Typeface.createFromAsset(
                getApplicationContext().getAssets(), "fonts/Mark Simonson - Proxima Nova Thin-webfont.ttf"
        );

        finalResultHeaderTextView = (TextView) findViewById(R.id.final_result_header);
        correctAnswerHeaderTextView = (TextView) findViewById(R.id.correct_answer_header);

        // Setting a custom TypeFace for Header TextViews.
        Typeface headerTypeFace = Typeface.createFromAsset(
                getApplicationContext().getAssets(), "fonts/Mark Simonson - Proxima Nova Alt Bold-webfont.ttf"
        );

        TsTextView.setTypeface(scoreTypeFace);
        RsTextView.setTypeface(scoreTypeFace);

        finalResultHeaderTextView.setTypeface(headerTypeFace);
        correctAnswerHeaderTextView.setTypeface(headerTypeFace);
    }
}
