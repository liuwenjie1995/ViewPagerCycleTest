package com.stevenhu.android.phone.ui;
        import java.util.List;
        import android.content.Context;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.View.OnLongClickListener;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

 class MyBaseAdapter extends BaseAdapter {
    private List<ServiceItem> persons;
    Context context;

    public MyBaseAdapter(Context context, List<ServiceItem> persons) {
        this.persons = persons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return (persons == null) ? 0 : persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public class ViewHolder {
        ImageView itempicture;
        TextView itemtitle;
        ImageView collect;
        TextView itemdetail;
        TextView itemprice;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ServiceItem serviceItem = (ServiceItem) getItem(position);
        ViewHolder viewHolder = null;
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

            viewHolder = new ViewHolder();
            viewHolder.itempicture = (ImageView) convertView.findViewById(R.id.itempicture);
            viewHolder.itemtitle = (TextView) convertView.findViewById(R.id.itemtitle);
            viewHolder.collect = (ImageView) convertView.findViewById(R.id.collect);
            viewHolder.itemdetail = (TextView) convertView.findViewById(R.id.itemdescription);
            viewHolder.itemprice = (TextView) convertView.findViewById(R.id.itemprice);


            viewHolder.itempicture.setImageResource(serviceItem.ImageId);
            viewHolder.itemtitle.setText(serviceItem.ServiceName);
            viewHolder.itemdetail.setText(serviceItem.ServiceDetail);
            viewHolder.itempicture.setImageResource(serviceItem.ImageId);
            viewHolder.itemprice.setText(serviceItem.ServicePrice + "元/次");
            if(serviceItem.collect==false)
            {
                viewHolder.collect.setImageResource(R.drawable.collectoff);
            }
            else
            {
              viewHolder.collect.setImageResource(R.drawable.collecton);
            }
            return convertView;
    }

}
