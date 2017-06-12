package com.example.kosta.beautymateandroid.survey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kosta.beautymateandroid.R;

public class SurveyMainActivity extends AppCompatActivity {

    private Button btn_toSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_main);

        findViewById(R.id.btn_toSurvey).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SurveyMainActivity.this, SurveyActivity.class);
                startActivity(intent);
            }
        });
    }
}
