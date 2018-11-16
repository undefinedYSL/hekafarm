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
public class A12Fragment extends Fragment{


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
		View view =  inflater.inflate(R.layout.fragment_a12, container, false);
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
		//圆点的初始化
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
		Log.d("onPause","a12暂停了");
		hkitemList.clear();
	}

	@Override
	public void onResume(){
		super.onResume();
		Log.d("onResume","a12重新加载了");

		if(hkitemList.size() ==0){
			initItems();
		}

	}

	private void initItems() {
		hkitemList.add(new HKitem("海晏藏羊“两年三胎” 项目第三阶段 产羔顺利结束",
				"本报海北讯 （记者 尹耀增） 按照《海北藏系母羊“两年三胎”高效养殖推广项目实施方案》，在海北藏族自治州海晏县哈勒景乡实施的藏羊“两年三胎”项目第三阶段产羔工作已顺利完成。",
				"2018-3-29",R.drawable.one21));
		hkitemList.add(new HKitem("“欧拉羊”入选国家畜禽遗传资源名录",
				"青海新闻网讯 近日，农业农村部发布公告，由我省和甘肃省联合申报的“欧拉羊”畜禽遗传资源入选国家畜禽遗传资源，并列入名录。",
				"2018-10-13",
				R.drawable.one22));
		hkitemList.add(new HKitem("世界石书奇观和日寺！一县一品公益助农，青海泽库农特产品藏羊",
				"泽库县，隶属于青海省黄南藏族自治州，位于青海省的东南部， 黄南藏族自治州中南部，东与甘肃省夏河县毗邻，南连河南蒙古族自治县，西靠青海省同德县，东北与同仁接壤。",
				"2018-6-12",
				R.drawable.one23));
		hkitemList.add(new HKitem("青海：建立藏羊高效繁育与产品追溯体系",
				"近日，从青海省科技厅组织的藏羊高效繁育与产品追溯体系观摩会上传出消息，该省已建立藏羊高效繁育与产品追溯体系。\n",
				"2015-7-31",
				R.drawable.one24));
		hkitemList.add(new HKitem("青海海北州首批牦牛藏羊抵阳信 \"千牛万羊\"进山东",
				"经过40多个小时近2200多公里的长途跋涉,100头牦牛、1000只藏羊从青海海北州祁连县启程,11月7日早晨乘长途车到达阳信县借剑牛业公司,拉开了海北州“千牛万羊”进山东的帷幕。",
				"2016-11-10",
				R.drawable.one25));
		hkitemList.add(new HKitem("青海畜牧业重大突破：藏羊“两年三胎”通过验收",
				"“这是一次理论创新、实践创新的历史性突破，青海草原将由此揭开现代生态畜牧业高层次发展新篇章。”这是连日来省内外专家验收通过海北藏系羊“两年三胎”高效养殖试验推广项目，给予的高度评价。",
				"2014-10-21",
				R.drawable.one26));
		hkitemList.add(new HKitem("青海高寒草地放牧藏羊高效养殖综合配套技术示范与推广效果明显",
				"12月8日,青海省科技厅组织专家对青海大学承担的”2014年2015年高寒草地放牧藏羊高效养殖综合配套技术示范与推广”项目通过了科技成果评价,成果达到国际先进水平。",
				"2015-12-30",
				R.drawable.one27));
		hkitemList.add(new HKitem("刚察县藏羊外寄生虫防治工作顺利完成",
				"8月14日至9月14日，刚察县农牧局组织全县五乡镇兽医站开展了为期一个月的藏羊药浴工作。期间，共药浴藏羊478000多只,药浴率达到95℅以上，药浴后杀虫效果明显, 未出现羊只中毒症状。",
				"2015-9-22",
				R.drawable.one28));
		hkitemList.add(new HKitem("藏羊：积极融入“一带一路”建设",
				"“在这样一个特殊的经济背景下，今年的‘藏毯展’势必是提振企业信心，促进藏毯产业崛起的展会！”",
				"2015-6-27",
				R.drawable.one29));
	}

}
