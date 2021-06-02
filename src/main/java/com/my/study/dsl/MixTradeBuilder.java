package com.my.study.dsl;

import com.my.study.dsl.entity.Trade;

/**
 * @author mdl
 * @Created 2021/6/2 17:45
 * @Description
 */
public class MixTradeBuilder {
    Trade trade = new Trade();

    public MixTradeBuilder quantity(int quantity) {
        trade.setQuantity(quantity);
        return this;
    }

    public MixTradeBuilder at(double price) {
        trade.setPrice(price);
        return this;
    }

    public MixStockBuilder stock(String symbol) {
        return new MixStockBuilder(this, trade, symbol);
    }
}
