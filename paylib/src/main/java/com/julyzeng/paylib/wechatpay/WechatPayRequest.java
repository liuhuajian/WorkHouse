package com.julyzeng.paylib.wechatpay;

import android.content.Context;
import android.widget.Toast;

import com.julyzeng.paylib.R;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * 项目：原产地
 * 作    者：julyzeng （曾招林)  364298140@qq.com
 * 版    本：1.0
 * 创建日期：2017/7/13 14:49
 * 描    述：微信支付的支付请求处理类。
 * 修订历史：
 */

public class WechatPayRequest {


    /**
     *
     * @param context
     * @param wechatPayBean  微信支付的实体参数类
     */
    public void payRequest(Context context, WechatPayBean wechatPayBean) {
        PayReq req;
        IWXAPI msgApi;
        msgApi = WXAPIFactory.createWXAPI(context, wechatPayBean.appid,true);
        if (msgApi.isWXAppInstalled() && msgApi.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT) {
            req = new PayReq();
            req.appId = wechatPayBean.appid;
            req.partnerId = wechatPayBean.partnerid;
            req.prepayId = wechatPayBean.prepayid;
            req.packageValue = wechatPayBean.pay_package;
            req.nonceStr = wechatPayBean.noncestr;
            req.timeStamp = wechatPayBean.timestamp;
            req.sign = wechatPayBean.sign;
            msgApi.registerApp(wechatPayBean.appid);
            msgApi.sendReq(req);
        } else {
            Toast.makeText(context,context.getResources().getString(R.string.install_support),Toast.LENGTH_LONG).show();
        }

    }

}
