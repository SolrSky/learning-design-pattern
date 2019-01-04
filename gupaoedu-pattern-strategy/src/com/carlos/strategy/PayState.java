package com.carlos.strategy;

/**
 * @author Solrsky
 * @date 2019/1/4
 */
public class PayState {

    private int code;
    private String Msg;
    private Object data;

    public PayState(int code, String msg, Object data) {
        this.code = code;
        Msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "支付完成：【" + this.code + "】";
    }
}
