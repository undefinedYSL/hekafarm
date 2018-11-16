package com.ysl.hekafarm;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class NineActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nine);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar09);
		toolbar.setTitle("党建工作");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		StatusBarUtil.setImmersiveStatusBar(this,true);
		ImageView iv_1=(ImageView)findViewById(R.id.iv_nine_1);
		Glide.with(this).load(R.drawable.ldgh01).into(iv_1);
		ImageView iv_2=(ImageView)findViewById(R.id.iv_nine_2);
		Glide.with(this).load(R.drawable.ldgh02).into(iv_2);
		ImageView iv_3=(ImageView)findViewById(R.id.iv_nine_3);
		Glide.with(this).load(R.drawable.ldgh03).into(iv_3);
		ImageView iv_4=(ImageView)findViewById(R.id.iv_nine_4);
		Glide.with(this).load(R.drawable.ldgh04).into(iv_4);
		ImageView iv_5=(ImageView)findViewById(R.id.iv_nine_5);
		Glide.with(this).load(R.drawable.ldgh05).into(iv_5);
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
