package com.my.study.oop.systems;

import java.util.Map;
import java.util.Properties;

public class SystemTest {
    public static void main(String[] args) {
        //获取环境变量
        Map<String, String> getenv = System.getenv();
        for (String key : getenv.keySet()) {
            System.out.println(key);
        }

        //获取指定环境变量
        System.out.println(System.getenv("JAVA_HOME"));
        //获取配置信息
        Properties properties = System.getProperties();
        System.out.println(properties);

        //精确计算HashCode
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        //值相等
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        //不同对象
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
    }
}
