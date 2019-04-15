package com.example.amruta.triviaapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.amruta.triviaapp.Contoller.DbHelper;
import com.example.amruta.triviaapp.Model.Question;
import com.example.amruta.triviaapp.R;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    public static final String TAG = "QuizActivity";
    private RadioButton rda, rdb, rdc, rdd;
    private RadioGroup grp;
    private Button butNext;
    private TextView txtQuestion, txtOption;
    private List<Question> quesList;
    private Question currentQuestion;
    ArrayList<String> myAnsList;

    private int questionId = 0;
    private int answeredQsNo = 0;
    private String name;

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().setTitle("Quiz");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
        getName();
        getQuestionList();
        listener();
    }

    //add listener
    private void listener() {
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grp = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioButton answer = findViewById(grp.getCheckedRadioButtonId());

                Log.e(TAG, "Selected Positioned  value - " + grp.getCheckedRadioButtonId());
                if (answer != null) {
                    Log.e(TAG, currentQuestion.getANSWER() + " -- " + answer.getText());
                    //Add answer to the list
                    myAnsList.add("" + answer.getText());

                    if (questionId < db.rowCount()) {
                        //get current que id
                        currentQuestion = quesList.get(questionId);
                        setQuestionView();
                    } else {
                        //send data to result activity
                        Intent intent1 = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle b1 = new Bundle();
                        b1.putInt("totalQs", quesList.size());
                        b1.putString("name", name.toString());
                        b1.putStringArrayList("myAnsList", myAnsList);
                        intent1.putExtras(b1);
                        startActivity(intent1);
                        finish();
                    }
                } else {
                    Log.e(TAG, "No Answer");
                }
                //Need to clear the checked item id
                grp.clearCheck();

            }
        });
    }

    //get question list
    private void getQuestionList() {
        quesList = db.getAllQuestions();
        currentQuestion = quesList.get(questionId);
        Log.d(TAG, "Question List------" + quesList.size());
        setQuestionView();
    }

    //get name from main activity
    private void getName() {
        Bundle b = getIntent().getExtras();
        name = b.getString("NAME");
        Log.d(TAG, "Name In Quiz activity------- : " + name);
    }

    //Initialize view
    private void init() {
        txtQuestion = (TextView) findViewById(R.id.textView1);
        txtOption = (TextView) findViewById(R.id.textView2);
        rda = (RadioButton) findViewById(R.id.radio0);
        rdb = (RadioButton) findViewById(R.id.radio1);
        rdc = (RadioButton) findViewById(R.id.radio2);
        rdd = (RadioButton) findViewById(R.id.radio3);
        butNext = (Button) findViewById(R.id.button1);
        myAnsList = new ArrayList<String>();
        db = new DbHelper(this);
    }

    //set question on the textview
    private void setQuestionView() {
        rda.setChecked(false);
        rdb.setChecked(false);
        rdc.setChecked(false);
        rdd.setChecked(false);
        answeredQsNo = questionId + 1;
        txtQuestion.setText(currentQuestion.getQUESTION());
        rda.setText(currentQuestion.getOPTA());
        rdb.setText(currentQuestion.getOPTB());
        rdc.setText(currentQuestion.getOPTC());
        rdd.setText(currentQuestion.getOPTD());
        questionId++;
    }


}
