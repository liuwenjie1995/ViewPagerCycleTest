package com.stevenhu.android.phone.ui;

import java.util.ArrayList;
import java.util.List;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.stevenhu.android.phone.bean.ADInfo;
import com.stevenhu.android.phone.utils.ViewFactory;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Notification;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.androiddevelop.cycleviewpager.lib.CycleViewPager;
import cn.androiddevelop.cycleviewpager.lib.CycleViewPager.ImageCycleViewListener;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * 描述：主页
 *
 * @author 胡笃勇
 * @version 2015年5月8日 上午10:47:37
 */
public class MainActivity extends Activity {
	private List<ImageView> views = new ArrayList<ImageView>();
	private List<ADInfo> infos = new ArrayList<ADInfo>();
	private CycleViewPager cycleViewPager;
	private String[] imageUrls = {
			"http://a2.qpic.cn/psb?/V11tQBjW1YZQH2/iQGSAXtZ8db4bjHtR9Tvj6jm3XKK94WtNnoEUFS1lpk!/b/dKwAAAAAAAAA&bo=gAKQAQAAAAAFBzc!&rf=viewer_4.jpg",
			"http://a2.qpic.cn/psb?/V11tQBjW1YZQH2/CmyLwuNFhHd6fyEVUubi94UjU9I1u4cysa1hBpWGTwk!/b/dK8AAAAAAAAA&bo=gAKQAQAAAAAFADA!&rf=viewer_4.jpg",
			"http://a3.qpic.cn/psb?/V11tQBjW1YZQH2/KXdqvfT7hdUJ*wGv7Gr.e5HjQSrexO7tvzuuci.i3.A!/b/dK0AAAAAAAAA&bo=egLXAQAAAAADAIs!&rf=viewer_4.jpg",
			"http://a3.qpic.cn/psb?/V11tQBjW1YZQH2/NYNODPYv729kFenr4O7Q8snm9zxJBObiNpKXXBSrSv4!/b/dP4AAAAAAAAA&bo=vAINAgAAAAAFAJI!&rf=viewer_4.jpg"};
	ViewPager pager = null;
	PagerTabStrip tabStrip = null;
	ArrayList<View> viewContainter = new ArrayList<View>();
	ArrayList<String> titleContainer = new ArrayList<String>();
	public String TAG = "tag";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(R.layout.titletheme);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_main);
		ImageView calimage = (ImageView)findViewById(R.id.callimage);
		//设置viewpager
		pager = (ViewPager) this.findViewById(R.id.viewpager);
		tabStrip = (PagerTabStrip) this.findViewById(R.id.tabstrip);
		//取消tab下面的长横线
		tabStrip.setDrawFullUnderline(false);
		//设置tab的背景色
		tabStrip.setBackgroundColor(this.getResources().getColor(R.color.royalblue));
		//设置当前tab页签的下划线颜色
		tabStrip.setTabIndicatorColor(this.getResources().getColor(R.color.slateblue));
		tabStrip.setTextSpacing(200);

		View view1 = LayoutInflater.from(this).inflate(R.layout.tab1, null);
		View view2 = LayoutInflater.from(this).inflate(R.layout.tab2, null);
		View view3 = LayoutInflater.from(this).inflate(R.layout.tab3, null);
		//viewpager开始添加view
		viewContainter.add(view1);
		viewContainter.add(view2);
		viewContainter.add(view3);
		//页签项
		titleContainer.add("商品目录");
		titleContainer.add("店铺详情");
		titleContainer.add("顾客评论");


		pager.setAdapter(new PagerAdapter() {

			//viewpager中的组件数量
			@Override
			public int getCount() {
				return viewContainter.size();
			}

			//滑动切换的时候销毁当前的组件
			@Override
			public void destroyItem(ViewGroup container, int position,
									Object object) {
				((ViewPager) container).removeView(viewContainter.get(position));
			}

			//每次滑动的时候生成的组件
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				((ViewPager) container).addView(viewContainter.get(position));
				return viewContainter.get(position);
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getItemPosition(Object object) {
				return super.getItemPosition(object);
			}

			@Override
			public CharSequence getPageTitle(int position) {
				return titleContainer.get(position);
			}
		});

		pager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrollStateChanged(int arg0) {
				Log.d(TAG, "--------changed:" + arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				Log.d(TAG, "-------scrolled arg0:" + arg0);
				Log.d(TAG, "-------scrolled arg1:" + arg1);
				Log.d(TAG, "-------scrolled arg2:" + arg2);
			}

			@Override
			public void onPageSelected(int arg0) {
				Log.d(TAG, "------selected:" + arg0);
			}
		});

		configImageLoader();
		initialize();

		calimage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri uri = Uri.parse("tel:13263296798");
				Intent i = new Intent();
				i.setAction(Intent.ACTION_CALL);
				i.setData(uri);
				startActivity(i);

			}
		});


		//设置商品的listview
		JsonFileOut js = new JsonFileOut();
		ItemAdapter adapter = new ItemAdapter(view1.getContext(),R.layout.item,js.getitem());
		ListView itemlistview = (ListView)view1.findViewById(R.id.itemlistView);
		itemlistview.setAdapter(adapter);
		itemlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent t = new Intent(MainActivity.this,turntoActivity.class);
				MainActivity.this.startActivity(t);
			}
		});
		//设置本店参数的listview
		JsonFileOut shopjs = new JsonFileOut(1);
		ListView shoplistview = (ListView)view2.findViewById(R.id.listView2);
		if(shopjs.getShop().isEmpty())
		{
			String t = shopjs.getShop().get(0).name.toString();
			Toast.makeText(MainActivity.this,t,Toast.LENGTH_LONG);
		}
		else
		{
			Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG);
		}
		shoplistview.setAdapter(new shopadapter(this,R.layout.shopitem,shopjs.getShop()));

		//设置评论席的listview
	}

	@SuppressLint("NewApi")
	private void initialize() {
		
		cycleViewPager = (CycleViewPager) getFragmentManager().findFragmentById(R.id.fragment_cycle_viewpager_content);
		
		for(int i = 0; i < imageUrls.length; i ++){
			ADInfo info = new ADInfo();
			info.setUrl(imageUrls[i]);
			info.setContent("图片-->" + i );
			infos.add(info);
		}
		
		// 将最后一个ImageView添加进来
		views.add(ViewFactory.getImageView(this, infos.get(infos.size() - 1).getUrl()));
		for (int i = 0; i < infos.size(); i++) {
			views.add(ViewFactory.getImageView(this, infos.get(i).getUrl()));
		}
		// 将第一个ImageView添加进来
		views.add(ViewFactory.getImageView(this, infos.get(0).getUrl()));
		
		// 设置循环，在调用setData方法前调用
		cycleViewPager.setCycle(true);

		// 在加载数据前设置是否循环
		cycleViewPager.setData(views, infos, mAdCycleViewListener);
		//设置轮播
		cycleViewPager.setWheel(true);

	    // 设置轮播时间，默认5000ms
		cycleViewPager.setTime(2000);
		//设置圆点指示图标组居中显示，默认靠右
		cycleViewPager.setIndicatorCenter();
	}
	
	private ImageCycleViewListener mAdCycleViewListener = new ImageCycleViewListener() {

		@Override
		public void onImageClick(ADInfo info, int position, View imageView) {
			if (cycleViewPager.isCycle()) {
				position = position - 1;
				Toast.makeText(MainActivity.this,
						"position-->" + info.getContent(), Toast.LENGTH_SHORT)
						.show();
			}
			
		}

	};
	
	/**
	 * 配置ImageLoder
	 */
	private void configImageLoader() {
		// 初始化ImageLoader
		@SuppressWarnings("deprecation")
		DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.icon_stub) // 设置图片下载期间显示的图片
				.showImageForEmptyUri(R.drawable.icon_empty) // 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(R.drawable.icon_error) // 设置图片加载或解码过程中发生错误显示的图片
				.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
				.cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
				// .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
				.build(); // 创建配置过得DisplayImageOption对象

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(options)
				.threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).build();
		ImageLoader.getInstance().init(config);		
	}
}
