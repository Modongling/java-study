package com.my.study.dsl;

import com.my.study.dsl.entity.Stock;

/**
 * @author mdl
 * @Created 2021/6/2 17:15
 * @Description
 */
public class LambdaStockBuilder {
    Stock stock = new Stock();

    public void symbol(String symbol) {
        stock.setSymbol(symbol);
    }

    public void market(String market) {
        stock.setMarket(market);
    }
}
