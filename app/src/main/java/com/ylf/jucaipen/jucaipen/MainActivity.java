package com.ylf.jucaipen.jucaipen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MainActivity extends Activity {
    @ViewInject(R.id.btn_sigin)
    private Button btn_sigin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        initView();
    }

    @OnClick(R.id.btn_sigin)
    public void onSigin(View view){
        Intent checkCode=new Intent();
        checkCode.setClass(this,CheckCodeActivity.class);
        startActivity(checkCode);
    }
    private void initView() {
    }

}
