package com.my.study.dsl;

import com.my.study.dsl.entity.Stock;
import com.my.study.dsl.entity.Trade;

/**
 * @author mdl
 * @Created 2021/6/2 17:46
 * @Description
 */
public class MixStockBuilder {
    private final MixTradeBuilder mixTradeBuilder;
    private final Trade trade;
    private final Stock stock = new Stock();

    public MixStockBuilder(MixTradeBuilder mixTradeBuilder, Trade trade, String symbol) {
        this.mixTradeBuilder = mixTradeBuilder;
        this.trade = trade;
        stock.setSymbol(symbol);
    }

    public MixTradeBuilder on(String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return mixTradeBuilder;
    }
}
