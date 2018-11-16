package com.ysl.hekafarm;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class TenActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ten);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar10);
		toolbar.setTitle("党建工作");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		StatusBarUtil.setImmersiveStatusBar(this,true);
		ImageView iv_1=(ImageView)findViewById(R.id.iv_ten_1);
		Glide.with(this).load(R.drawable.wthd00).into(iv_1);
		ImageView iv_2=(ImageView)findViewById(R.id.iv_ten_2);
		Glide.with(this).load(R.drawable.wthd01).into(iv_2);
		ImageView iv_3=(ImageView)findViewById(R.id.iv_ten3);
		Glide.with(this).load(R.drawable.wthd02).into(iv_3);
		ImageView iv_4=(ImageView)findViewById(R.id.iv_ten_4);
		Glide.with(this).load(R.drawable.wthd03).into(iv_4);
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
