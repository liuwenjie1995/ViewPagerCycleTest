package com.stevenhu.android.phone.ui;

/**
 * Created by Administrator on 2016/7/6.
 */
public class ServiceItem {
    int ImageId;
    String ServiceName;
    String ServiceDetail;
    String ServicePrice;
    boolean collect;
    public ServiceItem(int ImageId,String ServiceName,String ServiceDetail,String ServicePrice,Boolean collect)
    {
        this.ImageId = ImageId;
        this.ServiceName = ServiceName;
        this.ServiceDetail = ServiceDetail;
        this.ServicePrice = ServicePrice;
        this.collect = collect;
    }
}
