package com.julyzeng.paylib.wechatpay;

import java.io.Serializable;


/**
 * 微信支付数据包
 * @Copyright: july
 */
public class WechatPayBean implements Serializable {
	

	/** 变量描述 */
	private static final long serialVersionUID = -2877360699066789483L;
	
		/** appid */
		public String appid;
		/** 商户id */
		public String partnerid;
		/** 订单id */
		public String prepayid;
		/** packge包 */
		public String pay_package;
		/** 随机字符串 */
		public String noncestr;
		/** 时间戳 */
		public String timestamp;
		/** 订单签名 */
		public String sign;
		/**订单交易号*/
//		public String outTradeNo;
		/**订单号*/
		public String paymentNo;
		/**类型 区别充值  和  普通的付款回调*/
//		public String type;
}
