package com.example.kosta.beautymateandroid.survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kosta.beautymateandroid.R;

public class Pt1Qu1FragmentChild extends Fragment {
    Button pt1qu1_op1;
    Button pt1qu1_op2;
    Button pt1qu1_op3;
    Button pt1qu1_op4;
    public static Pt1Qu1FragmentChild newInstance(){
        return new Pt1Qu1FragmentChild();
    }

    public Pt1Qu1FragmentChild() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pt1_qu1_fragment_child, container, false);
        view.findViewById(R.id.pt1qu1_op1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(,Pt1Qu2FragmentChild.class);
            }
        });

        return view;
    }
}
