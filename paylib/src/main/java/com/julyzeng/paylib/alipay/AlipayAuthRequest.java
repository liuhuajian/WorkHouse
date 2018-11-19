package com.julyzeng.paylib.alipay;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import com.alipay.sdk.app.AuthTask;

import java.util.Map;

/**
 * 项目：原产地
 * 作    者：julyzeng （曾招林)  364298140@qq.com
 * 版    本：1.0
 * 创建日期：2017/7/13 14:27
 * 描    述：支付宝的登录授权请求。
 * 修订历史：
 */

public class AlipayAuthRequest {

    public static final int SDK_AUTH_FLAG = 3;

    /**
     *
     * @param context
     * @param authInfo
     * @param mHandler
     */
    public static  void authRequest(final Activity context, final String authInfo, final Handler mHandler){
        Runnable authRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造AuthTask 对象
                AuthTask authTask = new AuthTask(context);
                // 调用授权接口，获取授权结果
                Map<String, String> result = authTask.authV2(authInfo, true);

                Message msg = new Message();
                msg.what = SDK_AUTH_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread authThread = new Thread(authRunnable);
        authThread.start();
    }
}
