package com.example.kosta.beautymateandroid.survey;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kosta.beautymateandroid.R;

public class Pt1Survey extends Fragment implements View.OnClickListener {
    int fragmentController = 0;
    Fragment fg = null;
    Button btn_pt1_back;
    Button btn_pt1_start;
    Button btn_pt1_restart;
    Button temp_start;
    Button temp_back;
    Button temp_restart;


    public static Pt1Survey newInstance() {
        return new Pt1Survey();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fg = Pt1Qu0FragmentChild.newInstance();
        setChildFragment(fg);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fv = inflater.inflate(R.layout.fragment_pt1_survey,container,false);
        btn_pt1_start = (Button) fv.findViewById(R.id.btn_pt1_start);
        temp_start = (Button) fv.findViewById(R.id.btn_pt1_start);
        btn_pt1_start.setOnClickListener(this);
        btn_pt1_back = (Button) fv.findViewById(R.id.btn_pt1_back);
        temp_back = (Button) fv.findViewById(R.id.btn_pt1_back);
        fv.findViewById(R.id.btn_pt1_back).setVisibility(View.GONE);
        btn_pt1_back.setOnClickListener(this);
        btn_pt1_restart = (Button) fv.findViewById(R.id.btn_pt1_restart);
        temp_restart = (Button) fv.findViewById(R.id.btn_pt1_restart);
        fv.findViewById(R.id.btn_pt1_restart).setVisibility(View.GONE);
        btn_pt1_restart.setOnClickListener(this);
        return fv;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_pt1_start:
                fragmentController = fragmentController + 1;
                //여기서 각번호 조건 처리
                btn_pt1_start = temp_start;
                btn_pt1_start.setVisibility(View.GONE);
                if(fragmentController != 0) {
                    btn_pt1_back = temp_back;
                    btn_pt1_back.setVisibility(View.VISIBLE);
                    btn_pt1_restart = temp_restart;
                    btn_pt1_restart.setVisibility(View.VISIBLE);
                }
                goFragment();
                break;
            case R.id.btn_pt1_back:
                fragmentController = fragmentController - 1;
                Log.d("test", String.valueOf(fragmentController));
                if(fragmentController == 0){
                    btn_pt1_start = temp_start;
                    btn_pt1_start.setVisibility(View.VISIBLE);
                    btn_pt1_back = temp_back;
                    btn_pt1_back.setVisibility(View.GONE);
                    btn_pt1_restart = temp_restart;
                    btn_pt1_restart.setVisibility(View.GONE);
                }
                goFragment();
                break;
            case R.id.btn_pt1_restart:
                fragmentController = 0;
                btn_pt1_start = temp_start;
                btn_pt1_start.setVisibility(View.VISIBLE);
                if(btn_pt1_back.getVisibility() == View.VISIBLE) {
                    btn_pt1_back = temp_back;
                    btn_pt1_back.setVisibility(View.GONE);
                }
                if(btn_pt1_restart.getVisibility() == View.VISIBLE){
                    btn_pt1_restart = temp_restart;
                    btn_pt1_restart.setVisibility(View.GONE);
                }
                fg = Pt1Qu0FragmentChild.newInstance();
                setChildFragment(fg);
                break;
        }
    }

    private void goFragment(){
        if(fragmentController == 0 ) {
            fg = Pt1Qu0FragmentChild.newInstance();
            setChildFragment(fg);
        }else if (fragmentController == 1) {
            fg = Pt1Qu1FragmentChild.newInstance();
            setChildFragment(fg);
        }else if (fragmentController == 2) {
            fg = Pt1Qu2FragmentChild.newInstance();
            setChildFragment(fg);
        }
    }

    private void setChildFragment(Fragment child){
        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

        if (!child.isAdded()){
            childFt.replace(R.id.pt1_qu_child_fragment, child);
            childFt.addToBackStack(null);
            childFt.commit();
        }
    }
}


