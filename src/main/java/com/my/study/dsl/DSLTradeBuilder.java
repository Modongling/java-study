package com.my.study.dsl;

import com.my.study.dsl.entity.Trade;

public class DSLTradeBuilder {
    private final DSLOrderBuilder orderBuilder;
    private final Trade trade = new Trade();

    DSLTradeBuilder(DSLOrderBuilder orderBuilder,
                    Trade.Type type, int quantity) {
        this.orderBuilder = orderBuilder;
        trade.setType(type);
        trade.setQuantity(quantity);
    }

    public DSLStockBuilder stock(String symbol) {
        return new DSLStockBuilder(orderBuilder, trade, symbol);
    }
}
