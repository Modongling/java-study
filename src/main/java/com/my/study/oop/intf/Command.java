package com.my.study.oop.intf;

/**
 *方法需要完成某个行为，但是行为必须等到执行这个方法时才能确定
 */
public interface Command {
    void process(int[] target);
}
