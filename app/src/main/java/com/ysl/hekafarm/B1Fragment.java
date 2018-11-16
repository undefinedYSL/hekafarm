package com.ysl.hekafarm;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class B1Fragment extends Fragment {

	private RecyclerView recyclerView;
	private BitemAdapter adapter;
	private List<HKitem> bitemList = new ArrayList<>();

	public B1Fragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_b1, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initItems();
		//recyclerview的初始化
		recyclerView = (RecyclerView)view.findViewById(R.id.rv_b1);
		LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
		adapter = new BitemAdapter(bitemList);
		recyclerView.setAdapter(adapter);

	}

	private void initItems() {
		bitemList.clear();
		bitemList.add(new HKitem("河卡种羊场", R.drawable.b1_show1));
		bitemList.add(new HKitem("企业文化建设", R.drawable.b1_show2));
		bitemList.add(new HKitem("产业发展", R.drawable.b1_show3));
		bitemList.add(new HKitem("推广培训", R.drawable.gmh));
	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		if (hidden){
			return;
		}else {
			adapter.setFlag(0);
		}
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
