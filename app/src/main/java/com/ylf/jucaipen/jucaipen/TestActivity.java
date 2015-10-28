package com.ylf.jucaipen.jucaipen;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by Administrator on 2015/10/28.
 *
 *    ASD(Android Support Design) 使用
 */
public class TestActivity extends Activity {
    @ViewInject(R.id.tl)
    private TabLayout t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_test);
        ViewUtils.inject(this);
        initView();
    }

    private void initView() {

   for(int i=0;i<20;i++){
       t1.addTab(t1.newTab().setText("TAG"+i));
   }
        t1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                    Toast.makeText(TestActivity.this,"click："+tab.getText(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });













    }

    public void click(View view){
        Snackbar.make(view,"大脸上了凤姐",Snackbar.LENGTH_INDEFINITE).setAction("真滴", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this,"大脸色眯眯，凤姐淫荡荡",Toast.LENGTH_LONG).show();
            }
        }).show();
    }
}
