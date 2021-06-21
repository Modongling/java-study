package com.my.study.oop.mathes;

import java.math.BigDecimal;

public class BigDecimalTest {
    //解决浮点数精度问题
    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal("0.05");
        BigDecimal d2 = new BigDecimal("0.01");
        System.out.println(d1.add(d2).doubleValue());
        /**
         * subtract()
         * multiply()
         * divide()
         */
        BigDecimal d3 = new BigDecimal("0.1");
        //10精度,四舍五入
        System.out.println(d1.divide(d3, 10, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}
