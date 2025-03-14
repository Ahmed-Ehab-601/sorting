import org.junit.jupiter.api.Test;

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
        System.out.println("================================================================================");

    }
    @Test
    void testFour(){
        System.out.println("Size = 10");
        int[] array = {1,5,7,8,4,4,8,9,4,10};
        TestHelper(array,Counting,"Test Four Counting");
        TestHelper(array,merge,"Test Four Merge");
        TestHelper(array,bubble,"Test Four Bubble");
        System.out.println("================================================================================");

    }
    @Test
    void testSix(){
        System.out.println("Size = 100k");
        int [] array = Helper.getRandomArray(1,100000,100000);
        TestHelper(array,Counting,"Test Six Counting");
        TestHelper(array,merge,"Test Six Merge");
        TestHelper(array,bubble,"Test Six Bubble");
        System.out.println("================================================================================");

    }
    @Test
    void testEight(){
        System.out.println("Size = 500K");
        int [] array = Helper.getRandomArray(1,100000,500000);
        TestHelper(array,Counting,"Test Eight Counting");
        TestHelper(array,merge,"Test Eight Merge");
        System.out.println("================================================================================");

    }
    @Test
    void testNine(){
        System.out.println("Size = 1M");
        int [] array = Helper.getRandomArray(1,100000,1000000);
        TestHelper(array,Counting,"Test Nine Counting");
        TestHelper(array,merge,"Test Nine Merge");
        System.out.println("================================================================================");

    }
    @Test
    void testFive(){
        System.out.println("Size = 100k Sorted");
        int [] array = new int[100000];
        for(int i = 0;i < 100000; i++){
            array[i] = i;
        }
        TestHelper(array,Counting,"Test Five Counting");
        TestHelper(array,merge,"Test Five Merge");
        TestHelper(array,bubble,"Test Five Bubble");
        System.out.println("================================================================================");

    }

    @Test
    void testSeven(){
        System.out.println("Size = 100k Reversed");
        int [] array = new int[100000];
        for(int j = 100000,i=0;i < 100000; i++,j--) {
            array[i] = j;
        }
        TestHelper(array,Counting,"Test Seven Counting");
        TestHelper(array,merge,"Test Seven Merge");
        TestHelper(array,bubble,"Test Seven Bubble");
        System.out.println("================================================================================");

    }

    private void TestHelper(int [] array ,ISortingAlgorithms Is,String testCaseName){
        double totalTime = 0;
        int iterations = 100;
        int warmUpIterations = 20; // Warm-up iterations

        // Warm-up phase
        for (int i = 0; i < warmUpIterations; i++) {
            Helper.showTime(array, Is);
        }

        for (int i = 0; i < iterations; i++) {
            TestResult ts = Helper.showTime(array, Is);
            totalTime += ts.milliTime;
        }

        double averageTime = totalTime / iterations;
        System.out.println("Average Time Taken by " + testCaseName + " (100 runs): " + String.format("%.4f",averageTime) + " ms\n");

    }


}
