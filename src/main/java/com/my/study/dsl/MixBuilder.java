package com.my.study.dsl;

import com.my.study.dsl.entity.Order;
import com.my.study.dsl.entity.Trade;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author mdl
 * @Created 2021/6/2 17:29
 * @Description
 */
public class MixBuilder {
    public static Order mixForCustomer(String customer, MixTradeBuilder... mixTradeBuilders) {
        Order order = new Order();
        order.setCustomer(customer);
        Stream.of(mixTradeBuilders).forEach(mixTradeBuilder -> order.addTrade(mixTradeBuilder.trade));
        return order;
    }

    private static MixTradeBuilder tradeBuild(Consumer<MixTradeBuilder> consumer, Trade.Type type) {
        MixTradeBuilder tradeBuilder = new MixTradeBuilder();
        tradeBuilder.trade.setType(type);
        consumer.accept(tradeBuilder);
        return tradeBuilder;
    }

    public static MixTradeBuilder buy(Consumer<MixTradeBuilder> consumer) {
        return tradeBuild(consumer, Trade.Type.BUY);
    }

    public static MixTradeBuilder sell(Consumer<MixTradeBuilder> consumer) {
        return tradeBuild(consumer, Trade.Type.SELL);
    }
}
