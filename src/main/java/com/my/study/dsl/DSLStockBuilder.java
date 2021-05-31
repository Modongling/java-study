package com.my.study.dsl;

import com.my.study.dsl.entity.Stock;
import com.my.study.dsl.entity.Trade;

public class DSLStockBuilder {
    private final DSLOrderBuilder orderBuilder;
    private final Trade trade;
    private final Stock stock = new Stock();

    DSLStockBuilder(DSLOrderBuilder orderBuilder, Trade trade, String symbol) {
        this.orderBuilder = orderBuilder;
        this.trade = trade;
        stock.setSymbol(symbol);
    }

    public DSLTradeBuilderWithStock on(String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return new DSLTradeBuilderWithStock(orderBuilder, trade);
    }
}
