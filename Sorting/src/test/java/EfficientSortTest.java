import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EfficientSortTest {
    //change n,min,max
    ISortingAlgorithms sortingAlgorithm = new MergeSort();


    @Test
    void lowSizeSort(){
        int [] array = Helper.getRandomArray(1,Integer.MAX_VALUE-1,1000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Low Size Sort (1k) : "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void mediumSizeSort(){
        int [] array = Helper.getRandomArray(1,1000,10000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Medium Size Sort (10k) : " + testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void largeSizeSort(){
        int [] array = Helper.getRandomArray(1,Integer.MAX_VALUE-1,50000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Large Size Sort (50k) : "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void veryLargeSizeSort(){
        int [] array = Helper.getRandomArray(1,Integer.MAX_VALUE-1,500000);
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Very Large Size Sort (500K) : "+testResult.time);
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
        int [] array = new int[500000];
        for(int i = 0;i < 500000; i++){
            array[i] = i;
        }
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("Sorted (500k) : "+testResult.time );
        assertArrayEquals(array,testResult.sorted);
    }
    @Test
    void reversedArraySort(){
        int [] array = new int[500000];
        for(int j = 500000,i=0;i < 500000; i++,j--){
            array[i] = j;
        }
        TestResult testResult = Helper.showTime(array,sortingAlgorithm);
        System.out.println("reversed (500k): "+testResult.time);
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);
    }

}
