package com.my.study.stream.exe;

import com.my.study.stream.entity.Trader;
import com.my.study.stream.entity.Transaction;

import java.util.Arrays;
import java.util.List;

/**
 * @author mdl
 * @Created 2021/5/27 16:14
 * @Description
 */
public class StreamExeDemo {
    static {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2012, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 900),
                new Transaction(alan, 2012, 950)
        );
    }
}
