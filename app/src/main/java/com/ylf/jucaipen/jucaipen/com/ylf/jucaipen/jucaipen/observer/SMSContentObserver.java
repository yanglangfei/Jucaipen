package com.ylf.jucaipen.jucaipen.com.ylf.jucaipen.jucaipen.observer;

import android.app.Activity;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/10/26.
 *
 *  短信监听器，用户自动填充验证码
 */
public class SMSContentObserver extends ContentObserver {
    public final String SMS_URI_INBOX = "content://sms/inbox";//收信箱
    private Activity activity = null;
    private String smsContent = "";//验证码
    private EditText verifyText = null;//验证码编辑框
    private String SMS_ADDRESS_PRNUMBER = "10690233107026313";//短息发送提供商
    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public SMSContentObserver(Activity activity, Handler handler, EditText verifyText) {
        super(handler);
        this.activity=activity;
        this.verifyText=verifyText;
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        Cursor cursor=null;
        // 读取收件箱中指定号码的短信
        cursor=activity.getContentResolver().query(Uri.parse(SMS_URI_INBOX),new String[]{"_id", "address", "body", "read"}, //要读取的属性
                "address=? and read=?" //查询条件
               , new String[]{SMS_ADDRESS_PRNUMBER, "0"}, //查询条件赋值
                "date desc");
        if(cursor!=null){
            cursor.moveToFirst();
            if(cursor.moveToFirst()){
                String smsbody = cursor.getString(cursor.getColumnIndex("body"));
                //用正则表达式匹配验证码
                Pattern pattern = Pattern.compile("[0-9]{4}");
                Matcher matcher = pattern.matcher(smsbody);
                if(matcher.find()){
                    //验证码匹配
                    smsContent = matcher.group();//获取匹配文本，即验证码
                    if (verifyText != null && null != smsContent && !"".equals(smsContent)) {
                        verifyText.requestFocus();//获取焦点
                        verifyText.setText(smsContent);//设置文本
                        verifyText.setSelection(smsContent.length());//设置光标位置
                    }

                }
            }
        }
    }

}
