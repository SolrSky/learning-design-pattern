package com.carlos.strategy.payment;

import com.carlos.strategy.PayState;

/**
 * @author Solrsky
 * @date 2019/1/4
 */
public interface Payment {

    public PayState payment(String uid, Double amount);

}
