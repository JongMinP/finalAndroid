package com.example.kosta.beautymateandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kosta.beautymateandroid.domain.Review;
import com.example.kosta.beautymateandroid.service.ReviewService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewModifyActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_modify);

        intent = getIntent();
        final Review review = (Review)intent.getExtras().get("review");

        ((EditText)findViewById(R.id.eMTitle)).setText(review.getReviewTitle());
        ((EditText)findViewById(R.id.eMContent)).setText(review.getReviewContent());
        ((EditText)findViewById(R.id.eMGrade)).setText(Integer.toString(review.getRecommend().getGrade()));


        Button modifyBtn = (Button)findViewById(R.id.modiBtn);

        modifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RestClient<ReviewService> client;
                ReviewService rservice;

                client = new RestClient<ReviewService>();
                rservice = client.getClient(ReviewService.class);

                review.setReviewTitle(((EditText)findViewById(R.id.eMTitle)).getText().toString());
                review.setReviewContent(((EditText)findViewById(R.id.eMContent)).getText().toString());
                review.getRecommend().setGrade(Integer.parseInt(((EditText)findViewById(R.id.eMGrade)).getText().toString()));

                Call<Void> call = rservice.reviewModify(review);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.d("aa","ee");
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d("tt", "망");
                    }
                });

                intent.putExtra("review",review);

                setResult(RESULT_OK,intent);

                finish();


            }
        });

    }
}
