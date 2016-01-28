package com.hy.viewpagerandfragment.adapter;

import java.util.List;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.View;

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

	public Fragment getItem(int arg0) {
		return list.get(arg0);
	}
//	@Override
//	public Object instantiateItem(ViewGroup container, int position) {
//
//		container.addView(list.get(position).getRootView(), 0);
//		return list.get(position).getRootView();
//	}
//	@Override
//	public void destroyItem(ViewGroup container, int position, Object object) {
//		container.removeView(list.get(position).getRootView());
////		super.destroyItem(container, position, object);
//	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		
		return arg0==arg1;
	}

}
