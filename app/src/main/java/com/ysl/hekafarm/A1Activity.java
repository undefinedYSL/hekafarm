package com.ysl.hekafarm;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import static com.ysl.hekafarm.Aactivity.news;

public class A1Activity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

	ArrayList<String> titlelist;
	ArrayList<Fragment> fragmentslist;
	private ViewPager vp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a1);
		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbara1);
		toolbar.setTitle("新闻资讯");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		StatusBarUtil.setImmersiveStatusBar(this,true);

		titlelist = new ArrayList<>();
		titlelist.add("公司新闻");
		titlelist.add("行业新闻");
		titlelist.add("文化生活");
		fragmentslist = new ArrayList<>();
		fragmentslist.add(new A11Fragment());
		fragmentslist.add(new A12Fragment());
		fragmentslist.add(new A13Fragment());
		NewPagerAdapter newPagerAdapter = new NewPagerAdapter(getSupportFragmentManager(),titlelist,fragmentslist);
		vp = (ViewPager)findViewById(R.id.vp_a1);
		TabLayout tl = (TabLayout)findViewById(R.id.tl_a1);
		vp.setAdapter(newPagerAdapter);
//		vp.addOnPageChangeListener(this);
		tl.setupWithViewPager(vp);
		tl.setTabsFromPagerAdapter(newPagerAdapter);
		vp.addOnPageChangeListener(this);
		news = 0;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:

				finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPageScrolled(int i, float v, int i1) {

	}

	@Override
	public void onPageSelected(int position) {
		switch (position){
			case 0:
//				adapter.setFlag(0);
				news = 0;
				break;
			case 1:
//				adapter.setFlag(1);
				news = 1;
				break;
			case 2:
//				adapter.setFlag(2);
				news = 2;
				break;
		}
	}

	@Override
	public void onPageScrollStateChanged(int i) {

	}
}
