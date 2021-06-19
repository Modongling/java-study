package com.my.study.oop.immutable;

import java.util.Objects;

/**
 * 缓存不变类的对象
 */
public class MyCacheDemo {
    private final static int MAX_SIZE = 10;
    private static Cache[] caches = new Cache[MAX_SIZE];
    private static  int pos = 0;

    public static Cache valueOf(String name) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (caches[i] != null && name.equals(caches[i].getName())) {
                return caches[i];
            }
        }

        if (pos == MAX_SIZE) {
            caches[0] = new Cache(name);
            pos = 1;
        } else {
            caches[pos ++] = new Cache(name);
        }
        return caches[pos - 1];
    }

    public static void main(String[] args) {
        Cache c1 = MyCacheDemo.valueOf("hello");
        Cache c2 = MyCacheDemo.valueOf("hello");
        System.out.println(c1 == c2);
    }
}

class Cache {
    private final String name;

    public Cache(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cache cache = (Cache) o;
        return Objects.equals(name, cache.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}