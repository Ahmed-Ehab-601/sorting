import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class CountingSortTest {
    ISortingAlgorithms countingSort = new CountingSort();

    @Test
    void lowSizeSort(){
        int [] array = Helper.getRandomArray(0,10,100);
        TestResult testResult = Helper.showTime(array,countingSort);
        System.out.println(testResult.time + " Size = 100");
        Arrays.sort(array);
        assertArrayEquals(array,testResult.sorted);


    }


}
