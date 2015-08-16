package com.kool.trafficnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by phuruang on 8/16/2015.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit

    private Context objContext;
    private String[] titleStrings;
    private int[]   iconAnInt;


    public MyAdapter(Context objContext, String[] titleStrings, int[] iconAnInt) {
        this.objContext = objContext;
        this.titleStrings = titleStrings;
        this.iconAnInt = iconAnInt;
    }   //Constructor


    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.list_traffic, viewGroup, false);

        //Show Icon
        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imvIcon);
        iconImageView.setImageResource(iconAnInt[i]);

        //Show Title
        TextView titleTextView = (TextView) objView1.findViewById(R.id.txtListShow);
        titleTextView.setText(titleStrings[i]);

        return objView1;
    } //getView
}  //Main Class
