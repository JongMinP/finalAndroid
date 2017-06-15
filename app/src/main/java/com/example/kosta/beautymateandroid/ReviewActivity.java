package com.example.kosta.beautymateandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.kosta.beautymateandroid.domain.Review;
import com.example.kosta.beautymateandroid.service.ReviewService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewActivity extends AppCompatActivity {
    private List<Review> data;
    private ReviewAdapter adapter;
    private ListView list;


    @Override
    protected void onResume() {
        super.onResume();
        list = (ListView) findViewById(R.id.reviewList);


        RestClient<ReviewService> client;
        ReviewService rservice;

        client = new RestClient<ReviewService>();
        rservice = client.getClient(ReviewService.class);

        try {
            final Call<List<Review>> reviews = rservice.listReview();

            Log.d("test", "start");

            reviews.enqueue(new Callback<List<Review>>() {
                @Override
                public void onResponse(Call<List<Review>> call, Response<List<Review>> response) {
                    int statusCode = response.code();
                    data = response.body();

                    Log.d("r", data.size() + "개");

                    for (Review r : data) {
                        Log.d("tt", r.toString());
                    }

                    adapter = new ReviewAdapter(getApplicationContext(), data);

                    adapter.notifyDataSetChanged();

                    list.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<List<Review>> call, Throwable t) {
                    Log.d("test", "실패");
                }
            });

        } catch (Exception e) {
            Log.d("test", e.getMessage());
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Review review = data.get(position);
                Intent intent = new Intent(ReviewActivity.this,ReviewDetailActivity.class);
                intent.putExtra("review",review);
                startActivity(intent);

            }
        });


        Button rBtn = (Button) findViewById(R.id.rBtn);

        rBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewActivity.this,ReviewRegisterActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
//
//        list = (ListView) findViewById(R.id.reviewList);
//
//
//        RestClient<ReviewService> client;
//        ReviewService rservice;
//
//        client = new RestClient<ReviewService>();
//        rservice = client.getClient(ReviewService.class);
//
//        try {
//            final Call<List<Review>> reviews = rservice.listReview();
//
//            Log.d("test", "start");
//
//            reviews.enqueue(new Callback<List<Review>>() {
//                @Override
//                public void onResponse(Call<List<Review>> call, Response<List<Review>> response) {
//                    int statusCode = response.code();
//                    data = response.body();
//
//                    Log.d("r", data.size() + "개");
//
//                    for (Review r : data) {
//                        Log.d("tt", r.toString());
//                    }
//
//                    adapter = new ReviewAdapter(getApplicationContext(), data);
//
//                    adapter.notifyDataSetChanged();
//
//                    list.setAdapter(adapter);
//
//                }
//
//                @Override
//                public void onFailure(Call<List<Review>> call, Throwable t) {
//                    Log.d("test", "실패");
//                }
//            });
//
//        } catch (Exception e) {
//            Log.d("test", e.getMessage());
//        }
//
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Review review = data.get(position);
//                Intent intent = new Intent(ReviewActivity.this,ReviewDetailActivity.class);
//                intent.putExtra("review",review);
//                startActivity(intent);
//
//            }
//        });
//
//
//        Button rBtn = (Button) findViewById(R.id.rBtn);
//
//        rBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ReviewActivity.this,ReviewRegisterActivity.class);
//                startActivity(intent);
//            }
//        });


    }
}
