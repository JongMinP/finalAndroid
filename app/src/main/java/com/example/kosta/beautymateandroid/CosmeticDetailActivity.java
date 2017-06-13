package com.example.kosta.beautymateandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.kosta.beautymateandroid.domain.Cosmetic;
import com.example.kosta.beautymateandroid.service.CosmeticService;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CosmeticDetailActivity extends AppCompatActivity {
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmetic_detail);

        Intent intent = getIntent();

        int cosmeticNo = Integer.parseInt(intent.getExtras().get("cosmeticNo").toString());

//        RESTful 라이브러리 Setting
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8888/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final CosmeticService service = retrofit.create(CosmeticService.class);

        try {
            final Call<Cosmetic> detail = (Call<Cosmetic>) service.detail(cosmeticNo);

            Log.d("test", "start");

            detail.enqueue(new Callback<Cosmetic>() {
                @Override
                public void onResponse(Call<Cosmetic> call, Response<Cosmetic> response) {
                    int statusCode = response.code();
                    final Cosmetic cosDetail = response.body();
                    Log.d("test", cosDetail.getCosmeticName() + "^^");
                    ImageView img = (ImageView) findViewById(R.id.cosImg);
                    TextView brand = (TextView) findViewById(R.id.cosBrand);
                    TextView name = (TextView) findViewById(R.id.cosName);
                    RatingBar rate = (RatingBar) findViewById(R.id.cosRate);
                    TextView vol = (TextView) findViewById(R.id.cosVol);
                    TextView cost = (TextView) findViewById(R.id.cosCost);

//                    이미지 받아오기 위한 Thread
                    Thread mThread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                URL url = new URL(cosDetail.getImg());

                                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                conn.setDoInput(true);
                                conn.connect();

                                InputStream is = conn.getInputStream();
                                bitmap = BitmapFactory.decodeStream(is);
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    mThread.start();

                    try {
                        mThread.join();

                        img.setImageBitmap(bitmap);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    디테일 정보 setting
                    brand.setText(cosDetail.getBrand());
                    name.setText(cosDetail.getCosmeticName());
                    cost.setText(String.valueOf(cosDetail.getCost()));
                    vol.setText(cosDetail.getVolume());
                    rate.setStepSize((float) 0.5);
                    rate.setRating((float) cosDetail.getAverageGrade());
                    rate.setIsIndicator(true);

//                    가격정보 버튼 이벤트
                    Button reqCost = (Button)findViewById(R.id.reqCost);
                    reqCost.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.shopping.naver.com/search/all.nhn?query="+cosDetail.getCosmeticName()+"&cat_id=&frm=NVSHATC"));
                            startActivity(intent);
                        }
                    });

//                    마이파우치 버튼 이벤트
                    Button reqPouch = (Button)findViewById(R.id.reqPouch);
                    reqPouch.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {




                        }
                    });

                }


                @Override
                public void onFailure(Call<Cosmetic> call, Throwable t) {
                    Log.d("test", "실패");
                }
            });




        } catch (Exception e) {
            Log.d("test", e.getMessage());

        }
    }


}
