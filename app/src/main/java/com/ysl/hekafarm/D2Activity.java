package com.ysl.hekafarm;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.loopeer.cardstack.CardStackView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2Activity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_d2);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbard2);
		toolbar.setTitle("企业文化");
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

	/*private void init() {
		mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
		//设置布局管理器为2列，纵向
		mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
		mAdapter = new WaterFallAdapter(this,buildData());

		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setAdapter(mAdapter);
		Fresco.initialize(getApplicationContext());
	}*/

	/*//生成6个明星数据，这些Url地址都来源于网络
	private List<PersonCard> buildData() {

		String[] names = {"邓紫棋","范冰冰","杨幂","Angelababy","唐嫣","柳岩"};
		String[] imgUrs = {"http://pic3.huitu.com/res/20120618/83618_20120618174254934200_1.jpg",
				"drawable/base_show4.png",
                "http://p0.so.qhimgs1.com/bdr/200_200_/t018d43fd6ee4b4e3a0.jpg",
				"https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=fd90a83e900a304e4d22a7fae1c9a7c3/d01373f082025aafa480a2f1fcedab64034f1a5d.jpg",
				"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1849074283,1272897972&fm=111&gp=0.jpg",
				"https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=005560fc8b5494ee982208191df4e0e1/c2fdfc039245d68827b453e7a3c27d1ed21b243b.jpg",
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
	}*/

    /*public void onItemExpend(boolean expend) {
		Log.d("onItemExpend","卡片被点击了");
	}*/

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





//}
