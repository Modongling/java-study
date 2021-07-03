package com.my.study.oop.nio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOTest {
    public static void main(String[] args) {
        /**
         * Path/Paths/Files
         */
        File file = new File("test.png");
        Path path = Paths.get("test.png");

    }
}
