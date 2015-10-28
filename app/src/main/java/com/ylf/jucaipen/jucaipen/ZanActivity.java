package com.ylf.jucaipen.jucaipen;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.ylf.utils.JumpingBeans;
/**
 * Created by Administrator on 2015/10/27.
 */
public class ZanActivity extends AppCompatActivity {
    @ViewInject(R.id.bt_zan)
    private Button bt_zan;
    @ViewInject(R.id.tv_zan)
    private TextView tv_zan;
    private Animation animation;
    private JumpingBeans beans;
    private TextView tipTextView;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_zan);
        ViewUtils.inject(this);
        initView();
    }

    @OnClick(R.id.bt_zan)
    public void onZan(View view){
    if(bt_zan!=null){
        tv_zan.setVisibility(View.VISIBLE);
        tv_zan.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            tv_zan.setVisibility(View.GONE);
            }
        },1000);
    }
    }

    private void initView() {
        animation= AnimationUtils.loadAnimation(this, R.anim.move);
        Dialog dialog=createLoadingDialog(this,"请稍候");
        beans=JumpingBeans.with(tipTextView).appendJumpingDots().build();
        dialog.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        beans.stopJumping();
    }

    /**
     * 得到自定义的progressDialog
     * @param context
     * @param msg
     * @return
     */
    public  Dialog createLoadingDialog(Context context, String msg) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.ui_dialog, null);// 得到加载view
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
        // main.xml中的ImageView
        ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
        tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
        // 加载动画
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                context, R.anim.progress_bar);
        LinearInterpolator interpolator=new LinearInterpolator();
        hyperspaceJumpAnimation.setInterpolator(interpolator);
        // 使用ImageView显示动画
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
        tipTextView.setText(msg);// 设置加载信息

        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
        loadingDialog.setCancelable(false);// 不可以用“返回键”取消
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT));// 设置布局
        return loadingDialog;
    }

    public  void theam(){

    }

}
