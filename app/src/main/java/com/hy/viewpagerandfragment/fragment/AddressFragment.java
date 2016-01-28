package com.hy.viewpagerandfragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.viewpagerandfragment.R;
import com.hy.viewpagerandfragment.base.BaseFragment;

public class AddressFragment extends BaseFragment{

	@Override
	public View initView(LayoutInflater inflater) {
		View view=inflater.inflate(R.layout.fragment_address, null);
		return view;
	}

	@Override
	public void initData(Bundle savedInstanceState) {

		
	}

}
