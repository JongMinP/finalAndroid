package com.example.kosta.beautymateandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kosta.beautymateandroid.domain.Reply;
import com.example.kosta.beautymateandroid.domain.Review;
import com.example.kosta.beautymateandroid.service.ReviewService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewDetailActivity extends AppCompatActivity {
    private static final int REQUEST_MODIFY=1;
    private List<Reply> replys;
    private ReplyAdapter adapter;
    private ListView list;
    private Review review;

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_detail);

        Intent intent =getIntent();
        review = (Review)intent.getExtras().get("review");

        ((TextView)findViewById(R.id.dBrand)).setText(review.getCosmetic().getBrand());
        ((TextView)findViewById(R.id.dContentText)).setText(review.getReviewContent());
        ((TextView)findViewById(R.id.dTitleText)).setText(review.getReviewTitle());

        ((TextView)findViewById(R.id.dCost)).setText(Integer.toString(review.getCosmetic().getCost()));
        ((TextView)findViewById(R.id.dVolume)).setText(review.getCosmetic().getVolume());
        ((TextView)findViewById(R.id.dName)).setText(review.getCosmetic().getCosmeticName());
        if(review.getRecommend() !=null) {
            ((TextView) findViewById(R.id.dGrade)).setText(Integer.toString(review.getRecommend().getGrade()));
        }else {
            ((TextView) findViewById(R.id.dGrade)).setText("");
        }

        ImageView img = (ImageView)findViewById(R.id.dImage);

        Glide.with(this).load(review.getCosmetic().getImg()).override(400,400).into(img);


        if(review.getImage()!=null && !review.getImage().equals("")){

            LinearLayout layout = (LinearLayout)findViewById(R.id.detailLinear);

            String immg = review.getImage();
            String [] imgs = immg.split(",");
            Log.d("size",Integer.toString(imgs.length));
            ImageView [] ivs = new ImageView[imgs.length];
            for(int i=0; i<imgs.length; i ++){
                ImageView iv = new ImageView (this);
                ivs[i] = iv;
            }
            for(int i=0; i<imgs.length; i++){
                layout.addView(ivs[i]);
                String front = imgs[i].substring(0,12);
                String end = imgs[i].substring(14);
                Glide.with(this).load("http://10.0.2.2:8080/BeautyMate/displayFile?fileName="+front + end).override(400,400).into(ivs[i]);

            }

        }


        list = (ListView)findViewById(R.id.replyList);

        adapter = new ReplyAdapter(this,review.getReplys());

        adapter.notifyDataSetChanged();

        list.setAdapter(adapter);


        Button deleteBtn = (Button)findViewById(R.id.deleteBtn);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RestClient<ReviewService> client;
                ReviewService rservice;

                client = new RestClient<>();
                rservice = client.getClient(ReviewService.class);

                Log.d("asdsa",Integer.toString(review.getReviewNo()));

                Call<Integer> call = rservice.reviewRemove(review.getReviewNo());

                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        Log.d("aa","ee");
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Log.d("tt", "망");
                    }
                });

                finish();
            }
        });


        Button modifyBtn = (Button)findViewById(R.id.modifyBtn);

        modifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewDetailActivity.this,ReviewModifyActivity.class);
                intent.putExtra("review",review);
                startActivityForResult(intent,REQUEST_MODIFY);

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){

            Review re = (Review) data.getExtras().get("review");

            if(requestCode == REQUEST_MODIFY){
                ((TextView)findViewById(R.id.dContentText)).setText(re.getReviewContent());
                ((TextView)findViewById(R.id.dTitleText)).setText(re.getReviewTitle());
                ((TextView) findViewById(R.id.dGrade)).setText(Integer.toString(re.getRecommend().getGrade()));
            }

        }


    }
}
