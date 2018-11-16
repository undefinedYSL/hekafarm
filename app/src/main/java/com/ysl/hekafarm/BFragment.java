package com.ysl.hekafarm;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.ysl.hekafarm.BitemAdapter.axiba;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment implements ViewPager.OnPageChangeListener {

	ArrayList<String> titlelist;
	ArrayList<Fragment> fragmentslist;
	private ViewPager vp;
	private BitemAdapter adapter;

	public BFragment() {
		// Required empty public constructor
	}

	public static BFragment newInstance(String title){
		BFragment fragment = new BFragment();
		Bundle bundle = new Bundle();
		bundle.putString("title",title);
		fragment.setArguments(bundle);
		return fragment;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =  inflater.inflate(R.layout.fragment_b, container, false);

		return view;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		titlelist = new ArrayList<>();
		titlelist.add("河卡种羊场");
		titlelist.add("河卡育羊");
		titlelist.add("自然环境");
		fragmentslist = new ArrayList<>();
		fragmentslist.add(new B1Fragment());
		fragmentslist.add(new B2Fragment());
		fragmentslist.add(new B3Fragment());
		NewPagerAdapter newPagerAdapter = new NewPagerAdapter(getFragmentManager(),titlelist,fragmentslist);
		vp = (ViewPager)view.findViewById(R.id.vp_b);
		TabLayout tl = (TabLayout)view.findViewById(R.id.tl_b);
		vp.setAdapter(newPagerAdapter);
		vp.addOnPageChangeListener(this);
		tl.setupWithViewPager(vp);
		tl.setTabsFromPagerAdapter(newPagerAdapter);
		adapter =new BitemAdapter();
		adapter.setFlag(0);
		axiba = 0;
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
	public void onPageScrolled(int i, float v, int i1) {

	}

	@Override
	public void onPageSelected(int position) {
		switch (position){
			case 0:
//				adapter.setFlag(0);
				axiba = 0;
				break;
			case 1:
//				adapter.setFlag(1);
				axiba = 1;
				break;
			case 2:
//				adapter.setFlag(2);
				axiba = 2;
				break;
		}
	}

	@Override
	public void onPageScrollStateChanged(int i) {

	}
}
