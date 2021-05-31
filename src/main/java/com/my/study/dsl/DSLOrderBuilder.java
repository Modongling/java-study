package com.my.study.dsl;

import com.my.study.dsl.entity.Order;
import com.my.study.dsl.entity.Trade;

public class DSLOrderBuilder {
    public final Order order = new Order();

    private DSLOrderBuilder(String customer) {
        order.setCustomer(customer);
    }

    public static DSLOrderBuilder forCustomer(String customer) {
        return new DSLOrderBuilder(customer);
    }

    public DSLTradeBuilder buy(int quantity) {
        return new DSLTradeBuilder(this, Trade.Type.BUY, quantity);
    }

    public DSLTradeBuilder sell(int quantity) {
        return new DSLTradeBuilder(this, Trade.Type.SELL, quantity);
    }

    public DSLOrderBuilder addTrade(Trade trade) {
        order.addTrade(trade);
        return this;
    }

    public Order end() {
        return order;
    }
}
