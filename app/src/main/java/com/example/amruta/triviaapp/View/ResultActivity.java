package com.example.amruta.triviaapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.amruta.triviaapp.Contoller.DbHelper;
import com.example.amruta.triviaapp.Model.Question;
import com.example.amruta.triviaapp.R;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    public static final String TAG = "ResultActivity";
    private TextView txtRNmae, txtRQuestion, txtRAns, txtR1Question, txtR1Ans, txtRSummery;
    private Button btnRNext;
    private List<Question> questionsList;
    private ArrayList<String> myAnsList;
    private Question currentQuestion;
    private DbHelper dbAdapter;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        getSupportActionBar().setTitle("Summary");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        getData();
        getQuestions();
        listner();
    }

    private void listner() {
        btnRNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(i);

            }
        });
    }

    private void getQuestions() {
        dbAdapter = new DbHelper(this);
        questionsList = dbAdapter.getAllQuestions();
        txtRNmae.setText("Hello  :" + name.toString());

        for (int i = 0; i < questionsList.size(); i++) {
            currentQuestion = questionsList.get(i);
            switch (i) {
                case 0:
                    txtRQuestion.setText(currentQuestion.getQUESTION().toString());
                    txtRAns.setText(myAnsList.get(i));
                    break;
                case 1:
                    txtR1Question.setText(currentQuestion.getQUESTION().toString());
                    txtR1Ans.setText(myAnsList.get(i));
                    break;
                default:
            }
        }
    }

    private void getData() {
        Bundle b1 = getIntent().getExtras();
        name = b1.getString("name");
        Log.d("RSULT_ACTIVITY", "Name----- : " + name);
        myAnsList = b1.getStringArrayList("myAnsList");
        Log.d("RESULT_ACTIVITY", "myAnsList_Size----- : " + myAnsList.size());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.activity_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                displayHitory();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void displayHitory() {
        Intent intent = new Intent(ResultActivity.this, HistoryListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("HNAME", name);
        bundle.putString("HQUES1", txtRQuestion.getText().toString());
        bundle.putString("HANS1", txtRAns.getText().toString());
        bundle.putString("HQUES2", txtR1Question.getText().toString());
        bundle.putString("HANS2", txtR1Ans.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);

    }

    private void init() {
        txtRNmae = (TextView) findViewById(R.id.txt_RName);
        txtRQuestion = (TextView) findViewById(R.id.txt_RowQue);
        txtRAns = (TextView) findViewById(R.id.txt_RAnswer);
        txtR1Question = (TextView) findViewById(R.id.txt_R1Que);
        txtR1Ans = (TextView) findViewById(R.id.txt_R1Answer);
        txtRSummery = (TextView) findViewById(R.id.txt_Rsummery);
        btnRNext = (Button) findViewById(R.id.btn_RFinish);
        myAnsList = new ArrayList<String>();
    }

}
