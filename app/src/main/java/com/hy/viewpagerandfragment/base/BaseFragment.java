package com.hy.viewpagerandfragment.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public abstract class BaseFragment extends Fragment{
	public Context ctx;
	private View mView;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData(savedInstanceState);
	}

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		ctx=getActivity();
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView=initView(inflater);
	    
		return mView;
	}
	public View getRootView(){
		return mView;
	}
	/**
	 * 初始化界面
	 * */
	
	public abstract View initView(LayoutInflater inflater);
    /**
     * 初始化数据
     */
	public abstract void initData(Bundle savedInstanceState);


}
