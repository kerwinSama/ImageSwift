package com.daniel.picture;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ViewPager viewPager;
	private TextView txt;
	private ImageView dot1, dot2, dot3, dot4, dot5;
	private ArrayList<AdBean> list = new ArrayList<AdBean>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initUI();
		initListener();
		initData();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		txt = (TextView) findViewById(R.id.text);
		dot1 = (ImageView) findViewById(R.id.dot1);
		dot2 = (ImageView) findViewById(R.id.dot2);
		dot3 = (ImageView) findViewById(R.id.dot3);
		dot4 = (ImageView) findViewById(R.id.dot4);
		dot5 = (ImageView) findViewById(R.id.dot5);
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
			handler.sendEmptyMessageDelayed(0, 4000);
		};
	};

	private void initListener() {
		// TODO Auto-generated method stub
		MyPageChangerListener listener = new MyPageChangerListener();
		viewPager.setOnPageChangeListener(listener);
	}

	private void initData() {
		// TODO Auto-generated method stub
		list.add(new AdBean(R.drawable.a, "巩俐不低俗，我就不能低俗"));
		list.add(new AdBean(R.drawable.b, "朴树又回来了，再唱经典老歌引百万人同唱啊"));
		list.add(new AdBean(R.drawable.c, "揭秘北京电影如何升级"));
		list.add(new AdBean(R.drawable.d, "乐视网TV版大放送"));
		list.add(new AdBean(R.drawable.e, "热血屌丝的反杀"));
		viewPager.setAdapter(new MyAdapter());
		int item = Integer.MAX_VALUE / 2;
		viewPager.setCurrentItem(item - 3);
		handler.sendEmptyMessageDelayed(0, 4000);
	}

	class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return Integer.MAX_VALUE;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * android.support.v4.view.PagerAdapter#isViewFromObject(android.view
		 * .View, java.lang.Object) true 表示不再创建 arg0 当前滑动的view arg1
		 * 将要进入的view,由instantiateItem创建
		 */
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			View view = View.inflate(MainActivity.this, R.layout.adapter_ad,
					null);
			ImageView iamge = (ImageView) view.findViewById(R.id.image);
			iamge.setImageResource(list.get(position % 5).getIconResId());
			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView((View) object);
		}
	}

	class MyPageChangerListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			Log.v("Daniel", arg0 + "");
			updateTxt();
			updateDot();
		}

		private void updateDot() {
			// TODO Auto-generated method stub
			int currentPage = viewPager.getCurrentItem() % 5;
			switch (currentPage) {
			case 0:
				dot1.setBackgroundResource(R.drawable.shape_dot);
				dot2.setBackgroundResource(R.drawable.shape_dot2);
				dot3.setBackgroundResource(R.drawable.shape_dot2);
				dot4.setBackgroundResource(R.drawable.shape_dot2);
				dot5.setBackgroundResource(R.drawable.shape_dot2);
				break;
			case 1:
				dot1.setBackgroundResource(R.drawable.shape_dot2);
				dot2.setBackgroundResource(R.drawable.shape_dot);
				dot3.setBackgroundResource(R.drawable.shape_dot2);
				dot4.setBackgroundResource(R.drawable.shape_dot2);
				dot5.setBackgroundResource(R.drawable.shape_dot2);
				break;
			case 2:
				dot1.setBackgroundResource(R.drawable.shape_dot2);
				dot2.setBackgroundResource(R.drawable.shape_dot2);
				dot3.setBackgroundResource(R.drawable.shape_dot);
				dot4.setBackgroundResource(R.drawable.shape_dot2);
				dot5.setBackgroundResource(R.drawable.shape_dot2);
				break;
			case 3:
				dot1.setBackgroundResource(R.drawable.shape_dot2);
				dot2.setBackgroundResource(R.drawable.shape_dot2);
				dot3.setBackgroundResource(R.drawable.shape_dot2);
				dot4.setBackgroundResource(R.drawable.shape_dot);
				dot5.setBackgroundResource(R.drawable.shape_dot2);
				break;
			case 4:
				dot1.setBackgroundResource(R.drawable.shape_dot2);
				dot2.setBackgroundResource(R.drawable.shape_dot2);
				dot3.setBackgroundResource(R.drawable.shape_dot2);
				dot4.setBackgroundResource(R.drawable.shape_dot2);
				dot5.setBackgroundResource(R.drawable.shape_dot);
				break;

			}
		}

		private void updateTxt() {
			// TODO Auto-generated method stub
			int currentPage = viewPager.getCurrentItem() % 5;
			txt.setText(list.get(currentPage).getDesc());

		}

	}
}
