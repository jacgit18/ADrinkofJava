package com.stream;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class MainStream {
    public static void main(String[] args) {

//        doTryCatchFinally();
        doTryWithResorces();
//        doTryWithResorcesMulti();
//        doCloseThing();

        String[] data = {
                "Line 1",
                "Line 2 2",
                "Line 3 3 3",
                "Line 4 4 4 4",
                "Line 5 5 5 5 5",
        };

        try(FileSystem zipFs = openZip(Paths.get("myData.zip"))){
            copyToZip(zipFs);
            writeToFileInZip1(zipFs, data);
            writeToFileInZip2(zipFs, data);

        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());

        }

    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {

        Map<String, String> providerProps = new HashMap<>();

        providerProps.put("create", "true");
        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFs = FileSystems.newFileSystem(zipUri, providerProps);

        return zipFs;

    }


    private static void copyToZip(FileSystem zipFs) throws IOException {

         Path sourceFile = Paths.get("file.txt");
//        Path sourceFile = FileSystems.getDefault().getPath("file1.txt"); // long way
        Path destFile = zipFs.getPath("/file1Copied.txt");

        Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void writeToFileInZip1(FileSystem zipFs, String[] data) throws IOException {
        try(BufferedWriter writer = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"))){
          for (String d:data){
              writer.write(d);
              writer.newLine();
          }

        }
    }

    private static void writeToFileInZip2(FileSystem zipFs, String[] data) throws IOException {
        Files.write(zipFs.getPath("/newFile2.txt"), Arrays.asList(data),
                Charset.defaultCharset(), StandardOpenOption.CREATE);
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
