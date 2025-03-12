import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ComparisonTest {
    ISortingAlgorithms merge=new MergeSort();
    ISortingAlgorithms bubble = new BubbleSort();
    ISortingAlgorithms Counting =new CountingSort();
    @Test
    void testOne(){
        System.out.println("Size = 1k");
        int []array = Helper.getRandomArray(1,1000,1000);
        TestHelper(array,Counting,"Test One Counting");
        TestHelper(array,merge,"Test One Merge");
        TestHelper(array,bubble,"Test One Bubble");
     System.out.println("================================================================================");



    }
    @Test
    void testTwo(){
             System.out.println("Size = 10k");
            int [] array=Helper.getRandomArray(1,1000,10000);
            TestHelper(array,Counting,"Test Two Counting");
            TestHelper(array,merge,"Test Two Merge");
            TestHelper(array,bubble,"Test Two Bubble");
            System.out.println("================================================================================");

    }
    @Test
    void testThree(){
        System.out.println("Size = 50k");
        int[] array = Helper.getRandomArray(1,10000,50000);
        TestHelper(array,Counting,"Test Three Counting");
        TestHelper(array,merge,"Test Three Merge");
        TestHelper(array,bubble,"Test Three Bubble");

    }
    @Test
    void testFour(){
        System.out.println("Size = 10");
        int[] array = {1,5,7,8,4,4,8,9,4,10};
        TestHelper(array,Counting,"Test Three Counting");
        TestHelper(array,merge,"Test Three Merge");
        TestHelper(array,bubble,"Test Three Bubble");

    }
    @Test
    void testFive(){
        System.out.println("Size = 100k Sorted");
        int [] array = new int[100000];
        for(int i = 0;i < 100000; i++){
            array[i] = i;
        }
        TestHelper(array,Counting,"Test Three Counting");
        TestHelper(array,merge,"Test Three Merge");
        TestHelper(array,bubble,"Test Three Bubble");

    }
    @Test
    void testSix(){
        System.out.println("Size = 100k");
       int[] array = Helper.getRandomArray(1,100000,100000);
        TestHelper(array,merge,"Test Three Merge");
        TestHelper(array,Counting,"Test Three Counting");
        TestHelper(array,bubble,"Test Three Bubble");

    }

    private void TestHelper(int [] array ,ISortingAlgorithms Is,String testCaseName){
        TestResult ts=Helper.showTime(array,Is);
        System.out.println( "Time Taken by "+testCaseName +" : " + ts.time + " ms");
        System.out.println();

    }
}
