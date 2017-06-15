package com.example.kosta.beautymateandroid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kosta.beautymateandroid.domain.Review;

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

//        new ImageLoadingTask(image).execute(data.get(position).getCosmetic().getImg());

        Glide.with(context).load(data.get(position).getCosmetic().getImg()).override(300,300).into(image);

        if(data.get(position).getImage() !=null && !data.get(position).getImage().equals("")){

            LinearLayout layout = (LinearLayout)convertView.findViewById(R.id.reviewLinaer);

            String img = data.get(position).getImage();
            String [] imgs = img.split(",");
            Log.d("size",Integer.toString(imgs.length));
            ImageView [] ivs = new ImageView[imgs.length];


            for(int i=0; i<imgs.length; i ++){
                ImageView iv = new ImageView (context);
                ivs[i] = iv;
            }
            for(int i=0; i<imgs.length; i++){
                layout.addView(ivs[i]);
                Glide.with(context).load("http://10.0.2.2:8080/BeautyMate/displayFile?fileName="+imgs[i]).override(200,200).into(ivs[i]);

            }

        }


        // 이미지

        return convertView;


    }

}
