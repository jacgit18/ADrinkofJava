package com.stream;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable{
    public void saySomething() throws IOException {
        throw new IOException("Excep from Something");
//        System.out.println("Something");

    }
    @Override
    public void close() throws IOException{
//        System.out.println("close");
        throw new IOException("Excep from close");
    }
}
