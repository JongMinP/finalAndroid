package com.example.kosta.beautymateandroid.survey;

/**
 * Created by kosta on 2017-06-13.
 */

public enum Pt1FragmentController{
    OSPW(0),OSPT(1),OSNW(2),OSNT(3),ORPW(4),ORPT(5),
    ORNW(6),ORNT(7),DSPW(8),DSPT(9),DSNW(10),DSNT(11),
    DRPW(12),DRPT(13),DRNW(14),DRNT(15);

    private int index;

    private Pt1FragmentController(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }
}
