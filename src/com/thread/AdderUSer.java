package com.thread;

import java.io.IOException;
import java.util.concurrent.*;

import com.thread.Adder;
import com.thread.AdderThreads;

public class AdderUSer {

    public static void singleProcess(){
        String[] inFiles = {"./file1.txt","./file6.txt"};
        String[] outFiles = {"./file1Out.txt","./file6Out.txt"};

        try{
            for (int i = 0; i < inFiles.length; i++){
                Adder adder = new Adder(inFiles[i], outFiles[i]);
                adder.doAdd();
            }

        } catch (IOException e){
            // do something
        }

    }

// should probably return something
    public static void withThread(){
        String[] inFiles = {"./file1.txt","./file6.txt"};
        String[] outFiles = {"./file1Out.txt","./file6Out.txt"};

            for (int i = 0; i < inFiles.length; i++){
                Adder adder = new Adder(inFiles[i], outFiles[i]);
                Thread thread = new Thread((Runnable) adder);
                thread.start();
            }
    }

    public static void withSeperateThread(){
        // direct management of threads not good for alot of files
        String[] inFiles = {"./file1.txt","./file6.txt"};
        String[] outFiles = {"./file1Out.txt","./file6Out.txt"};
        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 0; i < inFiles.length; i++){
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            es.submit((Runnable) adder);

        }
        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS)
        } catch (Exception e){

        }



    }

    public static void withThreadPool(){
        // direct management of threads not good for alot of files
        String[] inFiles = {"./file1.txt","./file6.txt"};
        String[] outFiles = {"./file1Out.txt","./file6Out.txt"};
        Thread[] threads = new Thread[inFiles.length];


        for (int i = 0; i < inFiles.length; i++){
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            threads[i] = new Thread((Runnable) adder);
            threads[i].start();

        }

        for (Thread thread: threads)
            thread.join(); // blocks waiting for thread completion



    }

    public static void threadReturns(){
        String[] inFiles = {"./file1.txt","./file6.txt"};
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer>[] res = new Future[inFiles.length];


        for (int i = 0; i < inFiles.length; i++){
            Adder adder = new Adder(inFiles[i]);
            es.submit(adder);

        }

        for (Future<Integer> result:res){
            try {
                int val = result.get();
                System.out.println(val);
            }catch (ExecutionException e){
                Throwable addEx = e.getCause();

            }catch (Exception e){

            }
        }



    }

}

