package com.my.study.entity;

import com.my.study.stream.entity.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.my.study.stream.paramaction.CommonParamToAction.filter;

/**
 * @author mdl
 * @Created 2021/5/31 21:28
 * @Description
 */
public class PointTest {
    @Test
    public void testMoveRight() {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRight(10);
        Assert.assertEquals(15, p2.getX());
        Assert.assertEquals(5, p2.getY());
    }

    @Test
    public void testCompare() {
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);
        int result = Point.compareXAndY.compare(p1, p2);
        Assert.assertTrue(result < 0);
    }

    @Test
    public void testMoveAllRight() {
        //遍历赋值测试最终结果忽略过程
        List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
        List<Point> result = Arrays.asList(new Point(15, 5), new Point(20, 5));
        List<Point> newPoints = Point.moveAllRight(points, 10);
        Assert.assertEquals(newPoints, result);
    }

    @Test
    public void testFilter() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> evens = filter(nums, i -> i % 2 == 0);
        Assert.assertEquals(Arrays.asList(2, 4), evens);
    }
}
