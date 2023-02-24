package com.stream;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {
    static public Reader openReader(String s) throws IOException {
        return Files.newBufferedReader(Paths.get(s));
    }

    static public Writer openWriter(String s) throws IOException {
        return Files.newBufferedWriter(Paths.get(s));

    }
}
