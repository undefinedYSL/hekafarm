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

public class A3Activity extends AppCompatActivity {

	ArrayList<String> titlelist;
	ArrayList<Fragment> fragmentslist;
	private ViewPager vp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a3);
		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbara3);
		toolbar.setTitle("河卡牧场");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		StatusBarUtil.setImmersiveStatusBar(this,true);


		titlelist = new ArrayList<>();

		titlelist.add("夏季草场");
		titlelist.add("秋季草场");
		titlelist.add("冬季草场");
		titlelist.add("人工草场");

		fragmentslist = new ArrayList<>();
		fragmentslist.add(new A31Fragment());
		fragmentslist.add(new A32Fragment());
		fragmentslist.add(new A33Fragment());
		fragmentslist.add(new A34Fragment());
		NewPagerAdapter newPagerAdapter = new NewPagerAdapter(getSupportFragmentManager(),titlelist,fragmentslist);
		vp = (ViewPager)findViewById(R.id.vp_a3);
		TabLayout tl = (TabLayout)findViewById(R.id.tl_a3);
		vp.setAdapter(newPagerAdapter);
//		vp.addOnPageChangeListener(this);
		tl.setupWithViewPager(vp);
		tl.setTabsFromPagerAdapter(newPagerAdapter);
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
}
