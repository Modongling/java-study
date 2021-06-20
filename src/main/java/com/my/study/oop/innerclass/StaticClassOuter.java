package com.my.study.oop.innerclass;

public class StaticClassOuter {
    private int i = 1;
    private static int si = 2;

    static class StaticClassInner {
        //静态内部类的静态变量
        private static int si = 3;

        public void innerMethod() {
            //访问同名静态内部类变量
            System.out.println(si);
            //访问非静态变量
            System.out.println(new StaticClassOuter().i);
            //访问外部类静态变量
            System.out.println(StaticClassOuter.si);
        }
    }
}
