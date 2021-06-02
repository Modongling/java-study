package com.my.study.dsl;

import com.my.study.dsl.entity.Order;
import com.my.study.dsl.entity.Trade;

import java.util.function.DoubleUnaryOperator;

/**
 * @author mdl
 * @Created 2021/6/2 21:25
 * @Description
 */
public class TaxCalculatorLambda {
   public DoubleUnaryOperator taxFunction = d -> d;

   public TaxCalculatorLambda with(DoubleUnaryOperator f) {
       taxFunction = taxFunction.andThen(f);
       return this;
   }

   public double calculate(Order order) {
       return taxFunction.applyAsDouble(order.getValue());
   }

    public static void main(String[] args) {
        Order order = new Order();
        Trade trade = new Trade();
        trade.setPrice(123.00D);
        order.setCustomer("A");
        order.addTrade(trade);
       double value = new TaxCalculatorLambda().with(Tax::regional).with(Tax::general).with(Tax::surcharge).calculate(order);
    }
}
