package com.carlos.proxy.cglib;

/**
 * @author Solrsky
 * @date 2018/12/18
 */
public class CGLibTest {
    public static void main(String[] args) throws Exception {
        XiaoHong obj = (XiaoHong) new CGLibMeiPo().getInstance(XiaoHong.class);
        obj.findLove();
        System.out.println(obj);
    }
}
