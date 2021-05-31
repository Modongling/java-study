package com.my.study.stream.entity;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author mdl
 * @Created 2021/5/31 21:25
 * @Description
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point moveRight(int x) {
        return new Point(this.x + x, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static final Comparator<Point> compareXAndY = Comparator.comparing(Point::getX).thenComparing(Point::getY);

    public static List<Point> moveAllRight(List<Point> points, int x) {
        return points.stream()
                .map(point -> new Point(point.getX() + x, point.getY()))
                .collect(Collectors.toList());
    }
}
