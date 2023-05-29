package com.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class AdderCallable implements Callable <Integer> {
    private String inFile;

    public String AdderReturn(String inFile, String outFile) {
        /* assign filenames to member fields */
    }

    public int doAdd() throws IOException {
        int total = 0;
        String line = null;


        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            String inline = "";
            while ((line = reader.readLine()) != null)
                total += Integer.parseInt(inline);
        }
        return total;
    }

    public Integer call() throws IOException{
        return doAdd();
    }

}
