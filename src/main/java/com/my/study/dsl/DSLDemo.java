package com.my.study.dsl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DSLDemo {
    public static void logLine() throws IOException {
        List<String> errors = new ArrayList<>();
        int error = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data.log"));
        String line = bufferedReader.readLine();
        while (error < 40 && line != null) {
            if (line.startsWith("ERROR")) {
                errors.add(line);
                error++;
            }
            line = bufferedReader.readLine();
        }

        //dsl
        errors = Files.lines(Paths.get("data.log"))
                .filter(l -> l.startsWith("ERROR"))
                .limit(40)
                .collect(Collectors.toList());
    }
}
