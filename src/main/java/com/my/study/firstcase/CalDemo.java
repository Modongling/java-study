package com.my.study.firstcase;

public class CalDemo {
    public static void main(String[] args) {
        // 四则运算 自增 自减 取余% 三目运算 位运算
        double d = 16D;
        //平方根
        double x = Math.sqrt(d); //4.0
        System.out.println(x);

        //x的N次方
        double y = Math.pow(3, 3);
        //强制类型转换,大类型转小类型会丢失精度
        System.out.println((int) y);
        //小类型到大类型自动转换
        int z = 12;
        double dz = z;
        float f = 13F;
        long l = 2L;
        char ch = 'a';
        char ch2 = 'b';
        char ch3 = 195;
        byte b = 126;
        byte b2 = 3;
        System.out.println(dz);
        /**
         * 其中一个操作数类型为double,另一个操作数类型也会转为double
         * 否则，一个操作数是float,另一个操作数也会转成float
         * 否则，一个操作数为long,另一个操作数也会转为long
         * 否则，两个操作数都会转为int
         */
        System.out.println(f + z);
        System.out.println(x + z);
        System.out.println(l + z);
        System.out.println(ch + ch2);
        System.out.println(ch3);
        System.out.println(b + b2);

        z += 20;
        //z = z + 20;
        System.out.println(z);

        int n = 7;
        int n2 = 7;
        int m = 2 * (++n);
        //int m2 = 2 * (n2++);
        int m2 = 2 * (n2);
        System.out.println(m);
        System.out.println(m2);
        //m = m % 4;
        System.out.println(m %= 4);
        /**
         *                      char ---> int
         * byte ---> short ---> int ---> long
         *                      int ---> float
         *                      int ---> double
         *                      long ---> float
         *                      long ---> double
         *                      float ---> double
         */

        int xx = 10;
        int yy = 11;
        System.out.println(xx < yy ? xx : yy);

        //位运算
        // && || 条件判断,会发生短路
        //& | ~ ^ 不会短路
        // 1
        if ((xx < yy) || (1 < 0)) {
            System.out.println("aaa");
        }
        // 1 | 0 = 1
        if ((xx < yy) | (1 < 0)) {
            System.out.println("aaa");
        }
    }
}
