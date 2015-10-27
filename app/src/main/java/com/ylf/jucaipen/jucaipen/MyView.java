package com.ylf.jucaipen.jucaipen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.ylf.jucaipen.jucaipen.com.ylf.jucaipen.jucaipen.observer.LoadView;

/**
 * Created by Administrator on 2015/10/26.
 */
public class MyView extends Activity {
    @ViewInject(R.id.share)
    private LoadView share;
    @ViewInject(R.id.et_share)
    private EditText et_share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_myview);
        ViewUtils.inject(this);
    }

    @OnClick(R.id.share)
    public void onShare(View view){
        String shareStr=et_share.getText().toString().trim();
        if(shareStr.length()>0) {
            Intent share = new Intent();
            share.setAction(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_SUBJECT, "share");
            share.putExtra(Intent.EXTRA_TEXT, shareStr);
            startActivity(Intent.createChooser(share, "分享到.."));
        }else {
            Toast.makeText(this,"分享内容不能为空",Toast.LENGTH_LONG).show();
        }

    }
}
