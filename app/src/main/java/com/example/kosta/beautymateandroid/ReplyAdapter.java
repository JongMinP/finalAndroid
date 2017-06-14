package com.example.kosta.beautymateandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kosta.beautymateandroid.domain.Reply;

import java.util.List;

/**
 * Created by kosta on 2017-06-14.
 */

public class ReplyAdapter extends BaseAdapter {
    private List<Reply> replys;
    private Context context;
    private LayoutInflater inflater;

    public ReplyAdapter(Context context, List<Reply> replys) {
        this.context = context;
        this.replys = replys;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return replys.size();
    }

    @Override
    public Object getItem(int position) {
        return replys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = inflater.inflate(R.layout.reply_item,null);
        }

        TextView title = (TextView) convertView.findViewById(R.id.rTitle);
        TextView content = (TextView) convertView.findViewById(R.id.rContent);

        content.setText(replys.get(position).getReplyContent());


        return convertView;
    }
}
