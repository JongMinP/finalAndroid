package com.example.kosta.beautymateandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kosta.beautymateandroid.domain.Reply;
import com.example.kosta.beautymateandroid.domain.Review;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class ReviewDetailActivity extends AppCompatActivity {
    private List<Reply> replys;
    private ReplyAdapter adapter;
    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_detail);

        Intent intent =getIntent();
        Review review = (Review)intent.getExtras().get("review");

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

        new ImageLoadingTask(img).execute(review.getCosmetic().getImg());

        list = (ListView)findViewById(R.id.replyList);

        adapter = new ReplyAdapter(this,review.getReplys());

        adapter.notifyDataSetChanged();

        list.setAdapter(adapter);

    }

    private class ImageLoadingTask extends AsyncTask<String, Void, Bitmap> {

        private final WeakReference<ImageView> imageViewWeakReference;

        public ImageLoadingTask(ImageView img) {
            this.imageViewWeakReference = new WeakReference<ImageView>(img);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            URL url = null;

            try {
                url = new URL(params[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return getRemoteImage(url);
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (isCancelled()) {
                bitmap = null;

            }

            if (imageViewWeakReference != null) {
                ImageView imageView = imageViewWeakReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }


    private Bitmap getRemoteImage(final URL url) {
        Bitmap bitmap = null;

        URLConnection conn;

        try {
            conn = url.openConnection();
            conn.connect();

            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            bitmap = BitmapFactory.decodeStream(bis);
            bis.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
