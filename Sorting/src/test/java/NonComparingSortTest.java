import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NonComparingSortTest {
    ISortingAlgorithms sortingAlgorithm = new CountingSort();


    @Test
    void lowSizeSort(){
        int [] array = Helper.getRandomArray(0,100,1000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Low Size Sort (1k) : "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void mediumSizeSort(){
        int [] array = Helper.getRandomArray(1,25000,10000);
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
        int [] array = Helper.getRandomArray(1,100000,1000000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Very Large Size Sort (1M) : "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void ManyDuplicatesSort(){
        int [] array = Helper.getRandomArray(1,100,100000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Many Duplicates (100k): "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void sortedArraySort(){
        int [] array = new int[100000];
        for(int i = 0;i < 100000; i++){
            array[i] = i;
        }
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Sorted (100k) : "+testResult.time );
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void reversedArraySort(){
        int [] array = new int[100000];
        for(int j = 100000,i=0;i < 100000; i++,j--){
            array[i] = j;
        }
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("reversed (100k): "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void Infeasible() {
        int[] array = {0, 0, 8, 100000};
        TestResult testResult = Helper.showTime(array, sortingAlgorithm);
        assertArrayEquals(null, testResult.sorted);
    }

}