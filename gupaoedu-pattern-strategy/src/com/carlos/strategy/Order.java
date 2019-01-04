package com.carlos.strategy;

import com.carlos.strategy.payment.PayType;
import com.carlos.strategy.payment.Payment;

/**
 * 订单类
 * @author Solrsky
 * @date 2019/1/4
 */
public class Order {

    private String uid;
    private String orderId;
    private Double amount;

    public Order(String uid, String orderId, Double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PayState pay(PayType payType){
        return payType.get().payment(this.uid, this.amount);
    }
}
