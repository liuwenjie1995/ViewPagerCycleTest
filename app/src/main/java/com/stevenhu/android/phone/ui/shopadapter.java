package com.stevenhu.android.phone.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/9.
 */
public class shopadapter extends ArrayAdapter<shopitem> {
    private int resourceId;
    public shopadapter(Context context, int textViewResourceId, List<shopitem> object)
    {
        super(context,textViewResourceId,object);
        this.resourceId = textViewResourceId;
    }
    public View getView(int postion,View convertView,ViewGroup parent)
    {

        shopitem shopitem = getItem(postion);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView shopname = (TextView)view.findViewById(R.id.itemname);
        TextView shopdescription = (TextView)view.findViewById(R.id.itemdescription);
        shopname.setText(shopitem.name.toString());
        shopdescription.setText(shopitem.detail.toString());
        return view;
    }

}
