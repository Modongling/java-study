package com.my.study.dsl;

import com.my.study.dsl.entity.Trade;

import java.util.function.Consumer;

/**
 * @author mdl
 * @Created 2021/6/1 17:56
 * @Description
 */
public class LambdaTradeBuilder {
    Trade trade = new Trade();

    public void quantity(int quantity) {
        trade.setQuantity(quantity);
    }

    public void price(double price) {
        trade.setPrice(price);
    }

    public void stock(Consumer<LambdaStockBuilder> consumer) {
        LambdaStockBuilder stockBuilder = new LambdaStockBuilder();
        consumer.accept(stockBuilder);
        trade.setStock(stockBuilder.stock);
    }
}
