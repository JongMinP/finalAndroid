package com.example.kosta.beautymateandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kosta.beautymateandroid.domain.Cosmetic;
import com.example.kosta.beautymateandroid.domain.Customer;
import com.example.kosta.beautymateandroid.domain.Recommend;
import com.example.kosta.beautymateandroid.domain.Review;
import com.example.kosta.beautymateandroid.service.ReviewService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_register);


        Button rBtn = (Button) findViewById(R.id.regiBtn);

        rBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RestClient<ReviewService> client;
                ReviewService rservice;

                client = new RestClient<ReviewService>();
                rservice = client.getClient(ReviewService.class);

                Review review = new Review();

                review.setReviewTitle(((EditText)findViewById(R.id.eRTitle)).getText().toString());
                review.setReviewContent(((EditText)findViewById(R.id.eRContent)).getText().toString());
                review.setImage(""); // 일단
                Customer c = new Customer();
                c.setCustomerNo(1); // 세션에서?

                Cosmetic co = new Cosmetic();
                co.setCosmeticNo(Integer.parseInt(((EditText)findViewById(R.id.eRCosmetic)).getText().toString()));
                Recommend recommend = new Recommend();
                recommend.setCustomerNo(1); // 세션?
                recommend.setCosmeticNo(Integer.parseInt(((EditText)findViewById(R.id.eRCosmetic)).getText().toString()));

                String grade = ((EditText)findViewById(R.id.rGrade)).getText().toString();
                recommend.setGrade(grade==null ? 0 : Integer.parseInt(grade) ); // 평가점수

                review.setCustomer(c);
                review.setCosmetic(co);
                review.setRecommend(recommend);

                Call<Review> call = rservice.reviewRegister(review);

                call.enqueue(new Callback<Review>() {
                    @Override
                    public void onResponse(Call<Review> call, Response<Review> response) {

                        Log.d("aa","ee");

                    }

                    @Override
                    public void onFailure(Call<Review> call, Throwable t) {
                        Log.d("tt", "망");
                    }
                });
                finish();
            }
        });
    }
}
