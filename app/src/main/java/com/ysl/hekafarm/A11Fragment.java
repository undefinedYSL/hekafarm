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
public class A11Fragment extends Fragment {

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
		View view =  inflater.inflate(R.layout.fragment_a11, container, false);
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
		Log.d("onPause","a11暂停了");
		hkitemList.clear();
	}

	@Override
	public void onResume(){
		super.onResume();
		Log.d("onResume","a11重载了");
		if (hkitemList.size() == 0){
			initItems();

		}
	}

	private void initItems() {
		hkitemList.add(new HKitem("产业发展",
				"积极调整产业结构，利用成熟的技术力量和机械化程度高的优势，有效利用土地资源，抓住国家农垦改革有利政策，大力发展特高原色农牧产业。",
				"2018-9-1",
				R.drawable.cy1));
		hkitemList.add(new HKitem("企业文化建设",
				"河卡种羊场每年举办“七一”党建活动，开展多项文体活动，场领导以普通职工的身份积极参与，促进了上下关系的和睦，极大地激发了职工参加文体活动的热情。表先进，树典型，通过表彰先进激励斗志，鞭策全场干部职工向被表彰的先进人物、先进事迹学习。",
				"2018-9-1",
				R.drawable.qywh1));
		hkitemList.add(new HKitem("精准扶贫",
				"我场于2017年精准识别贫困户共40户，自筹70万元扶贫资金，购买羊960只、牛128头，按照农户自愿的原则，将牛羊进行分配，愿意养羊的每户免费提供给40只.",
				"2018-9-1",
				R.drawable.jzfp01));
		hkitemList.add(new HKitem("领导关怀",
				"青海省河卡种羊场的发展得到了各级领导的亲切关怀和指导，激励着一代又一代的羊场儿女不断探索、追求卓越。",
				"2018-9-1",
				R.drawable.dj1));
		hkitemList.add(new HKitem("各族团结活动",
				"以身边先进模范宣传，加强身边事教育身边人，用他们不平凡的事迹来教育、影响、感召全场党员、干部、职工向模范榜样学习，不忘初心，继续前进，扛起先锋旗全心全意为人民群众服务，从眼前做起，从小事做起，在自己的岗位上兢兢业业，恪守初心，传递正能量。",
				"2018-9-1",
				R.drawable.tj1));
		hkitemList.add(new HKitem("全程机械化",
				"青海省农牧厅主办，省农牧机械推广站、草原总站、草原学会联合举办的“全省牧草（燕麦）生产全程机械化技术实训”活动在青海省河卡种羊场举办，免耕播种机、牧草收获机、摊晒机、搂草机、打捆机、打捆包膜机、叉运机轮番上阵，上演了一场牧草生产全程机械化的盛宴。",
				"2018-9-1",
				R.drawable.jx1));
		hkitemList.add(new HKitem("学习教育",
				"认真开展“两学一做”学习教育，各支部以集中学、联合学，自学的方式扎实学习习近平总书记新系列讲话精神、十九大精神及党纪党规等。牧业党支部、农业党支部开展草原田间课堂",
				"2018-9-1",
				R.drawable.xx1));
	}
}
