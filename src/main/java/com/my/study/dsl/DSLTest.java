package com.my.study.dsl;

import com.my.study.dsl.entity.Order;

import static com.my.study.dsl.DSLOrderBuilder.forCustomer;
import static com.my.study.dsl.LambdaOrderBuilder.orderL;
import static com.my.study.dsl.MixBuilder.mixForCustomer;
import static com.my.study.dsl.NestedFunctionOrderBuilder.*;

/**
 * @author mdl
 * @Created 2021/6/1 17:23
 * @Description
 */
public class DSLTest {
    public static void main(String[] args) {
        //链式
        Order o = forCustomer("BigBank")
                .buy(80)
                .stock("IBM")
                .on("NYSE")
                .at(125.00)
                .sell(50)
                .stock("GOOGLE")
                .on("NASDAQ")
                .at(375.00)
                .end();
        System.out.println(o);

        //组合
        Order nested = order("aaa",
                buy(20, stock("aabb", "123"), at(125.00)),
                sell(10, stock("bbaa", "321"), at(521.00))
        );
        System.out.println(nested);

        //lambda
        Order lambda = orderL(ol -> {
            //创建或者对象传递的过程即为Consumer过程
            ol.forCustomer("lambdaCust");
            ol.buy(t -> {
                t.price(120.00);
                t.quantity(20);
                t.stock(s -> {
                    s.market("CHINA");
                    s.symbol("CH");
                });
            });
            ol.sell(t -> {
                t.price(20.00);
                t.quantity(5);
                t.stock(s -> {
                    s.market("USA");
                    s.symbol("USD");
                });
            });
        });
        System.out.println(lambda);

        //mix
        Order mix = mixForCustomer("BB",
                MixBuilder.buy(t -> t.quantity(10)
                        .at(12.00)
                        .stock("ss")
                        .on("CH")),
                MixBuilder.sell(t -> t.quantity(2)
                        .at(1200.00)
                        .stock("XXss")
                        .on("US")));
        System.out.println(mix);
    }
}
