package com.stream;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class MainStream {
    public static void main(String[] args) {

        doTryCatchFinally();
//        doTryWithResorces();
//        doTryWithResorcesMulti();
//        doCloseThing();

    }


        public static void doTryCatchFinally(){
        // long hand way
        char[] buff = new char[8];
        int length;
        Reader reader = null;

        try {
            reader = Helper.openReader("file.txt");
            while ((length = reader.read(buff)) >=0){
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++){
                    System.out.println(buff[i]);

                }
            }
        } catch (IOException e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());

        } finally {
            try {
                if(reader != null){
                    reader.close();
                }
            } catch(IOException e2){
                System.out.println(e2.getClass().getSimpleName() + " - " + e2.getMessage());

            }
        }
    }

    public static void doTryWithResorces(){
        // shorter way auto close
        char[] buff = new char[8];
        int length;

        try(Reader reader = Helper.openReader("file.txt")) {
            while ((length = reader.read(buff)) >=0){
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++){
                    System.out.println(buff[i]);

                }
            }
        } catch (IOException e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());

        }
    }

    public static void doTryWithResorcesMulti(){
        char[] buff = new char[8];
        int length;

        try(Reader reader = Helper.openReader("file.txt");
            Writer writer = Helper.openWriter("file2.txt")) {

            while ((length = reader.read(buff)) >=0){
                System.out.println("\nlength: " + length);
                writer.write(buff, 0, length);
            }
        } catch (IOException e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());

        }
    }

    public static void doCloseThing(){
        try (MyAutoCloseable ac = new MyAutoCloseable()){
            // close is still being called
            // if multiple exceptions are thrown java compress them so if you want to see all
            // you have to get them
            ac.saySomething();

        }catch (IOException e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
            for (Throwable t: e.getSuppressed())
                System.out.println("Suppressd " + t.getMessage());


        }

    }


    }
