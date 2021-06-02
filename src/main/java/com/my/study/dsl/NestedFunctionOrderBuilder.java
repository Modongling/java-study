package com.my.study.dsl;

import com.my.study.dsl.entity.Order;
import com.my.study.dsl.entity.Stock;
import com.my.study.dsl.entity.Trade;

import java.util.stream.Stream;

/**
 * @author mdl
 * @Created 2021/6/1 17:33
 * @Description
 */
public class NestedFunctionOrderBuilder {
    /**
     * 创建订单
     * @param customer
     * @param trades
     * @return
     */
    public static Order order(String customer, Trade... trades) {
        Order order = new Order();
        order.setCustomer(customer);
        Stream.of(trades).forEach(order::addTrade);
        return order;
    }

    public static Trade buildTrade(int quantity, Stock stock, double price, Trade.Type type) {
        Trade trade = new Trade();
        trade.setQuantity(quantity);
        trade.setType(type);
        trade.setPrice(price);
        trade.setStock(stock);
        return trade;
    }

    public static Stock stock(String symbol, String market) {
        Stock stock = new Stock();
        stock.setSymbol(symbol);
        stock.setMarket(market);
        return stock;
    }

    public static double at(double price) {
        return price;
    }

    public static String on(String market) {
        return market;
    }

    public static Trade buy(int quantity, Stock stock, double price) {
        return buildTrade(quantity, stock, price, Trade.Type.BUY);
    }

    public static Trade sell(int quantity, Stock stock, double price) {
        return buildTrade(quantity, stock, price, Trade.Type.SELL);
    }

}
