//package hi;
//
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.infra.Blackhole;
//import org.openjdk.jmh.results.RunResult;
//import org.openjdk.jmh.runner.Runner;
//import org.openjdk.jmh.runner.options.Options;
//import org.openjdk.jmh.runner.options.OptionsBuilder;
//
//import java.util.Collection;
//import java.util.concurrent.TimeUnit;
//
//@BenchmarkMode(Mode.AverageTime) // Measure average time
//@OutputTimeUnit(TimeUnit.MILLISECONDS) // Output time in milliseconds
//@State(Scope.Benchmark) // State is shared across all threads
//public class SortingBenchmark {
//
//    // Arrays for each test case
//    private int[] array1K;
//    private int[] array10K;
//    private int[] array50K;
//    private int[] array100K;
//    private int[] array500K;
//    private int[] array1M;
//    private int[] array100KSorted;
//    private int[] array100KReversed;
//    private int[] array10;
//    private final ISortingAlgorithms bubble = new BubbleSort();
//    private final ISortingAlgorithms merge = new MergeSort();
//    private final ISortingAlgorithms Counting = new CountingSort();
//
//    // Initialize arrays
//    @Setup(Level.Iteration)
//    public void setup() {
//        array1K = Helper.getRandomArray(1, 1000, 1000);
//        array10K = Helper.getRandomArray(1, 1000, 10000);
//        array50K = Helper.getRandomArray(1, 10000, 50000);
//        array100K = Helper.getRandomArray(1, 100000, 100000);
//        array500K = Helper.getRandomArray(1, 100000, 500000);
//        array1M = Helper.getRandomArray(1, 100000, 1000000);
//
//        array100KSorted = new int[100000];
//        for (int i = 0; i < 100000; i++) {
//            array100KSorted[i] = i;
//        }
//
//        array100KReversed = new int[100000];
//        for (int i = 0, j = 100000; i < 100000; i++, j--) {
//            array100KReversed[i] = j;
//        }
//
//        array10 = new int[]{1, 5, 7, 8, 4, 4, 8, 9, 4, 10};
//    }
//
//    // Benchmark methods for 1K array
//    @Benchmark
//    public void test1K_BubbleSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array1K, bubble));
//    }
//
//    @Benchmark
//    public void test1K_MergeSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array1K, merge));
//    }
//
//    @Benchmark
//    public void test1K_CountingSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array1K, Counting));
//    }
//
//    // Benchmark methods for 10K array
//    @Benchmark
//    public void test10K_BubbleSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array10K, bubble));
//    }
//
//    @Benchmark
//    public void test10K_MergeSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array10K, merge));
//    }
//
//    @Benchmark
//    public void test10K_CountingSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array10K, Counting));
//    }
//
//    // Benchmark methods for 50K array
//    @Benchmark
//    public void test50K_BubbleSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array50K, bubble));
//    }
//
//    @Benchmark
//    public void test50K_MergeSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array50K, merge));
//    }
//
//    @Benchmark
//    public void test50K_CountingSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array50K, Counting));
//    }
//
//    // Benchmark methods for 100K array
//    @Benchmark
//    public void test100K_BubbleSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array100K, bubble));
//    }
//
//    @Benchmark
//    public void test100K_MergeSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array100K, merge));
//    }
//
//    @Benchmark
//    public void test100K_CountingSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array100K, Counting));
//    }
//
//    // Benchmark methods for 500K array
//    @Benchmark
//    public void test500K_MergeSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array500K, merge));
//    }
//
//    @Benchmark
//    public void test500K_CountingSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array500K, Counting));
//    }
//
//    // Benchmark methods for 1M array
//    @Benchmark
//    public void test1M_MergeSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array1M, merge));
//    }
//
//    @Benchmark
//    public void test1M_CountingSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array1M, Counting));
//    }
//
//    // Benchmark methods for 100K sorted array
//    @Benchmark
//    public void test100KSorted_BubbleSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array100KSorted, bubble));
//    }
//
//    @Benchmark
//    public void test100KSorted_MergeSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array100KSorted, merge));
//    }
//
//    @Benchmark
//    public void test100KSorted_CountingSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array100KSorted, Counting));
//    }
//
//    // Benchmark methods for 100K reversed array
//    @Benchmark
//    public void test100KReversed_BubbleSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array100KReversed, bubble));
//    }
//
//    @Benchmark
//    public void test100KReversed_MergeSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array100KReversed, merge));
//    }
//
//    @Benchmark
//    public void test100KReversed_CountingSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array100KReversed, Counting));
//    }
//
//    // Benchmark methods for 10-element array
//    @Benchmark
//    public void test10_BubbleSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array10, bubble));
//    }
//
//    @Benchmark
//    public void test10_MergeSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array10, merge));
//    }
//
//    @Benchmark
//    public void test10_CountingSort(Blackhole bh) {
//        bh.consume(Helper.showTime(array10, Counting));
//    }
//
//    // Main method to run benchmarks and print results
//    public static void main(String[] args) throws Exception {
//        // Run the benchmarks
//        Options opt = new OptionsBuilder()
//                .include(SortingBenchmark.class.getSimpleName())
//                .forks(1) // Number of JVM forks
//                .warmupIterations(5) // Warm-up iterations
//                .measurementIterations(10) // Measurement iterations
//                .build();
//
//        Collection<RunResult> results = new Runner(opt).run();
//
//        // Print custom output
//        printResults(results);
//    }
//
//    // Method to print results in the desired format
//    private static void printResults(Collection<RunResult> results) {
//        System.out.println("Size = 1K");
//        printResult(results, "test1K_BubbleSort", "Test One Bubble");
//        printResult(results, "test1K_MergeSort", "Test One Merge");
//        printResult(results, "test1K_CountingSort", "Test One Counting");
//        System.out.println("================================================================================");
//
//        System.out.println("Size = 10K");
//        printResult(results, "test10K_BubbleSort", "Test Two Bubble");
//        printResult(results, "test10K_MergeSort", "Test Two Merge");
//        printResult(results, "test10K_CountingSort", "Test Two Counting");
//        System.out.println("================================================================================");
//
//        System.out.println("Size = 50K");
//        printResult(results, "test50K_BubbleSort", "Test Three Bubble");
//        printResult(results, "test50K_MergeSort", "Test Three Merge");
//        printResult(results, "test50K_CountingSort", "Test Three Counting");
//        System.out.println("================================================================================");
//
//        System.out.println("Size = 100K");
//        printResult(results, "test100K_BubbleSort", "Test Four Bubble");
//        printResult(results, "test100K_MergeSort", "Test Four Merge");
//        printResult(results, "test100K_CountingSort", "Test Four Counting");
//        System.out.println("================================================================================");
//
//        System.out.println("Size = 500K");
//        printResult(results, "test500K_MergeSort", "Test Five Merge");
//        printResult(results, "test500K_CountingSort", "Test Five Counting");
//        System.out.println("================================================================================");
//
//        System.out.println("Size = 1M");
//        printResult(results, "test1M_MergeSort", "Test Six Merge");
//        printResult(results, "test1M_CountingSort", "Test Six Counting");
//        System.out.println("================================================================================");
//
//        System.out.println("Size = 100K Sorted");
//        printResult(results, "test100KSorted_BubbleSort", "Test Seven Bubble");
//        printResult(results, "test100KSorted_MergeSort", "Test Seven Merge");
//        printResult(results, "test100KSorted_CountingSort", "Test Seven Counting");
//        System.out.println("================================================================================");
//
//        System.out.println("Size = 100K Reversed");
//        printResult(results, "test100KReversed_BubbleSort", "Test Eight Bubble");
//        printResult(results, "test100KReversed_MergeSort", "Test Eight Merge");
//        printResult(results, "test100KReversed_CountingSort", "Test Eight Counting");
//        System.out.println("================================================================================");
//
//        System.out.println("Size = 10");
//        printResult(results, "test10_BubbleSort", "Test Nine Bubble");
//        printResult(results, "test10_MergeSort", "Test Nine Merge");
//        printResult(results, "test10_CountingSort", "Test Nine Counting");
//        System.out.println("================================================================================");
//    }
//
//    // Helper method to print individual benchmark results
//    private static void printResult(Collection<RunResult> results, String benchmarkName, String testName) {
//        for (RunResult result : results) {
//            if (result.getPrimaryResult().getLabel().contains(benchmarkName)) {
//                double score = result.getPrimaryResult().getScore();
//                System.out.printf("Average Time Taken by %s (100 runs): %.4f ms%n", testName, score);
//                break;
//            }
//        }
//    }
//}