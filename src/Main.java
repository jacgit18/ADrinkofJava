//- Interfaces represent the different types of collections: sets, lists, queues, and maps. These are divided into two groups:
//        - Basic ****interfaces found in `java.util.Collection`. It has the Set, List, and Queue interfaces.
//        - Collection-view interfaces are not authentic collections but enable them to be manipulated as collections found in ****`java.util.Map`. It has a Map interface.

import java.util.Collection;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Technologist devOps = new Technologist();

        MyAnotherClass dev = new MyAnotherClass();
        int num[] = {1,2,3,4};
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        System.out.println("DevOps Technologist First Name: " + num[0]);


        //print firstName of devOps
        System.out.println("DevOps Technologist First Name: " + devOps.getFirstName());
        MyAnotherClass myClassInstance = new MyAnotherClass();
        myClassInstance.callMyMethod();
//        System.out.println("DevOps Technologist First Name: " + dev.callMyMethod());


//        SRE sreOne = new SRE();
//
//        // Call study() from parent
//        sreOne.study();
//        sreOne.attendClass();

    }
}

 class exp{



}




