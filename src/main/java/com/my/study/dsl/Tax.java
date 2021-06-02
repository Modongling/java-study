package com.my.study.dsl;

import com.my.study.dsl.entity.Order;

/**
 * @author mdl
 * @Created 2021/6/2 21:00
 * @Description
 */
public class Tax {
    public static double regional(double value) {
        return value * 1.1;
    }

    public static double general(double value) {
        return value * 1.3;
    }

    public static double surcharge(double value) {
        return value * 1.05;
    }

    public static double calculate(Order order, boolean useRegional, boolean useGeneral, boolean useSurcharge) {
        double value = order.getValue();
        if (useGeneral) {
            value = general(value);
        }

        if (useRegional) {
            value = regional(value);
        }

        if (useSurcharge) {
            value = surcharge(value);
        }

        return value;
    }
}
