package com.my.study.dsl;

import com.my.study.dsl.entity.Trade;

public class DSLTradeBuilderWithStock {
    private final DSLOrderBuilder orderBuilder;
    private final Trade trade;

    public DSLTradeBuilderWithStock(DSLOrderBuilder orderBuilder, Trade trade) {
        this.orderBuilder = orderBuilder;
        this.trade = trade;
    }

    public DSLOrderBuilder at(double price) {
        trade.setPrice(price);
        return orderBuilder.addTrade(trade);
    }
}
