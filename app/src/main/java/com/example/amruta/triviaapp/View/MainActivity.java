package com.example.amruta.triviaapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amruta.triviaapp.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private TextView txtName;
    private EditText eTxtName;
    private Button btnNext;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Login");
        init();
        listeneres();
    }

    private void listeneres() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = eTxtName.getText().toString();
                Log.d(TAG, "main_name:----" + name);
                if (name.trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter the name first", Toast.LENGTH_SHORT).show();
                } else {
                    sendData();
                }

            }
        });
    }

    //send data to Quiz activity
    private void sendData() {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("NAME", name);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //initialise view
    private void init() {
        txtName = (TextView) findViewById(R.id.textView);
        eTxtName = (EditText) findViewById(R.id.editName);
        btnNext = (Button) findViewById(R.id.buttonNext);
    }
}


