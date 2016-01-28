package com.hy.viewpagerandfragment.adapter;

import java.util.List;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.hy.viewpagerandfragment.base.BaseFragment;

public class MyViewPagerAdapter extends PagerAdapter {
	private List<BaseFragment> list;
	

	public MyViewPagerAdapter(FragmentManager fm,List<BaseFragment> list) {
		super();
		this.list = list;
		
	}

	@Override
	public int getCount() {

		return list.size();
	}

//	public Fragment getItem(int arg0) {
//		return list.get(arg0);
//	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		/*  java.lang.IllegalArgumentException: Cannot add a null child view to a ViewGroup
		at android.view.ViewGroup.addView(ViewGroup.java:3719)
		at android.view.ViewGroup.addView(ViewGroup.java:3701)
		at com.hy.viewpagerandfragment.adapter.MyViewPagerAdapter.instantiateItem(MyViewPagerAdapter.java:36)
		*/
		// fixme 在运行到此方法时，fragment还未经过onCreateView，所以此处的rootView是null 针对fragment的adapter google 提供了专用的FragmentPagerAdapter等

		((ViewPager)container).addView(list.get(position).getRootView());
		return list.get(position).getRootView();
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager)container).removeView(list.get(position).getRootView());
//		super.destroyItem(container, position, object);
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {

		return arg0==arg1;
	}

}
