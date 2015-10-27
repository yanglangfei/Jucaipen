package com.ylf.jucaipen.jucaipen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/10/27.
 */
public class LiveAdapter  extends FragmentPagerAdapter{
    private  List<Fragment> fragment;

    public LiveAdapter(FragmentManager fm) {
        super(fm);
    }

    public LiveAdapter(FragmentManager supportFragmentManager, List<Fragment> fragments) {
        super(supportFragmentManager);
        this.fragment=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }
}
