package com.carlos.strategy.payment;

import com.carlos.strategy.PayState;

/**
 * @author Solrsky
 * @date 2019/1/4
 */
public class AliPay implements Payment{

    @Override
    public PayState payment(String uid, Double amount) {
        System.out.println("开始跳转支付宝支付");
        System.out.println("支付中...");
        System.out.println("支付完成");
        return new PayState(200, "支付完成", amount);
    }
}
