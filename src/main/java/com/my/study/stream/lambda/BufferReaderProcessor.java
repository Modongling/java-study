package com.my.study.stream.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author mdl
 * @Created 2021/5/23 14:22
 * @Description
 */
@FunctionalInterface
public interface BufferReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
