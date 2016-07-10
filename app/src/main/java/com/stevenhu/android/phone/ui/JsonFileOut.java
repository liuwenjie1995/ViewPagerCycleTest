package com.stevenhu.android.phone.ui;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class JsonFileOut {
    private List<ServiceItem> itemlist = new ArrayList<ServiceItem>();
    private List<shopitem> shopitemList = new ArrayList<shopitem>();
        public  JsonFileOut()
        {
            //get  json ServiceItem list;
            Thread t  =  new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
            itemlist.add(new ServiceItem(R.drawable.item1,"普通打印","普通打印使用HP4000激光打印机，纸张使用宏达75g打印纸。","0.1元/张",false));
            itemlist.add(new ServiceItem(R.drawable.item2,"标书制作","普通打印使用HP4000激光打印机，纸张使用宏达75g打印纸。","35元/张",false));
            itemlist.add(new ServiceItem(R.drawable.item3,"彩色打印","普通打印使用HP4000激光打印机，纸张使用宏达75g打印纸。","20元/张",false));
            itemlist.add(new ServiceItem(R.drawable.item4,"录入文件","普通打印使用HP4000激光打印机，纸张使用宏达75g打印纸。","5元/张",false));


        }

   public  JsonFileOut(int i)
   {
       //get shop;
                       shopitemList.add(new shopitem("sid","hongdashop"));
                       shopitemList.add(new shopitem("名称","宏达打印店"));
                       shopitemList.add(new shopitem("服务内容","打印，复印，录入，标书，装订"));
                       shopitemList.add(new shopitem("口号","宏达打印店是面向北京化工大学热心服务的打印店，欢迎大家来服务"));
                       shopitemList.add(new shopitem("所在学校","北京化工大学"));
                       shopitemList.add(new shopitem("地址","北京市朝阳区东三环北路北京化工大学15号图书馆"));
                       shopitemList.add(new shopitem("邮编","100029"));
                       shopitemList.add(new shopitem("电话","2312312423"));
                       shopitemList.add(new shopitem("手机","34534353453453"));
                       shopitemList.add(new shopitem("e-mail","helloworld@qq.com"));
                       shopitemList.add(new shopitem("QQ","2342322423423"));
                       shopitemList.add(new shopitem("服务邮箱","118787688@qwq.com"));
                       shopitemList.add(new shopitem("经度","334.33"));
                       shopitemList.add(new shopitem("维度","545.333"));
                       shopitemList.add(new shopitem("位置","图书馆"));
                       shopitemList.add(new shopitem("路线","图书馆进门左转"));
                       shopitemList.add(new shopitem("operating","1"));
                        shopitemList.add(new shopitem("cerit","5"));
                        shopitemList.add(new shopitem("balance","3213.3"));
                        shopitemList.add(new shopitem("营业时间","8:00am"));
                         shopitemList.add(new shopitem("停业时间","20:00"));

   }
    public List<ServiceItem> getitem() {return itemlist;}
    public List<shopitem> getShop()    {return  shopitemList;}
}
