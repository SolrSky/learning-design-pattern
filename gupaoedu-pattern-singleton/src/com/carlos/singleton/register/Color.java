package com.carlos.singleton.register;

/**
 * @author Solrsky
 * @date 2018/11/29
 */
// 一般用于枚举常量
    // 一般在通用API中使用
public enum Color {
    RED(){
        private int r = 255;
        private int g = 0;
        private int b = 0;
    },
    Black(){
        private int r = 255;
        private int g = 255;
        private int b = 255;
    }
}
