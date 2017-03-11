package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    // A variable of type 'int' to keep track of the score.
    int totalScore;

    // Two variables declared for each question, except question 2 & 9, to keep track if a question is attempted or not.
    // If yes, then another variable to check if the question is correctly attempted or not.
    boolean hasAttemptedQ1, hasCorrectlyAttemptedQ1;    // IsCorrect and IsAttempted variables for Q1
    boolean hasAttemptedQ2, hasCorrectlyAttemptedQ2;    // IsCorrect and IsAttempted variables for Q2
    boolean hasAttemptedQ3, hasCorrectlyAttemptedQ3;    // IsCorrect and IsAttempted variables for Q3
    boolean hasAttemptedQ4, hasCorrectlyAttemptedQ4;    // IsCorrect and IsAttempted variables for Q4
    boolean hasAttemptedQ5, hasCorrectlyAttemptedQ5;    // IsCorrect and IsAttempted variables for Q5
    boolean hasAttemptedQ6, hasCorrectlyAttemptedQ6;    // IsCorrect and IsAttempted variables for Q6
    boolean hasAttemptedQ7, hasCorrectlyAttemptedQ7;    // IsCorrect and IsAttempted variables for Q7
    boolean hasAttemptedQ8, hasCorrectlyAttemptedQ8;    // IsCorrect and IsAttempted variables for Q8
    boolean hasAttemptedQ9, hasCorrectlyAttemptedQ9;    // IsCorrect and IsAttempted variables for Q9

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // An OnClickListener Intent for the "Submit" Button to launch another activity "QuizResultActivity".
        final Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Opening the new activity if the resultSummary() method results a non-null value.
                if (resultSummary(submitButton) != "") {

                    // Showing a Toast Message for Results.
                    if (totalScore < 10) {
                        Toast.makeText(QuizActivity.this, "You Scored: " + totalScore + " Points", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        Toast.makeText(QuizActivity.this, "Congrats! You Scored: " + totalScore + " out of 10", Toast.LENGTH_SHORT).show();
                    }

                    Intent resultsIntent = new Intent(QuizActivity.this, QuizResultActivity.class);
                    resultsIntent.putExtra("totalScoreMessage", getString(R.string.totalScore, totalScore));
                    resultsIntent.putExtra("resultSummaryMessage", resultSummary(submitButton));
                    totalScore = 0;
                    startActivity(resultsIntent);
                }

                // Showing a Toast message to tell the user to attempt all questions.
                else {
                    Toast.makeText(QuizActivity.this, "Please Attempt All The Questions!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * This method checks for all the variations in the answer for question 1.
     */
    public void addScoreQ1() {
        CheckBox redBox = (CheckBox) findViewById(R.id.Q1Red);
        CheckBox blueBox = (CheckBox) findViewById(R.id.Q1Blue);
        CheckBox greenBox = (CheckBox) findViewById(R.id.Q1Green);
        CheckBox yellowBox = (CheckBox) findViewById(R.id.Q1Yellow);
        hasAttemptedQ1 = true;

        if (redBox.isChecked() == true && blueBox.isChecked() == true
                && greenBox.isChecked() == false && yellowBox.isChecked() == true) {

            totalScore ++;
            hasCorrectlyAttemptedQ1 = true;
        }

        else if (redBox.isChecked() == false && blueBox.isChecked() == false
                && greenBox.isChecked() == false && yellowBox.isChecked() == false) {

            hasAttemptedQ1 = false;
            hasCorrectlyAttemptedQ1 = false;
        }

        else {
            hasCorrectlyAttemptedQ1 = false;
        }
    }

    /**
     * This method checks for all the variations in the answer for question 2.
     */
    public void addScoreQ2() {
        EditText answerField = (EditText) findViewById(R.id.Q2Answer);
        hasAttemptedQ2 = true;
        hasCorrectlyAttemptedQ2 = false;

        String correctAnswer2 = "camel";
        String yourAnswer2 = answerField.getText().toString().trim();

        if (yourAnswer2.matches("")) {
            hasAttemptedQ2 = false;
            return;
        }

        if ( yourAnswer2.toLowerCase().contains(correctAnswer2.toLowerCase()) ) {
            hasCorrectlyAttemptedQ2 = true;
            totalScore ++;
        }
    }

    /**
     * This method checks for all the variations in the answer for question 2.
     */
    public void addScoreQ3() {
        RadioButton dengueButton = (RadioButton) findViewById(R.id.Q3Dengue);
        RadioButton choleraButton = (RadioButton) findViewById(R.id.Q3Cholera);
        RadioButton malariaButton = (RadioButton) findViewById(R.id.Q3Malaria);
        RadioButton jaundiceButton = (RadioButton) findViewById(R.id.Q3Jaundice);
        hasAttemptedQ3 = true;

        if (dengueButton.isChecked() == false && choleraButton.isChecked() == false
                && malariaButton.isChecked() == true && jaundiceButton.isChecked() == false) {

            totalScore ++;
            hasCorrectlyAttemptedQ3 = true;
            return;
        }

        else if (dengueButton.isChecked() == false && choleraButton.isChecked() == false
                && malariaButton.isChecked() == false && jaundiceButton.isChecked() == false) {

            hasAttemptedQ3 = false;
            hasCorrectlyAttemptedQ3 = false;
        }

        else {
            hasCorrectlyAttemptedQ3 = false;
        }
    }

    /**
     * This method checks for all the variations in the answer for question 4.
     */
    public void addScoreQ4() {
        RadioButton tenButton = (RadioButton) findViewById(R.id.Q4Ten);
        RadioButton twelveButton = (RadioButton) findViewById(R.id.Q4Twelve);
        RadioButton fourteenButton = (RadioButton) findViewById(R.id.Q4Fourteen);
        RadioButton sixButton = (RadioButton) findViewById(R.id.Q4Six);
        hasAttemptedQ4 = true;

        if (tenButton.isChecked() == false && twelveButton.isChecked() == true
                && fourteenButton.isChecked() == false && sixButton.isChecked() == false) {

            totalScore ++;
            hasCorrectlyAttemptedQ4 = true;
            return;
        }

        else if (tenButton.isChecked() == false && twelveButton.isChecked() == false
                && fourteenButton.isChecked() == false && sixButton.isChecked() == false) {

            hasAttemptedQ4 = false;
            hasCorrectlyAttemptedQ4 = false;
        }

        else if (!twelveButton.isChecked()) {
            hasCorrectlyAttemptedQ4 = false;
        }
    }

    /**
     * This method checks for all the variations in the answer for question 5.
     */
    public void addScoreQ5() {
        CheckBox lexBox = (CheckBox) findViewById(R.id.Q5Lexicon);
        CheckBox gloBox = (CheckBox) findViewById(R.id.Q5Glossary);
        CheckBox encBox = (CheckBox) findViewById(R.id.Q5Encyclopedia);
        CheckBox wordBox = (CheckBox) findViewById(R.id.Q5Wordbook);
        hasAttemptedQ5 = true;

        if (lexBox.isChecked() == true && gloBox.isChecked()  == true
                && encBox.isChecked() == true && wordBox.isChecked() == true) {

            totalScore ++;
            hasCorrectlyAttemptedQ5 = true;
        }

        else if (lexBox.isChecked() == false && gloBox.isChecked() == false
                && encBox.isChecked() == false && wordBox.isChecked() == false) {

            hasAttemptedQ5 = false;
            hasCorrectlyAttemptedQ5 = false;
        }

        else {
            hasCorrectlyAttemptedQ5 = false;
        }
    }

    /**
     * This method checks for all the variations in the answer for question 6.
     */
    public void addScoreQ6() {
        RadioButton marsButton = (RadioButton) findViewById(R.id.Q6Mars);
        RadioButton saturnButton = (RadioButton) findViewById(R.id.Q6Saturn);
        RadioButton uranusButton = (RadioButton) findViewById(R.id.Q6Uranus);
        RadioButton neptuneButton = (RadioButton) findViewById(R.id.Q6Neptune);
        hasAttemptedQ6 = true;

        if (marsButton.isChecked() == false && saturnButton.isChecked() == false
                && uranusButton.isChecked() == true && neptuneButton.isChecked() == false) {

            totalScore ++;
            hasCorrectlyAttemptedQ6 = true;
            return;
        }

        else if (marsButton.isChecked() == false && saturnButton.isChecked() == false
                && uranusButton.isChecked() == false && neptuneButton.isChecked() == false) {

            hasAttemptedQ6 = false;
            hasCorrectlyAttemptedQ6 = false;
        }

        else {
            hasCorrectlyAttemptedQ6 = false;
        }
    }

    /**
     * This method checks for all the variations in the answer for question 7.
     */
    public void addScoreQ7() {
        RadioButton nileButton = (RadioButton) findViewById(R.id.Q7Nile);
        RadioButton amazonButton = (RadioButton) findViewById(R.id.Q7Amazon);
        RadioButton yellowriverButton = (RadioButton) findViewById(R.id.Q7YellowRiver);
        RadioButton mississippiButton = (RadioButton) findViewById(R.id.Q7Mississippi);
        hasAttemptedQ7 = true;

        if (nileButton.isChecked() == false && amazonButton.isChecked() == true
                && yellowriverButton.isChecked() == false && mississippiButton.isChecked() == false) {

            totalScore ++;
            hasCorrectlyAttemptedQ7 = true;
            return;
        }

        else if (nileButton.isChecked() == false && amazonButton.isChecked() == false
                && yellowriverButton.isChecked() == false && mississippiButton.isChecked() == false) {

            hasAttemptedQ7 = false;
            hasCorrectlyAttemptedQ7 = false;
        }

        else {
            hasCorrectlyAttemptedQ7 = false;
        }
    }

    /**
     * This method checks for all the variations in the answer for question 8.
     */
    public void addScoreQ8() {
        CheckBox whaleBox = (CheckBox) findViewById(R.id.Q8Whale);
        CheckBox elephantBox = (CheckBox) findViewById(R.id.Q8Elephant);
        CheckBox eagleBox = (CheckBox) findViewById(R.id.Q8Eagle);
        CheckBox ostrichBox = (CheckBox) findViewById(R.id.Q8Ostrich);
        hasAttemptedQ8 = true;

        if (whaleBox.isChecked() == true && elephantBox.isChecked() == true
                && eagleBox.isChecked() == false && ostrichBox.isChecked() == false) {

            totalScore ++;
            hasCorrectlyAttemptedQ8 = true;
        }

        else if (whaleBox.isChecked() == false && elephantBox.isChecked() == false
                && eagleBox.isChecked() == false && ostrichBox.isChecked() == false) {

            hasAttemptedQ8 = false;
            hasCorrectlyAttemptedQ8 = false;
        }

        else {
            hasCorrectlyAttemptedQ8 = false;
        }
    }

    /**
     * This method checks for all the variations in the answer for question 9.
     */
    public void addScoreQ9() {
        EditText answerField = (EditText) findViewById(R.id.Q9Answer);
        hasAttemptedQ9 = true;
        hasCorrectlyAttemptedQ9 = false;

        String correctAnswer9 = "london";
        String yourAnswer9 = answerField.getText().toString().trim();

        if (yourAnswer9.matches("")) {
            hasAttemptedQ9 = false;
            return;
        }

        if ( yourAnswer9.toLowerCase().contains(correctAnswer9.toLowerCase()) ) {
            hasCorrectlyAttemptedQ9 = true;
            totalScore ++;
        }

    }

    /**
     * This method generates the result report and returns it.
     * @return The final result report.
     */
    public String resultSummary(View view) {

        totalScore = 0;                 // Setting the value of totalScore to 0, each time the user presses the "SUBMIT" Button.
        String resultReport = "";       // Setting the initial value of the result report to be an empty string.

        // Calling addScoreQ1 to increment totalScore.
        addScoreQ1();
        /// Calling addScoreQ2 to increment totalScore.
        addScoreQ2();
        // Calling addScoreQ3 to increment totalScore.
        addScoreQ3();
        // Calling addScoreQ4 to increment totalScore.
        addScoreQ4();
        // Calling addScoreQ5 to increment totalScore.
        addScoreQ5();
        // Calling addScoreQ6 to increment totalScore.
        addScoreQ6();
        // Calling addScoreQ7 to increment totalScore.
        addScoreQ7();
        // Calling addScoreQ8 to increment totalScore.
        addScoreQ8();
        // Calling addScoreQ9 to increment totalScore.
        addScoreQ9();


        if (hasAttemptedQ1 && hasAttemptedQ2 && hasAttemptedQ3 && hasAttemptedQ4 && hasAttemptedQ5 && hasAttemptedQ6
                && hasAttemptedQ7 && hasAttemptedQ8 && hasAttemptedQ9) {

            if (hasCorrectlyAttemptedQ1 && hasCorrectlyAttemptedQ2 && hasCorrectlyAttemptedQ3 && hasCorrectlyAttemptedQ4 && hasCorrectlyAttemptedQ5
                    && hasCorrectlyAttemptedQ6 && hasCorrectlyAttemptedQ7 && hasCorrectlyAttemptedQ8 && hasCorrectlyAttemptedQ9) {

                totalScore ++;      // An extra point for attempting all questions correctly.
            }

            resultReport = getString(R.string.Q1Correct, hasCorrectlyAttemptedQ1);
            resultReport += "\n\n" + getString(R.string.Q2Attempted, hasCorrectlyAttemptedQ2);
            resultReport += "\n\n" + getString(R.string.Q3Correct, hasCorrectlyAttemptedQ3);
            resultReport += "\n\n" + getString(R.string.Q4Correct, hasCorrectlyAttemptedQ4);
            resultReport += "\n\n" + getString(R.string.Q5Correct, hasCorrectlyAttemptedQ5);
            resultReport += "\n\n" + getString(R.string.Q6Correct, hasCorrectlyAttemptedQ6);
            resultReport += "\n\n" + getString(R.string.Q7Correct, hasCorrectlyAttemptedQ7);
            resultReport += "\n\n" + getString(R.string.Q8Correct, hasCorrectlyAttemptedQ8);
            resultReport += "\n\n" + getString(R.string.Q9Attempted, hasCorrectlyAttemptedQ9);
        }

        return resultReport;
    }
}
