package com.ysl.hekafarm;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loopeer.cardstack.CardStackView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment {

	private RecyclerView recyclerView;
	private DjAdapter adapter;
	private List<HKitem> hkitemList = new ArrayList<>();

	public CFragment() {
		// Required empty public constructor
	}

	public static CFragment newInstance(String title){
		CFragment fragment = new CFragment();
		Bundle bundle = new Bundle();
		bundle.putString("title",title);
		fragment.setArguments(bundle);
		return fragment;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =  inflater.inflate(R.layout.fragment_c, container, false);
		return view;
	}



	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initItems();
		//recyclerview的初始化
		recyclerView = (RecyclerView)view.findViewById(R.id.rv_c);
		LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
		adapter = new DjAdapter(hkitemList);
		recyclerView.setAdapter(adapter);
	}

	private void initItems(){
		hkitemList.add(new HKitem("精准扶贫",
				"扶贫开发工作会议的召开以及措施，种羊场17年所做工作",
				"2018-9-1",
				R.drawable.dj1));
		hkitemList.add(new HKitem("领导关怀",
				"领导视察示范田的工作，对群众开展走访慰问活动",
				"2018-9-1",
				R.drawable.dj2));
		hkitemList.add(new HKitem("文体活动",
				"开展多项文体活动，场领导与普通职工同台竞技",
				"2018-9-1",
				R.drawable.dj3));
		hkitemList.add(new HKitem("组织学习",
				"进行党章学习，集中学习讲话精神，草原课堂-政策宣讲",
				"2018-9-1",
				R.drawable.dj4));
		hkitemList.add(new HKitem("成果展示",
				"促进民族团结，表彰先进职员，村社送来锦旗，喜评先进组织",
				"2018-9-1",
				R.drawable.dj5));
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

}
