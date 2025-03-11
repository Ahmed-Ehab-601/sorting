import java.util.Random;

public class Helper {
    public static int [] getRandomArray(int min,int max,int size){
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = min+rand.nextInt(max-min+1);
        }
        return arr;
    }
     public static void print(int [] sorted,int n) {
         System.out.print("[");
         for (int i = 0; i < n; i++) {
             if(i!=n-1)
                 System.out.print(sorted[i]+", ");
             else
                 System.out.print(sorted[i]);
         }
         System.out.println("]");
     }
     public static TestResult showTime(int [] array,ISortingAlgorithms sortingAlgorithms){
        TestResult testResult = new TestResult();
        SortArray sortArray = new SortArray(array,sortingAlgorithms);
         long startTime = System.nanoTime();
         testResult.sorted = sortArray.test();
         long endTime = System.nanoTime();
         long nanoTime = (endTime - startTime);
         double microTime =( (double) (endTime- startTime) )/10E3;
         double milliTime = ( (double) (endTime- startTime) )/10E6;
         testResult.time = (nanoTime + " ns "+ microTime + " micro "+milliTime+" ms");
          return testResult;
     }


    public static void main(String[] args) {
        int [] a = Helper.getRandomArray(0,6,5);
        for(int i : a){
            System.out.print(i+ " ");
        }
    }


}
