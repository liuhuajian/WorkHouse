package com.julyzeng.paylib;

import android.app.Activity;
import android.os.Handler;

import com.julyzeng.paylib.alipay.AlipayRequest;
import com.julyzeng.paylib.unionpay.UnionpayRequest;
import com.julyzeng.paylib.wechatpay.WechatPayBean;
import com.julyzeng.paylib.wechatpay.WechatPayRequest;

/**
 * 项目：原产地
 * 作    者：julyzeng （曾招林)  364298140@qq.com
 * 版    本：1.0
 * 创建日期：2017/7/13 16:42
 * 描    述：统一处理不同方式的支付请求
 * 修订历史：
 */

public class PayLibRequest {

    private static volatile PayLibRequest instance;

    private PayLibRequest(){}

    public static PayLibRequest getInstance(){

        if (instance ==null){
            synchronized(PayLibRequest.class){
                if (instance == null) {
                    instance = new PayLibRequest();
                }
            }
        }
        return instance;
    }

    /**
     * 对接不同的支付请求统一封装
     * @param activity
     * @param payment :1 支付宝、2 微信、3 银联
     * @param orderInfo 支付宝orderinfo表示订单信息串,银联代表TN，微信用wechatPayBean
     */
    public void payRequest(Activity activity, int payment, String orderInfo, WechatPayBean wechatPayBean, Handler mHandler){

        if (PayContants.PAY_SDK_PAYMENT_ALIPAY == payment){//支付宝
           new  AlipayRequest().payRequest(activity,orderInfo,mHandler);
        }else if(PayContants.PAY_SDK_PAYMENT_WECHAT == payment){//微信
           new WechatPayRequest().payRequest(activity,wechatPayBean);
        }else if(PayContants.PAY_SDK_PAYMENT_UNIONPAY == payment){//银联
           new UnionpayRequest().pay(activity,orderInfo,"00");
        }

    }

}
