package com.my.study.oop.mathes;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MathTest {
    public static void main(String[] args) {
        //随机数测试
        Random random = new Random();
        //随机布尔值
        System.out.println(random.nextBoolean());
        byte[] buffer = new byte[16];
        //随机字节数组
        random.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
        /**
         * 0.0 ~ 1.0浮点数
         */
        System.out.println(random.nextFloat());
        System.out.println(random.nextDouble());

        /**
         * int范围和指定数值范围
         */
        System.out.println(random.nextInt());
        //0-15
        System.out.println(random.nextInt(15));

        //seed --- random产生的伪随机数 通过种子确保生成的伪随机数不重复
        Random randomSeed = new Random(50);
        System.out.println("seed:" + randomSeed.nextInt());
        Random randomSeed2 = new Random(50);
        System.out.println("seed2:" + randomSeed2.nextInt());

        Random timeRandom = new Random(System.currentTimeMillis());

        //多线程下的随机数
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt(4, 20));
    }
}
