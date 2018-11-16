package com.ysl.hekafarm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class A42Fragment extends Fragment {


	public A42Fragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =  inflater.inflate(R.layout.fragment_a42, container, false);
		initview(view);
		return view;
	}

	private void initview(View view) {

	}

}
