package com.julyzeng.paylib.wechatpay;


/**
 * 项目：国民健康
 *
 * @Creator:曾招林julyzeng
 * @创建日期： 2018/6/21 9:13
 * @版本1.0
 * @类说明：微信支付结果返回
 */

public interface WechatPayResultBack {

    void paySucess();//支付成功回调
    void payFail();//支付失败回调
    void payCancel();//支付取消回调
}
