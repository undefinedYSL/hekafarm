package com.ysl.hekafarm;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class OneActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar01);
		toolbar.setTitle("详细介绍");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		StatusBarUtil.setImmersiveStatusBar(this,true);
		ImageView iv_1=(ImageView)findViewById(R.id.iv_one_1);
		Glide.with(this).load(R.drawable.gate1).into(iv_1);
		ImageView iv_2=(ImageView)findViewById(R.id.iv_one_2);
		Glide.with(this).load(R.drawable.gate2).into(iv_2);
//		ImageView iv_3=(ImageView)findViewById(R.id.iv_one_3);
//		Glide.with(this).load(R.drawable.gate3).into(iv_3);
//		ImageView iv_4=(ImageView)findViewById(R.id.iv_one_4);
//		Glide.with(this).load(R.drawable.gate4).into(iv_4);
//		ImageView iv_5=(ImageView)findViewById(R.id.iv_one_5);
//		Glide.with(this).load(R.drawable.gate5).into(iv_5);
//		ImageView iv_6=(ImageView)findViewById(R.id.iv_one_6);
//		Glide.with(this).load(R.drawable.gate6).into(iv_6);
//		ImageView iv_7=(ImageView)findViewById(R.id.iv_one_7);
//		Glide.with(this).load(R.drawable.gate7).into(iv_7);
//		ImageView iv_8=(ImageView)findViewById(R.id.iv_one_8);
//		Glide.with(this).load(R.drawable.gate8).into(iv_8);
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
