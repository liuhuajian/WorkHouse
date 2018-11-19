package com.julyzeng.paylib.alipay;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import com.alipay.sdk.app.PayTask;

import java.util.Map;

/**
 * 项目：原产地
 * 作    者：julyzeng （曾招林)  364298140@qq.com
 * 版    本：1.0
 * 创建日期：2017/7/13 14:03
 * 描    述：支付宝支付的请求。
 * 修订历史：
 */

public class AlipayRequest {

    public static final int SDK_PAY_FLAG = 900;

    /**
     *
     * @param context  Activity上下文
     * @param orderInfo  加密加签名后台订单字符串 必须来自服务端 以防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
     * @param mHandler 接收返回结果。
     */
    public void payRequest(final Activity context, final String orderInfo, final Handler mHandler) {

        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(context);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}
