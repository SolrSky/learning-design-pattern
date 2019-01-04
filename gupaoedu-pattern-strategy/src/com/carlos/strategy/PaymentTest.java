package com.carlos.strategy;

import com.carlos.strategy.payment.AliPay;
import com.carlos.strategy.payment.PayType;

/**
 * @author Solrsky
 * @date 2019/1/4
 */
public class PaymentTest {

    public static void main(String[] args) {
        Order order  = new Order("1", "2019010112060001", 333.32);

        order.pay(PayType.ALI_PAY);
    }
}
