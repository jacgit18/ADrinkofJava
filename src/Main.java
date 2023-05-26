//- Interfaces represent the different types of collections: sets, lists, queues, and maps. These are divided into two groups:
//        - Basic ****interfaces found in `java.util.Collection`. It has the Set, List, and Queue interfaces.
//        - Collection-view interfaces are not authentic collections but enable them to be manipulated as collections found in ****`java.util.Map`. It has a Map interface.

import com.mass.InnerClassDemo;
import com.mass.StaticNestedClassDemo;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //System.getenv()
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
        System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.close();


        MyAnotherClass dev = new MyAnotherClass();
        int num[] = {1,2,3,4};
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        System.out.println("DevOps Technologist First Name: " + num[0]);

        MyAnotherClass myClassInstance = new MyAnotherClass();
        myClassInstance.callMyMethod();
//        System.out.println("DevOps Technologist First Name: " + dev.callMyMethod());


        SRE sreOne = new SRE();

        // Call study() from parent
        sreOne.study();
        sreOne.attendClass();

        InnerClassDemo tes = new InnerClassDemo();
        tes.runTwo();
        System.out.println(" ");


        StaticNestedClassDemo tesTwo = new StaticNestedClassDemo();
        tesTwo.rundone();



    }
}

 class exp{



}




