package com.ysl.hekafarm;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class D4Activity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_d4);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbard4);
		toolbar.setTitle("联系我们");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		StatusBarUtil.setImmersiveStatusBar(this,true);
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
