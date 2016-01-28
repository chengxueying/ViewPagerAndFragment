package com.hy.viewpagerandfragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.viewpagerandfragment.R;
import com.hy.viewpagerandfragment.adapter.MyViewPagerAdapter;
import com.hy.viewpagerandfragment.base.BaseFragment;
import com.hy.viewpagerandfragment.fragment.AddressFragment;
import com.hy.viewpagerandfragment.fragment.FriendFragment;
import com.hy.viewpagerandfragment.fragment.SettingFragment;
import com.hy.viewpagerandfragment.fragment.WeiFragment;

@SuppressLint("CutPasteId")
public class MainActivity extends Activity implements OnClickListener {
	private ViewPager mViewPager;
	private List<BaseFragment> list;
	private Context mContext;

	private LinearLayout mTabBtnWeixin;
	private LinearLayout mTabBtnFrd;
	private LinearLayout mTabBtnAddress;
	private LinearLayout mTabBtnSettings;

	private ImageButton mImageWeixin;
	private ImageButton mImageFrd;
	private ImageButton mImageAddress;
	private ImageButton mImageSettings;



	FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		mContext = this;
		list = new ArrayList<BaseFragment>();
		list.add(new WeiFragment());
		list.add(new FriendFragment());
		list.add(new AddressFragment());
		list.add(new SettingFragment());
		initView();


	}

	@SuppressWarnings("deprecation")
	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mTabBtnWeixin = (LinearLayout) findViewById(R.id.id_tab_bottom_weixin);
		mTabBtnFrd = (LinearLayout) findViewById(R.id.id_tab_bottom_friend);
		mTabBtnAddress = (LinearLayout) findViewById(R.id.id_tab_bottom_contact);
		mTabBtnSettings = (LinearLayout) findViewById(R.id.id_tab_bottom_setting);
		mImageWeixin = (ImageButton) findViewById(R.id.btn_tab_bottom_weixin);
		mImageFrd = (ImageButton) findViewById(R.id.btn_tab_bottom_friend);
		mImageAddress = (ImageButton) findViewById(R.id.btn_tab_bottom_contact);
		mImageSettings = (ImageButton) findViewById(R.id.btn_tab_bottom_setting);
		mTabBtnWeixin.setOnClickListener(this);
		mTabBtnFrd.setOnClickListener(this);
		mTabBtnAddress.setOnClickListener(this);
		mTabBtnSettings.setOnClickListener(this);
		MyViewPagerAdapter adapter = new MyViewPagerAdapter(
				getFragmentManager(), list);
		mViewPager.setAdapter(adapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				setTabSelection(arg0);

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {


			}

			@Override
			public void onPageScrollStateChanged(int arg0) {


			}
		});
		setTabSelection(0);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_tab_bottom_weixin:
			setTabSelection(0);
			mViewPager.setCurrentItem(0);
			break;
		case R.id.id_tab_bottom_friend:
			setTabSelection(1);
			mViewPager.setCurrentItem(1);
			break;
		case R.id.id_tab_bottom_contact:
			setTabSelection(2);
			mViewPager.setCurrentItem(2);
			break;
		case R.id.id_tab_bottom_setting:
			setTabSelection(3);
			mViewPager.setCurrentItem(3);
			break;
		}

	}

	private void setTabSelection(int i) {
		clearBtn();
		switch (i) {

		case 0:
			mImageWeixin.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case 1:
			mImageFrd.setImageResource(R.drawable.tab_find_frd_pressed);

			break;
		case 2:
			mImageAddress.setImageResource(R.drawable.tab_address_pressed);
			break;
		case 3:
			mImageSettings.setImageResource(R.drawable.tab_settings_pressed);
			break;
		}

	}

	private void clearBtn() {
		mImageWeixin.setImageResource(R.drawable.tab_weixin_normal);
		mImageFrd.setImageResource(R.drawable.tab_find_frd_normal);
		mImageAddress.setImageResource(R.drawable.tab_address_normal);
		mImageSettings.setImageResource(R.drawable.tab_settings_normal);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
