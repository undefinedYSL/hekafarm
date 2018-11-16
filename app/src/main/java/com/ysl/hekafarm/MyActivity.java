package com.ysl.hekafarm;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;


public class MyActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

	private ViewPager mViewPager;
	private List<Fragment> mFragmentList;
//	NavigationController navigationController;
//	PageNavigationView tab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);

//		tab = (PageNavigationView) findViewById(R.id.tab);
//
//		navigationController = tab.material()
//				.addItem(android.R.drawable.ic_menu_camera, "相机")
//				.addItem(android.R.drawable.ic_menu_compass, "位置")
//				.addItem(android.R.drawable.ic_menu_search, "搜索")
//				.addItem(android.R.drawable.ic_menu_help, "帮助")
//				.build();
//
//		navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
//			@Override
//			public void onSelected(int index, int old) {
//
//			}
//
//			@Override
//			public void onRepeat(int index) {
//				//重复选中时触发
//
//			}
//		});
//
//
//
//		navigationController.setupWithViewPager(mViewPager);
	}


	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		if (positionOffsetPixels != 0){
		}
	}

	@Override
	public void onPageSelected(int i) {

	}

	@Override
	public void onPageScrollStateChanged(int i) {

	}
}
