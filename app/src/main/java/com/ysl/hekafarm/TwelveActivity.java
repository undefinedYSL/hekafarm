package com.ysl.hekafarm;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class TwelveActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_twelve);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar12);
		toolbar.setTitle("党建工作");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		StatusBarUtil.setImmersiveStatusBar(this,true);
		ImageView iv_1=(ImageView)findViewById(R.id.iv_twelve_1);
		Glide.with(this).load(R.drawable.cgzs01).into(iv_1);
		ImageView iv_2=(ImageView)findViewById(R.id.iv_twelve_2);
		Glide.with(this).load(R.drawable.cgzs02).into(iv_2);
		ImageView iv_3=(ImageView)findViewById(R.id.iv_twelve_3);
		Glide.with(this).load(R.drawable.cgzs03).into(iv_3);
		ImageView iv_4=(ImageView)findViewById(R.id.iv_twelve_4);
		Glide.with(this).load(R.drawable.cgzs04).into(iv_4);
		ImageView iv_5=(ImageView)findViewById(R.id.iv_twelve_5);
		Glide.with(this).load(R.drawable.cgzs05).into(iv_5);
		ImageView iv_6=(ImageView)findViewById(R.id.iv_twelve_6);
		Glide.with(this).load(R.drawable.cgzs06).into(iv_6);
		/*ImageView iv_7=(ImageView)findViewById(R.id.iv_twelve_7);
		Glide.with(this).load(R.drawable.cgzs07).into(iv_7);*/
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
