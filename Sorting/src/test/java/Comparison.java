import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Comparison {
    ISortingAlgorithms merge=new MergeSort();
    ISortingAlgorithms bubble = new BubbleSort();
    ISortingAlgorithms Counting =new CountingSort();
    @Test
    void testOne(){


        int []a ={1,2,3,4,5,6,7,8};
        TestHelper(a,Counting,"Test One Counting");
        TestHelper(a,merge,"Test One Merge");
        TestHelper(a,bubble,"Test One Bubble");
     System.out.println("================================================================================");



    }
    @Test
    void testTwo(){

            int [] a2={22,22,3,5,3,22,0,0,0,0,3,22};
            TestHelper(a2,Counting,"Test Two Counting");
            TestHelper(a2,merge,"Test Two Merge");
            TestHelper(a2,bubble,"Test Two Bubble");
        System.out.println("================================================================================");

    }
    @Test
    void testThree(){

        int[] a3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        TestHelper(a3,Counting,"Test Three Counting");
        TestHelper(a3,merge,"Test Three Merge");
        TestHelper(a3,bubble,"Test Three Bubble");

    }

    private void TestHelper(int [] array ,ISortingAlgorithms Is,String testCaseName){
        int [] inputToAlgo= Arrays.copyOf(array,array.length);
        Arrays.sort(array);///expected
        TestResult ts=  Helper.showTime(inputToAlgo,Is);
        assertArrayEquals(array, ts.sorted);
        System.out.println( "Time Taken by "+testCaseName +" : " + ts.time + " ms");
        System.out.println();




    }
}
