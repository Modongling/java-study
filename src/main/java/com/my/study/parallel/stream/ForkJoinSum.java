package com.my.study.parallel.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author mdl
 * @Created 2021/5/30 14:02
 * @Description
 */
public class ForkJoinSum  extends RecursiveTask<Long> {
    private long[] nums;
    private int start;
    private int end;
    private static final long THRESHOLD = 10_000L;

    public ForkJoinSum(long[] nums) {
        this(nums, 0, nums.length);
    }

    public ForkJoinSum(long[] nums, int start, int end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return seqSum();
        }
        ForkJoinSum taskLeft = new ForkJoinSum(nums, start, start + length / 2);
        //拆分任务
        taskLeft.fork();
        ForkJoinSum taskRight = new ForkJoinSum(nums, start + length / 2, end);
        Long right = taskRight.compute();
        Long left = taskLeft.join();
        return left + right;


    }

    private Long seqSum() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static long sum(long n) {
        long[] nums = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSum(nums);
        return new ForkJoinPool().invoke(task);
    }
}
