package com.my.study.dsl;

import com.my.study.dsl.entity.Order;
import com.my.study.dsl.entity.Trade;

import java.util.function.Consumer;

/**
 * @author mdl
 * @Created 2021/6/1 17:50
 * @Description
 */
public class LambdaOrderBuilder {
    public final Order order = new Order();

    /**
     * 接受一个Consumer返回构建好的订单
     * @param consumer
     * @return
     */
    public static Order orderL(Consumer<LambdaOrderBuilder> consumer) {
        LambdaOrderBuilder orderBuilder = new LambdaOrderBuilder();
        consumer.accept(orderBuilder);
        return orderBuilder.order;
    }
    public void forCustomer(String customer) {
        order.setCustomer(customer);
    }

    public void buy(Consumer<LambdaTradeBuilder> consumer) {
        trade(consumer, Trade.Type.BUY);
    }

    public void sell(Consumer<LambdaTradeBuilder> consumer) {
        trade(consumer, Trade.Type.SELL);
    }

    private void trade(Consumer<LambdaTradeBuilder> consumer, Trade.Type type) {
        LambdaTradeBuilder tradeBuilder = new LambdaTradeBuilder();
        tradeBuilder.trade.setType(type);
        consumer.accept(tradeBuilder);
        order.addTrade(tradeBuilder.trade);
    }
}
