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

public class A4Activity extends AppCompatActivity {

	ArrayList<String> titlelist;
	ArrayList<Fragment> fragmentslist;
	private ViewPager vp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a4);
		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbara4);
		toolbar.setTitle("河卡藏羊");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		StatusBarUtil.setImmersiveStatusBar(this,true);

		titlelist = new ArrayList<>();
		titlelist.add("藏羊简介");
		titlelist.add("藏羊特点");
		titlelist.add("藏羊文化");
		titlelist.add("半细毛羊");
		fragmentslist = new ArrayList<>();
		fragmentslist.add(new A41Fragment());
		fragmentslist.add(new A42Fragment());
		fragmentslist.add(new A43Fragment());
		fragmentslist.add(new A44Fragment());
		NewPagerAdapter newPagerAdapter = new NewPagerAdapter(getSupportFragmentManager(),titlelist,fragmentslist);
		vp = (ViewPager)findViewById(R.id.vp_a4);
		TabLayout tl = (TabLayout)findViewById(R.id.tl_a4);
		vp.setAdapter(newPagerAdapter);
//		vp.addOnPageChangeListener(this);
		tl.setupWithViewPager(vp);
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
