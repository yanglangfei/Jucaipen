package com.ylf.jucaipen.jucaipen;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/27.
 */
public class LiveRoom extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    @ViewInject(R.id.live_vp)
    private ViewPager live_vp;
    @ViewInject(R.id.rb_todayIdea)
    private RadioButton todayIdea;
    private List<Fragment> fragments=new ArrayList<Fragment>();
    private  LiveAdapter adapter;
    private  TodayIdeaFragment todayIdeaFragment;
    private  CommuniteFragment commFragment;
    @ViewInject(R.id.rb_live)
    private RadioGroup rb_live;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_liveroom);
        ViewUtils.inject(this);
        initView();
        initData();
    }

    private void initData() {
        todayIdeaFragment=new TodayIdeaFragment();
        commFragment=new CommuniteFragment();
        fragments.add(todayIdeaFragment);
        fragments.add(commFragment);
        adapter.notifyDataSetChanged();;
    }

    private void initView() {
        adapter=new LiveAdapter(getSupportFragmentManager(),fragments);
        live_vp.setAdapter(adapter);
        rb_live.setOnCheckedChangeListener(this);
        todayIdea.setChecked(true);
        live_vp.setOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_todayIdea:
                live_vp.setCurrentItem(0);
                break;
            case R.id.rb_communite:
                live_vp.setCurrentItem(1);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        RadioButton rb= (RadioButton) rb_live.getChildAt(position);
        rb.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
