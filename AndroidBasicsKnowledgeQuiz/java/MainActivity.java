package com.example.android.androidbasicsknowledgequiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int total_score = 0;
    int question_num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * updates the quiz question respective to the @current_question
     */
    public void changeQuestion(int current_question) {
        TextView textview = findViewById(R.id.quiz_question_text_view);
        switch (current_question) {
            case 1:
                textview.setText(R.string.question1);
                break;
            case 2:
                textview.setText(R.string.question2);
                break;
            case 3:
                textview.setText(R.string.question3);
                break;
            case 4:
                textview.setText(R.string.question4);
                break;
            case 5:
                textview.setText(R.string.question5);
                break;
            case 6:
                textview.setText(R.string.question6);
                break;
            case 7:
                textview.setText(R.string.question7);
                break;
            case 8:
                textview.setText(R.string.question8);
                break;
            case 9:
                textview.setText(R.string.question9);
                break;
            case 10:
                textview.setText(R.string.question10);
                break;
            case 11:
                textview.setText("Your total score is\n");
                textview.setTextSize(48);
                showFinalResult();
        }
    }

    /**
     * shows all the radio buttons
     */
    public void showRadioButtons() {
        RadioButton radiobutton = findViewById(R.id.radioButton_1);
        radiobutton.setVisibility(radiobutton.VISIBLE);
        radiobutton = findViewById(R.id.radioButton_2);
        radiobutton.setVisibility(radiobutton.VISIBLE);
        radiobutton = findViewById(R.id.radioButton_3);
        radiobutton.setVisibility(radiobutton.VISIBLE);
        radiobutton = findViewById(R.id.radioButton_4);
        radiobutton.setVisibility(radiobutton.VISIBLE);
        radiobutton = findViewById(R.id.radioButton_5);
        radiobutton.setVisibility(radiobutton.VISIBLE);
    }

    /**
     * hides all the radio buttons
     */
    public void hideRadioButtons() {
        RadioButton radiobutton = findViewById(R.id.radioButton_1);
        radiobutton.setVisibility(radiobutton.INVISIBLE);
        radiobutton = findViewById(R.id.radioButton_2);
        radiobutton.setVisibility(radiobutton.INVISIBLE);
        radiobutton = findViewById(R.id.radioButton_3);
        radiobutton.setVisibility(radiobutton.INVISIBLE);
        radiobutton = findViewById(R.id.radioButton_4);
        radiobutton.setVisibility(radiobutton.INVISIBLE);
        radiobutton = findViewById(R.id.radioButton_5);
        radiobutton.setVisibility(radiobutton.INVISIBLE);
    }

    /**
     * shows all the check boxes
     */
    public void showCheckBoxes() {
        CheckBox checkbox = findViewById(R.id.checkbox1);
        checkbox.setVisibility(checkbox.VISIBLE);
        checkbox = findViewById(R.id.checkbox2);
        checkbox.setVisibility(checkbox.VISIBLE);
        checkbox = findViewById(R.id.checkbox3);
        checkbox.setVisibility(checkbox.VISIBLE);
        checkbox = findViewById(R.id.checkbox4);
        checkbox.setVisibility(checkbox.VISIBLE);
        checkbox = findViewById(R.id.checkbox5);
        checkbox.setVisibility(checkbox.VISIBLE);
    }

    /**
     * hide all the check boxes
     */
    public void hideCheckBoxes() {
        CheckBox checkbox = findViewById(R.id.checkbox1);
        checkbox.setVisibility(checkbox.INVISIBLE);
        checkbox = findViewById(R.id.checkbox2);
        checkbox.setVisibility(checkbox.INVISIBLE);
        checkbox = findViewById(R.id.checkbox3);
        checkbox.setVisibility(checkbox.INVISIBLE);
        checkbox = findViewById(R.id.checkbox4);
        checkbox.setVisibility(checkbox.INVISIBLE);
        checkbox = findViewById(R.id.checkbox5);
        checkbox.setVisibility(checkbox.INVISIBLE);
    }
    /**
     * changes the text of the Ready Button (a.k.a Submit Button)
     */
    public void changeButtonText() {
        Button button = findViewById(R.id.start_button);
        if (question_num >= 0 && question_num <= 10)
            button.setText("Submit");
        else if (question_num >= 11)
            button.setText("Reset");
    }
    /**
     * resets everything after user has finished quiz
     */
    public void resetAll() {
        TextView textview = findViewById(R.id.quiz_question_text_view);
        LinearLayout changeBackground = findViewById(R.id.final_background);
        changeBackground.setBackgroundColor(0);
        textview.setTextSize(32);
        total_score = 0;
        question_num = 0;
    }
    /**
     * changes the text of the Ready Button (a.k.a. Submit Button)
     */
    public void buttonClick(View view) {
        ImageView imageview = findViewById(R.id.android_bg_image_view);
        imageview.setImageResource(0);
        changeButtonText();
        if (question_num > 10)
            resetAll();

        checkAnswer(question_num);
        question_num += 1;
        /* testing purposes only*/
        final String TAG = "MyActivity";
        Log.v(TAG, "Q = " + question_num + " Tot = " + total_score);
        /* */
        changeQuestion(question_num);
        change_answers(question_num);
    }
    /**
     * checks the respective answers of the user of the respective @param current_question
     * if correct, adds a point to total_score
     */
    public void checkAnswer(int current_question) {
        CheckBox checkBox1 = findViewById(R.id.checkbox1);
        CheckBox checkBox2 = findViewById(R.id.checkbox2);
        CheckBox checkBox3 = findViewById(R.id.checkbox3);
        CheckBox checkBox4 = findViewById(R.id.checkbox4);
        CheckBox checkBox5 = findViewById(R.id.checkbox5);
        RadioButton radioButton1 = findViewById(R.id.radioButton_1);
        RadioButton radioButton2 = findViewById(R.id.radioButton_2);
        RadioButton radioButton3 = findViewById(R.id.radioButton_3);
        RadioButton radioButton4 = findViewById(R.id.radioButton_4);
        RadioButton radioButton5 = findViewById(R.id.radioButton_5);
        /* testing purposes only*/
        final String TAG = "MyActivity";
        Log.v(TAG, "cb1 = " + checkBox1.isChecked() + " cb2 = "
                + checkBox2.isChecked() + " cb3 = "
                + checkBox3.isChecked() + " cb4 = "
                + checkBox4.isChecked() + " cb5 = " + checkBox5.isChecked()  );
        /* */
        switch(current_question) {
            case 1:
                Log.v(TAG, "test1");
                if (checkBox2.isChecked() && checkBox4.isChecked()) {
                    total_score += 1;
                    Log.v(TAG, "case1");
                }
                break;
            case 2:
                if (checkBox1.isChecked()
                        && checkBox2.isChecked()
                        && checkBox3.isChecked()
                        && checkBox4.isChecked()
                        && checkBox5.isChecked()) {
                    total_score += 1;
                }
                break;
            case 3:
                if (radioButton5.isChecked()) {
                    total_score += 1;
                }
                break;
            case 4:
                if (radioButton1.isChecked()) {
                    total_score += 1;
                }
                break;
            case 5:
                if (checkBox4.isChecked()
                        && checkBox5.isChecked()) {
                    total_score += 1;
                }
                break;
            case 6:
                if (checkBox1.isChecked()
                        && checkBox2.isChecked()
                        && checkBox4.isChecked()
                        && checkBox5.isChecked()) {
                    total_score += 1;
                }
                break;
            case 7:
                if (checkBox3.isChecked()
                        && checkBox5.isChecked()) {
                    total_score += 1;
                }
                break;
            case 8:
                if (radioButton2.isChecked()) {
                    total_score += 1;
                }
                break;
            case 9:
                if (checkBox4.isChecked()
                        && checkBox5.isChecked()) {
                    total_score += 1;
                }
                break;
            case 10:
                if (checkBox1.isChecked()
                        && checkBox2.isChecked()
                        && checkBox3.isChecked()
                        && checkBox4.isChecked()
                        && checkBox5.isChecked()) {
                    total_score += 1;
                }
                break;
        }
        Log.v(TAG, "total iz = " + total_score);
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);
        checkBox5.setChecked(false);
        radioButton1.setChecked(false);
        radioButton2.setChecked(false);
        radioButton3.setChecked(false);
        radioButton4.setChecked(false);
        radioButton5.setChecked(false);

    }
    /**
     * depending on which respective @param question_num,
     * respective text is changed on the possible answers
     */
    public void change_answers(int current_question) {
        switch (current_question) {
            case 1:
            case 2:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
                checkBoxAnswers(current_question);
                hideRadioButtons();
                showCheckBoxes();
                break;
            case 3:
            case 4:
            case 8:
                radioButtonAnswers(current_question);
                hideCheckBoxes();
                showRadioButtons();
                break;
            case 11:
                showFinalResult();
                break;
        }
    }

    /**
     * @param current_question is the current question
     *                         changes the shown answers depending on the respective current_question
     */
    public void radioButtonAnswers(int current_question) {
        RadioButton radioButton1 = findViewById(R.id.radioButton_1);
        RadioButton radioButton2 = findViewById(R.id.radioButton_2);
        RadioButton radioButton3 = findViewById(R.id.radioButton_3);
        RadioButton radioButton4 = findViewById(R.id.radioButton_4);
        RadioButton radioButton5 = findViewById(R.id.radioButton_5);
        switch (current_question) {
            case 3:
                radioButton1.setText(getString(R.string.q3_1));
                radioButton2.setText(getString(R.string.q3_2));
                radioButton3.setText(getString(R.string.q3_3));
                radioButton4.setText(getString(R.string.q3_4));
                radioButton5.setText(getString(R.string.q3_5));
                break;
            case 4:
                radioButton1.setText(getString(R.string.q4_1));
                radioButton2.setText(getString(R.string.q4_2));
                radioButton3.setText(getString(R.string.q4_3));
                radioButton4.setText(getString(R.string.q4_4));
                radioButton5.setText(getString(R.string.q4_5));
                break;
            case 8:
                radioButton1.setText(getString(R.string.q8_1));
                radioButton2.setText(getString(R.string.q8_2));
                radioButton3.setText(getString(R.string.q8_3));
                radioButton4.setText(getString(R.string.q8_4));
                radioButton5.setText(getString(R.string.q8_5));
                break;
        }
    }

    /**
     * @param current_question is the current question
     *                         changes the shown answers depending on the respective current_question
     */
    public void checkBoxAnswers(int current_question) {
        CheckBox checkBox1 = findViewById(R.id.checkbox1);
        CheckBox checkBox2 = findViewById(R.id.checkbox2);
        CheckBox checkBox3 = findViewById(R.id.checkbox3);
        CheckBox checkBox4 = findViewById(R.id.checkbox4);
        CheckBox checkBox5 = findViewById(R.id.checkbox5);
        switch (current_question) {
            case 1:
                checkBox1.setText(getString(R.string.q1_1));
                checkBox2.setText(getString(R.string.q1_2));
                checkBox3.setText(getString(R.string.q1_3));
                checkBox4.setText(getString(R.string.q1_4));
                checkBox5.setText(getString(R.string.q1_5));
                break;
            case 2:
                checkBox1.setText(getString(R.string.q2_1));
                checkBox2.setText(getString(R.string.q2_2));
                checkBox3.setText(getString(R.string.q2_3));
                checkBox4.setText(getString(R.string.q2_4));
                checkBox5.setText(getString(R.string.q2_5));
                break;
            case 5:
                checkBox1.setText(getString(R.string.q5_1));
                checkBox2.setText(getString(R.string.q5_2));
                checkBox3.setText(getString(R.string.q5_3));
                checkBox4.setText(getString(R.string.q5_4));
                checkBox5.setText(getString(R.string.q5_5));
                break;
            case 6:
                checkBox1.setText(getString(R.string.q6_1));
                checkBox2.setText(getString(R.string.q6_2));
                checkBox3.setText(getString(R.string.q6_3));
                checkBox4.setText(getString(R.string.q6_4));
                checkBox5.setText(getString(R.string.q6_5));
                break;
            case 7:
                checkBox1.setText(getString(R.string.q7_1));
                checkBox2.setText(getString(R.string.q7_2));
                checkBox3.setText(getString(R.string.q7_3));
                checkBox4.setText(getString(R.string.q7_4));
                checkBox5.setText(getString(R.string.q7_5));
                break;
            case 9:
                checkBox1.setText(getString(R.string.q9_1));
                checkBox2.setText(getString(R.string.q9_2));
                checkBox3.setText(getString(R.string.q9_3));
                checkBox4.setText(getString(R.string.q9_4));
                checkBox5.setText(getString(R.string.q9_5));
                break;
            case 10:
                checkBox1.setText(getString(R.string.q10_1));
                checkBox2.setText(getString(R.string.q10_2));
                checkBox3.setText(getString(R.string.q10_3));
                checkBox4.setText(getString(R.string.q10_4));
                checkBox5.setText(getString(R.string.q10_5));
                break;
        }
    }
    /**
     * changes the background of the center linear layout depending on the respective total_score
     */
    public void changeBackground() {
        LinearLayout changeBackground = findViewById(R.id.final_background);
        switch (total_score) {
            case 0:
                changeBackground.setBackgroundResource(R.drawable.zero);
                break;
            case 1:
                changeBackground.setBackgroundResource(R.drawable.one);
                break;
            case 2:
                changeBackground.setBackgroundResource(R.drawable.two);
                break;
            case 3:
                changeBackground.setBackgroundResource(R.drawable.three);
                break;
            case 4:
                changeBackground.setBackgroundResource(R.drawable.four);
                break;
            case 5:
                changeBackground.setBackgroundResource(R.drawable.five);
                break;
            case 6:
                changeBackground.setBackgroundResource(R.drawable.six);
                break;
            case 7:
                changeBackground.setBackgroundResource(R.drawable.seven);
                break;
            case 8:
                changeBackground.setBackgroundResource(R.drawable.eight);
                break;
            case 9:
                changeBackground.setBackgroundResource(R.drawable.nine);
                break;
            case 10:
                changeBackground.setBackgroundResource(R.drawable.ten);
                break;
        }
    }
    /**
     * shows the final result of the quiz to user via Toast
     */
    public void showFinalResult() {
        hideRadioButtons();
        hideCheckBoxes();
        changeBackground();
        if (total_score == 10) {
            setToast(getString(R.string.toast_win));
        } else {
            setToast(getString(R.string.toast_lose));
        }
        changeButtonText();
    }

    public void setToast(String result_message) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, result_message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
