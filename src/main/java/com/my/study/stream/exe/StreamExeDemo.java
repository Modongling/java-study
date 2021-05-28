package com.my.study.stream.exe;

import com.my.study.stream.entity.Trader;
import com.my.study.stream.entity.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author mdl
 * @Created 2021/5/27 16:14
 * @Description
 */
public class StreamExeDemo {
    private static List<Transaction> transactions;
    static {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300, null),
                new Transaction(raoul, 2012, 1000, null),
                new Transaction(raoul, 2012, 400, null),
                new Transaction(mario, 2012, 710, null),
                new Transaction(mario, 2012, 900, null),
                new Transaction(alan, 2012, 950, null)
        );
    }

    /**
     * 找出所有2011的交易记录按交易额排序
     * @param transactions
     * @return
     */
    public static List<Transaction> getTransactionsByYear(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> Objects.equals(transaction.getYear(), 2011))
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    /**
     * 找出来自Cambridge的交易员
     * @param transactions
     * @return
     */
    public static List<Trader> getTransactionsByLoc(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> Objects.equals(trader.getCity(), "Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    /**
     * 查询不同城市的员工
     * @param transactions
     * @return
     */
    public static List<String> getTradeCity(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    public static String getTradeName(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
    }

    /**
     * 是否在Milan工作
     * @param transactions
     * @return
     */
    public static Boolean tradeIsInMilan(List<Transaction> transactions) {
        return transactions.stream()
                .anyMatch(transaction -> Objects.equals(transaction.getTrader().getCity(), "Milan"));
    }

    /**
     * 提取Cambridge的交易额
     * @param transactions
     * @return
     */
    public static List<Integer> tradeAmount(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> Objects.equals(transaction.getTrader().getCity(), "Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
    }

    /**
     * 最大交易额
     * @param transactions
     * @return
     */
    public static Integer tradeAmountMax(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max).orElse(null);
    }

    /**
     * 最小交易值
     * @param transactions
     * @return
     */
    public static Integer tradeAmountMin(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min).orElse(null);
    }


    public static void main(String[] args) {
        System.out.println(getTransactionsByYear(transactions));
        System.out.println(getTransactionsByLoc(transactions));
        System.out.println(getTradeCity(transactions));
        System.out.println(getTradeName(transactions));
        System.out.println(tradeIsInMilan(transactions));
        System.out.println(tradeAmount(transactions));
        System.out.println(tradeAmountMax(transactions));
        System.out.println(tradeAmountMin(transactions));
    }
}
