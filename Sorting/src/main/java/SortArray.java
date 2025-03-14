import java.awt.print.PrinterIOException;
import java.io.*;
import java.util.Scanner;

public class SortArray {
    int[] array;
    boolean steps;
    ISortingAlgorithms sortingAlgorithms;

    public SortArray(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        bufferedReader.close();
        fileReader.close();
        String[] tokens = line.split(", ");
        int n = tokens.length;
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }
    }

    public void print(int[] sorted, int n) {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i != n - 1)
                System.out.print(sorted[i] + ", ");
            else
                System.out.print(sorted[i]);
        }
        System.out.println("]");
    }

    public void simpleSort(boolean steps) {
        ISortingAlgorithms bubbleSort = new BubbleSort();
        int[] sorted = bubbleSort.sort(array, steps);
        if (!steps) {
            System.out.println("Final Sorted Array (BubbleSort):");
            print(sorted, sorted.length);
        }
    }

    public void efficientSort(boolean steps) {
        ISortingAlgorithms mergeSort = new MergeSort();
        int[] sorted = mergeSort.sort(array, steps);
        if (!steps) {
            System.out.println("Final Sorted Array (MergeSort):");
            print(sorted, sorted.length);
        }
    }

    public void nonComparisonSort(boolean steps) {
        ISortingAlgorithms countingSort = new CountingSort();
        int[] sorted = countingSort.sort(array, steps);
        if (!steps) {
            System.out.println("Final Sorted Array (CountingSort):");
            print(sorted, sorted.length);
        }
    }

    SortArray(int[] array, ISortingAlgorithms sortingAlgorithms) {
        this.array = array;
        this.sortingAlgorithms = sortingAlgorithms;
    }

    public void sort() {
        if (sortingAlgorithms == null) return;
        int[] sorted = sortingAlgorithms.sort(array, steps);
        if (!steps) print(sorted, sorted.length);
    }

    public int[] test() {
        if (sortingAlgorithms == null) return null;
        return sortingAlgorithms.sort(array, steps);
    }


    public static void main(String[] args) throws IOException, PrinterIOException {
        System.out.print("Enter File Name : ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        File file = new File(fileName + ".txt");
        try {
            SortArray sortArray = new SortArray(file);
            System.out.print("Enter 1 to print steps otherwise 0: ");
            int inSteps = in.nextInt();
            boolean steps = inSteps == 1;
            System.out.println("Choose type of Algorithm : ");
            System.out.println("1.Bubble Sort            2.Merge Sort          3.Counting Sort");
            int type = in.nextInt();
            switch (type) {
                case 1:
                    sortArray.simpleSort(steps);
                    break;
                case 2:
                    sortArray.efficientSort(steps);
                    break;
                case 3:
                    sortArray.nonComparisonSort(steps);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND !!");
        }
    }

}



