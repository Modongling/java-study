package com.my.study.oop.deeplearn;

import com.my.study.oop.extendscase.A;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;

public class BoxingUnboxingDemo {
}

/**
 * 无谓的拆箱和装箱影响性能
 */
class Counter {
    private final AtomicLong counter = new AtomicLong();
    public void increase() {
        counter.incrementAndGet();
    }
}

/**
 * 原始类型
 */
class CompactCounter {
    private volatile long counter;
    private static final AtomicIntegerFieldUpdater<CompactCounter> updater = AtomicIntegerFieldUpdater.newUpdater(CompactCounter.class, "counter");
    public void increase() {
        updater.incrementAndGet(this);
    }
}
