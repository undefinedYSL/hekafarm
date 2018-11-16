package com.ysl.hekafarm;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class A13Fragment extends Fragment{

	private RecyclerView recyclerView;
	private NewsAdapter adapter;
	private List<HKitem> hkitemList = new ArrayList<>();



//	public AFragment() {
	// Required empty public constructor
//	}

	public static AFragment newInstance(String title){
		AFragment fragment = new AFragment();
		Bundle bundle = new Bundle();
		bundle.putString("title",title);
		fragment.setArguments(bundle);
		return fragment;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =  inflater.inflate(R.layout.fragment_a13, container, false);
		return view;
	}


	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initItems();
		//recyclerview的初始化
		recyclerView = (RecyclerView)view.findViewById(R.id.rv_a);
		LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
		adapter = new NewsAdapter(hkitemList);
		recyclerView.setAdapter(adapter);
	}



	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		//取消异步任务
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d("onPause","a13暂停了");
			hkitemList.clear();

	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d("onResume","a13重载了");
		if (hkitemList.size() == 0){
			initItems();

		}
	}

	private void initItems() {
		hkitemList.add(new HKitem("“青海红”卖到德国 “藏羊”遍布37个国家",
				"“我要把青海枸杞卖到全世界!”海西蒙古族藏族自治州乌兰县赛西珊瑚果种植专业合作社带头人张海红,在“十三五”开局之年,把一粒粒“青海红”卖到了德国。",
				"2018-9-1",
				R.drawable.onethreeone));
		hkitemList.add(new HKitem("“藏羊”7个展架产品抓人眼球",
				"青海新闻网讯 “这个毯子跟下面的尺寸不一样，放到右边的这一摞上。”",
				"2018-9-1",
				R.drawable.onethreetwo));
		hkitemList.add(new HKitem("高效养殖——科技创新为生态畜牧业插上翅膀",
				"“山加，分红金额28420元；关布道尔吉，分红金额14210元；同加，分红金额49735元；金明，分红金额21315元……”7月9日，都兰县香加乡科学图生态畜牧业合作社的分红仪式，让这片美丽的草原再次欢腾起来。",
				"2018-9-1",
				R.drawable.onethreethree));
		hkitemList.add(new HKitem("贵南县过马营镇藏羊之府生态畜牧业合作社召开分红大会",
				"新闻网讯 1月25日，贵南县过马营镇藏羊之府合作社召开分红大会，县农牧和科技局、过马营镇人民政府负责人等参加了分红大会。",
				"2018-9-1",
				R.drawable.onethrnnfour));
		hkitemList.add(new HKitem("脱贫攻坚看甘肃|甘南州安多集团：打造牦牛藏羊品牌让25万牧民增收致富",
				"被誉为“高原之舟”的牦牛与北极熊、企鹅共称为“世界三大高寒动物”。世界上95%的牦牛在中国，这其中又有80%在安多藏区。8月21日，“改革开放40年新变迁·脱贫攻坚看甘肃”2018全国百家网媒扶贫攻坚典型宣传活动在甘南州夏河县的行程，网媒记者就走进了甘肃安多清真绿色食品有限公司。这里正在通过打造世界牦牛品牌和藏羊品牌来不断提升牧区牛羊肉附加值，带动当地牧民群众增收致富。",
				"2018-9-1",
				R.drawable.onethreefive));


	}
}
