package com.ysl.hekafarm;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.loopeer.cardstack.CardStackView;

import java.util.Arrays;

public class D1Activity extends AppCompatActivity implements CardStackView.ItemExpendListener {

	private CardStackView cardStackView;
	private TestStackAdapter testStackAdapter;

	private static Integer[] item = new Integer[]{
			R.color.color_17,R.color.color_16,R.color.color_15,R.color.color_14,R.color.color_13
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_d1);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbard1);
		toolbar.setTitle("羊场监测");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		init();
		StatusBarUtil.setImmersiveStatusBar(this,true);
	}

	private void init() {
		cardStackView = (CardStackView)findViewById(R.id.csk_c);
		testStackAdapter = new TestStackAdapter(D1Activity.this);
		cardStackView.setAdapter(testStackAdapter);
		cardStackView.setItemExpendListener(this);

		new Handler().postDelayed(
				new Runnable() {
					@Override
					public void run() {
						testStackAdapter.updateData(Arrays.asList(item));
					}
				}
				, 200
		);
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
	public void onItemExpend(boolean expend) {
		Log.d("onItemExpend","卡片被点击了");
	}
}
