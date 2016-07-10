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
 * Created by Administrator on 2016/7/8.
 */
public class ItemAdapter extends ArrayAdapter<ServiceItem> {
    private int resourceId;
    public ItemAdapter(Context context, int textViewResourceId, List<ServiceItem> object)
    {
        super(context,textViewResourceId,object);
        resourceId = textViewResourceId;
    }
    public View getView(int postion,View convertView,ViewGroup parent)
    {
        ServiceItem serviceItem  =  getItem(postion);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView itempicture = (ImageView)view.findViewById(R.id.itempicture);
        TextView itemtitle = (TextView)view.findViewById(R.id.itemtitle);
        ImageView collect = (ImageView)view.findViewById(R.id.collect);
        TextView itemdetail = (TextView)view.findViewById(R.id.itemdescription);
        TextView itemprice = (TextView)view.findViewById(R.id.itemprice);
        itempicture.setImageResource(serviceItem.ImageId);
        itemtitle.setText(serviceItem.ServiceName);
        itemdetail.setText(serviceItem.ServiceDetail);
        itempicture.setImageResource(serviceItem.ImageId);
        itemprice.setText(serviceItem.ServicePrice);
        if(serviceItem.collect==false)
        {
            collect.setImageResource(R.drawable.collectoff);
        }
        else
        {
        collect.setImageResource(R.drawable.collecton);
        }
        return view;
    }

}
