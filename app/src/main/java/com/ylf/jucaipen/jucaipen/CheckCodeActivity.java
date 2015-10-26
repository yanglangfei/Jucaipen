package com.ylf.jucaipen.jucaipen;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.ylf.jucaipen.jucaipen.com.ylf.jucaipen.jucaipen.observer.SMSContentObserver;

/**
 * Created by Administrator on 2015/10/26.
 *
 *     手机验证
 */
public class CheckCodeActivity extends Activity {
    private  static final String GET_CODE="http://121.40.227.121:8080/AccumulateWealth/jucaipen/chekMobileCode?telPhone=";
    @ViewInject(R.id.btn_check)
    private Button btn_check;
    @ViewInject(R.id.telPhone)
    private EditText telPhone;
    @ViewInject(R.id.inputCode)
    private  EditText inputCode;
    private SMSContentObserver observer;
    private CountDownTimer timer=new CountDownTimer(1000*60,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            btn_check.setEnabled(false);
            btn_check.setText((millisUntilFinished / 1000) + "秒后可重发");
        }

        @Override
        public void onFinish() {
            btn_check.setEnabled(true);
            btn_check.setText("获取验证码");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_check_code);
        ViewUtils.inject(this);
        initView();
    }

    @OnClick(R.id.btn_check)
   public void  onCheck(View view){
        String telStr=telPhone.getText().toString().trim();
        if(telStr.length()>0){
           // new GetMobileCode().execute(telStr);
            //实例化短信监听器
            GetMobileCode(telStr);
            timer.start();
        }else {
            Toast.makeText(this,"手机号不能为空",Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        observer=new SMSContentObserver(this,new Handler(),inputCode);
        getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, observer);

    }

    public void GetMobileCode(String tel){
        HttpUtils utils=new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, GET_CODE+tel, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
            }

            @Override
            public void onFailure(HttpException e, String s) {
            }

            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                super.onLoading(total, current, isUploading);
            }

            @Override
            public void onStart() {
                super.onStart();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getContentResolver().unregisterContentObserver(observer);
    }
}
