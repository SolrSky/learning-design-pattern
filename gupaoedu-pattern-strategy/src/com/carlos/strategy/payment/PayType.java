package com.carlos.strategy.payment;

/**
 * @author Solrsky
 * @date 2019/1/4
 */
public enum PayType {

    ALI_PAY(new AliPay()),
    WECHAT_PAY(new WechatPay());

    private Payment payment;

    PayType(Payment payment){
        this.payment = payment;
    }

    public Payment get(){
        return this.payment;
    }

}
