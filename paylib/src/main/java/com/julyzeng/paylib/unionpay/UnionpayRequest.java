package com.julyzeng.paylib.unionpay;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

/**
 * 项目：原产地
 * 作    者：julyzeng （曾招林)  364298140@qq.com
 * 版    本：1.0
 * 创建日期：2017/7/13 15:31
 * 描    述：银联支付请求
 * 修订历史：
 */

public class UnionpayRequest {

    // 00 正式  01测试
    public static final String mMode = "00";
    /**
     * 获取tn号之后   调用此方法
     * @param activity 上下文
     * @param tn  流水号
     * @param mode  mMode参数解释： "00" - 启动银联正式环境 "01" - 连接银联测试环境
     */
    public  void pay(final Context activity, String tn, String mode) {
//        if(!UPPayAssistEx.checkInstalled(activity))
//        {
            // 需要重新安装控件
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("提示");
            builder.setMessage("完成购买需要安装银联支付控件，是否安装？");

            builder.setNegativeButton("确定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            UPPayAssistEx.installUPPayPlugin(activity);
                            dialog.dismiss();
                        }
                    });

            builder.setPositiveButton("取消",
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            builder.create().show();

//        }
//        else{
//            UPPayAssistEx.startPay(activity, null, null, tn, mode);
//        }
    }


    /*
     * 支付回调接口    在activity的 onActivityResult(int requestCode, int resultCode, Intent data)调用
     * @param data
     */
    public static  void payResult(Intent data, UnionResult result) {
        if (data == null) {
            return;
        }
        String str = data.getExtras().getString("pay_result");
        if (str.equalsIgnoreCase("success")) {
            if(result!=null){
                result.onSuccess();
            }
        } else if (str.equalsIgnoreCase("fail")) {
            if(result!=null){
                result.onFail();
            }
        } else if (str.equalsIgnoreCase("cancel")) {
            if(result!=null){
                result.onCancel();
            }
        }
    }


    /**
     * 银联结果回调
     */
    public interface   UnionResult{
        /**
         * 成功回调
         */
        void   onSuccess();

        /**
         * 失败回调
         */
        void   onFail();

        /**
         * 取消回调
         */
        void   onCancel();
    }

}
