package com.ysl.hekafarm;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class A2Activity extends AppCompatActivity {

	private RecyclerView mRecyclerView;
	private RecyclerView.LayoutManager mLayoutManager;
	private WaterFallAdapter mAdapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a2);
		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbard2);
		toolbar.setTitle("河卡产品");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		init();
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

	private void init() {
		mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
		//设置布局管理器为2列，纵向
		mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
		mAdapter = new WaterFallAdapter(this,buildData());

		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setAdapter(mAdapter);
		Fresco.initialize(getApplicationContext());
	}

	//生成6个明星数据，这些Url地址都来源于网络
	private List<PersonCard> buildData() {

		String[] names = {"半毛细羊","藏羊肉","藏羊排","羊肉卷","羊皮","羊肉"};
		String[] imgUrs = {"res://drawable/"+R.drawable.bmxy,
				"res://drawable/"+R.drawable.zyr1,
				"res://drawable/"+R.drawable.zyp1,
				"res://drawable/"+R.drawable.yrj1,
				"res://drawable/"+R.drawable.yp,
				"res://drawable/"+R.drawable.zyr2,
		};

		List<PersonCard> list = new ArrayList<>();
		for(int i=0;i<6;i++) {
			PersonCard p = new PersonCard();
			p.avatarUrl = imgUrs[i];
			p.name = names[i];
			p.imgHeight = (i % 2)*100 + 400; //偶数和奇数的图片设置不同的高度，以到达错开的目的
			list.add(p);
		}

		return list;
	}

	public void onItemExpend(boolean expend) {
		Log.d("onItemExpend","卡片被点击了");
	}

	/*@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_d2);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbard2);
		toolbar.setTitle("河卡产品");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		StatusBarUtil.setImmersiveStatusBar(this,true);
	}
	*/





}
