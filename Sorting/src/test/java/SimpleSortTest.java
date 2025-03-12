import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SimpleSortTest {
    ISortingAlgorithms sortingAlgorithm= new BubbleSort();


    @Test
    void lowSizeSort(){
        int [] array = Helper.getRandomArray(1,50000,1000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Low Size Sort (1k) : "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void mediumSizeSort(){
        int [] array = Helper.getRandomArray(1,50000,10000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Medium Size Sort (10k) : " + testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void largeSizeSort(){
        int [] array = Helper.getRandomArray(1,50000,50000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Large Size Sort (50k) : "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void veryLargeSizeSort(){
        int [] array = Helper.getRandomArray(1,50000,500000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Very Large Size Sort (500K) : "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void ManyDuplicatesSort(){
        int [] array = Helper.getRandomArray(1,50000,100000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Many Duplicates (100k): "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void sortedArraySort(){
        int [] array = new int[50000];
        for(int i = 0;i < 50000; i++){
            array[i] = i;
        }
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Sorted (50k) : "+testResult.time );
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void reversedArraySort(){
        int [] array = new int[50000];
        for(int i = 50000-1;i >= 0; i--){
            array[i] = i;
        }
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("reversed (50k): "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }

}
