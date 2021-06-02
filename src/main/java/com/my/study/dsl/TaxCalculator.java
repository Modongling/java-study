package com.my.study.dsl;

import com.my.study.dsl.entity.Order;
import com.my.study.dsl.entity.Trade;

/**
 * @author mdl
 * @Created 2021/6/2 21:25
 * @Description
 */
public class TaxCalculator {
    private Boolean useRegional;
    private Boolean useGeneral;
    private Boolean userSurcharge;

    public TaxCalculator withRegional() {
        useRegional = true;
        return this;
    }

    public TaxCalculator withGeneral() {
        useGeneral = true;
        return this;
    }

    public TaxCalculator withSurcharge() {
        userSurcharge = true;
        return this;
    }

    public double calculate(Order order) {
        return Tax.calculate(order, useRegional, useGeneral, userSurcharge);
    }

    public static void main(String[] args) {
        Order order = new Order();
        Trade trade = new Trade();
        trade.setPrice(123.00D);
        order.setCustomer("A");
        order.addTrade(trade);
        double value = new TaxCalculator().withRegional().withSurcharge().calculate(order);
    }
}
