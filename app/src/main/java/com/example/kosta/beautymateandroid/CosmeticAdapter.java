package com.example.kosta.beautymateandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.example.kosta.beautymateandroid.domain.Cosmetic;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by kosta on 2017-06-12.
 */

public class CosmeticAdapter extends BaseAdapter {

    Context context;
    private List<Cosmetic> cosmetics;
    private LayoutInflater inflater;
    private Bitmap bitmap;

    public CosmeticAdapter(Context context, List<Cosmetic> cosmetics){
        this.context = context;
        this.cosmetics = cosmetics;
        this.inflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {

        return cosmetics.size();
    }

    @Override
    public Object getItem(int position) {
        return cosmetics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View item = convertView;
        Holder holder = null;




        if(item==null){
            item = inflater.inflate(R.layout.list_item, null);
            holder = new Holder();
            holder.brand = (TextView)item.findViewById(R.id.brand);
            holder.name = (TextView)item.findViewById(R.id.name);
            holder.img = (ImageView)item.findViewById(R.id.img);
            holder.ratingBar=(RatingBar)item.findViewById(R.id.rate);
            holder.rateVal=(TextView)item.findViewById(R.id.rateVal);

            item.setTag(holder);
        }else{
            holder = (Holder)item.getTag();
        }


        Thread mThread = new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL(cosmetics.get(position).getImg());

                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
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

            holder.brand.setText(cosmetics.get(position).getBrand());
            holder.name.setText(cosmetics.get(position).getCosmeticName());
            holder.img.setImageBitmap(bitmap);
            holder.ratingBar.setStepSize((float)0.5);
            holder.ratingBar.setRating((float)cosmetics.get(position).getAverageGrade());
            holder.ratingBar.setIsIndicator(true);
            holder.rateVal.setText(String.valueOf(cosmetics.get(position).getAverageGrade()));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return item;
    }

    private class Holder{
        TextView brand;
        TextView name;
        ImageView img;
        RatingBar ratingBar;
        TextView rateVal;
    }



}
