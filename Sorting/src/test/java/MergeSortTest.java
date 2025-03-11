import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {
    ISortingAlgorithms mergeSort = new MergeSort();
    @Test
    void  testOne(){
        int []a=Helper.getRandomArray(0,5,10);
        TestResult testResult=Helper.showTime(a,mergeSort);
        System.out.println(testResult.time);
        Arrays.sort(a);
        assertArrayEquals(a,testResult.sorted);
    }

}
