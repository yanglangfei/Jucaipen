package com.ylf.jucaipen.jucaipen.com.ylf.jucaipen.jucaipen.observer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.ylf.jucaipen.jucaipen.R;

/**
 * Created by Administrator on 2015/10/26.
 */
public class AskFanousTeacher extends Activity {
    @ViewInject(R.id.ask_type)
    private Spinner ask_type;
    private  String []type={"请选择问题分类","A股","期货","基金","黄金外汇","美股","港股","保险","其他理财"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_ask);
        ViewUtils.inject(this);
        initView();
    }

    private void initView() {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,type);
        ask_type.setAdapter(adapter);

    }
}
