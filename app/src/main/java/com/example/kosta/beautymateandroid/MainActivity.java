package com.example.kosta.beautymateandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kosta.beautymateandroid.survey.SurveyActivity;
import com.example.kosta.beautymateandroid.survey.SurveyMainActivity;

public class MainActivity extends AppCompatActivity {
    private Button goSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.goSurvey).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SurveyMainActivity.class);
                startActivity(intent);
            }
        });

    }
}
