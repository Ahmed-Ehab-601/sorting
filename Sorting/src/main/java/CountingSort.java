import java.util.Arrays;

public class CountingSort implements ISortingAlgorithms {
    @Override
    public int[] sort(int[] array, boolean steps) {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        int range = max - min + 1;
        if (range > 100000) {
            System.out.println("range is not feasible");
            return null;
        }
        int[] sorted = new int[array.length];
        int[] count = new int[range];
        for (int num : array) {
            count[num - min]++;
        }
        if (steps) {
            System.out.print("Frequency Array: ");
            Helper.print(count, count.length);
        }
        int pointer = 0;
        for (int i = 0; i < range; i++) {
            int repeated = count[i];
            Arrays.fill(sorted, pointer, pointer + repeated, i + min);
            pointer += repeated;
            if (steps && repeated != 0) Helper.print(sorted, pointer);
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] a = {0, 5, 7, 7, 8, 4, 6, 10, 100000};
        CountingSort countingSort = new CountingSort();
        int[] b = countingSort.sort(a, true);
    }
}
