package com.ysl.hekafarm;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class New1PagerAdapter extends FragmentPagerAdapter {

	private ArrayList<String> titleList;
	private ArrayList<Fragment> fragmentsList;

	public New1PagerAdapter(FragmentManager fm, ArrayList<String> titleList, ArrayList<Fragment> fragmentsList){
		super(fm);
		this.titleList = titleList;
		this.fragmentsList = fragmentsList;
	}

	@Override
	public Fragment getItem(int position) {
		return fragmentsList.get(position);
	}

	@Override
	public int getCount() {
		return fragmentsList.size();
	}

	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		return titleList.get(position);
	}
}
