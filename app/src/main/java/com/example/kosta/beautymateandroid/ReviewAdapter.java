package com.example.kosta.beautymateandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kosta.beautymateandroid.domain.Review;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by kosta on 2017-06-14.
 */

public class ReviewAdapter extends BaseAdapter{
    private List<Review> data;
    private Context context;
    private LayoutInflater inflater;

    public ReviewAdapter(Context context, List<Review> data){
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView ==null){
            convertView =inflater.inflate(R.layout.rlist_item,null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.cosmeticName);
        TextView title = (TextView) convertView.findViewById(R.id.titleText);
        TextView content = (TextView) convertView.findViewById(R.id.contentText);
        TextView volume = (TextView) convertView.findViewById(R.id.volume);
        TextView cost = (TextView) convertView.findViewById(R.id.cost);
        TextView brand = (TextView) convertView.findViewById(R.id.brand);
        TextView grade = (TextView) convertView.findViewById(R.id.grade);

        name.setText(data.get(position).getCosmetic().getCosmeticName());
        title.setText(data.get(position).getReviewTitle());
        content.setText(data.get(position).getReviewContent());
//
        volume.setText(data.get(position).getCosmetic().getVolume());
        cost.setText(Integer.toString(data.get(position).getCosmetic().getCost()));
        brand.setText(data.get(position).getCosmetic().getBrand());

        if(data.get(position).getRecommend()!=null) {
            grade.setText(Integer.toString(data.get(position).getRecommend().getGrade()));
        }else {
            grade.setText("");
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.image);

        new ImageLoadingTask(image).execute(data.get(position).getCosmetic().getImg());


        // 이미지

        return convertView;


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
