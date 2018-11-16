package com.ysl.hekafarm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

	private ArrayList<Fragment> fragments;
	private BottomNavigationBar bottomNavigationBar;
	private AFragment aFragment;
	private BFragment bFragment;
	private CFragment cFragment;
	private DFragment dFragment;
	private FragmentManager fm;
	private FragmentTransaction ft;
	private Fragment fragment;
	private Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//保证不会重新add
//		fm = getSupportFragmentManager();
//		if (savedInstanceState !=null){
//			aFragment = (AFragment)fm.findFragmentByTag("Home");
//			bFragment = (BFragment)fm.findFragmentByTag("Books");
//			cFragment = (CFragment)fm.findFragmentByTag("Music");
//			dFragment = (DFragment)fm.findFragmentByTag("TV");
//		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		StatusBarUtil.setImmersiveStatusBar(this,true);
//
//		ActionBar actionBar = getSupportActionBar();
//		if(actionBar !=null){
//			actionBar.setDisplayHomeAsUpEnabled(true);
//		}

		//初始化控件
		init();
		//获得所有fragment
		fragments = getFragments();
		//设置默认
		onTabSelected(0);
	}



	private ArrayList<Fragment> getFragments() {
		//实例化Fragment
		aFragment = new AFragment();
		bFragment = new BFragment();
		cFragment = new CFragment();
		dFragment = new DFragment();
		ArrayList<Fragment> fragments = new ArrayList<>();
		fragments.add(aFragment.newInstance("主页"));
		fragments.add(bFragment.newInstance("羊场简介"));
		fragments.add(cFragment.newInstance("党建工作"));
		fragments.add(dFragment.newInstance("更多"));
		return fragments;
	}


	private void init() {
		bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
		bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
		bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
		bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp,"主页").setActiveColorResource(R.color.orange))
				.addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp,"羊场简介").setActiveColorResource(R.color.teal))
				.addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "党建工作").setActiveColorResource(R.color.blue))
				.addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "更多").setActiveColorResource(R.color.brown))
				.setFirstSelectedPosition(0)
				.initialise();
		bottomNavigationBar.setTabSelectedListener(this);

	}

	@Override
	public void onTabSelected(int position) {
		if (fragments != null){
			if (position < fragments.size()){
				fm = getSupportFragmentManager();
				ft = fm.beginTransaction();
				fragment = fragments.get(position);
				String str = Integer.toString(position);
				if (fragment.isAdded()||fragment.isHidden()){
					ft.show(fragment);
					Log.d("onTabSelected","点击了"+str);
				}
				else {
					ft.add(R.id.fl_base,fragment);
					Log.d("onTabSelected","创建了"+str);
				}
				ft.commitAllowingStateLoss();
			}
		}

	}

	@Override
	public void onTabUnselected(int position) {
		if (fragments != null) {
			if (position < fragments.size()) {
				fm = getSupportFragmentManager();
				ft = fm.beginTransaction();
				fragment = fragments.get(position);
				String str = Integer.toString(position);
				ft.hide(fragment);
				Log.d("onTabReselected","我隐藏了"+str);
				ft.commitAllowingStateLoss();
			}
		}

	}

	@Override
	public void onTabReselected(int position) {
		if (fragments != null){
			if (position < fragments.size()){
				fm = getSupportFragmentManager();
				ft = fm.beginTransaction();
				fragment = fragments.get(position);
				String str = Integer.toString(position);
				if (fragment.isAdded()||fragment.isHidden()){
					ft.show(fragment);
					Log.d("onTabReselected","重复点击了"+str);
				}else {
					Log.d("onTabReselected","啥都没发生");
				}
				ft.commitAllowingStateLoss();
			}
		}

	}

}
