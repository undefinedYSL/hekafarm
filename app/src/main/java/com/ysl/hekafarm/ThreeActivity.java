package com.ysl.hekafarm;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ThreeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar03);
		toolbar.setTitle("详细介绍");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		StatusBarUtil.setImmersiveStatusBar(this,true);
		ImageView iv_1=(ImageView)findViewById(R.id.iv_three_1);
		Glide.with(this).load(R.drawable.chy).into(iv_1);
		ImageView iv_2=(ImageView)findViewById(R.id.iv_three_2);
		Glide.with(this).load(R.drawable.chy1).into(iv_2);
		ImageView iv_3=(ImageView)findViewById(R.id.iv_three_3);
		Glide.with(this).load(R.drawable.chy2).into(iv_3);
		ImageView iv_4=(ImageView)findViewById(R.id.iv_three_4);
		Glide.with(this).load(R.drawable.chy3).into(iv_4);
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
