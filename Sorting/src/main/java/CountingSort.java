import java.util.Arrays;

public class CountingSort implements ISortingAlgorithms{
    @Override
    public int[] sort(int[] array, boolean steps) {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        int range = max-min+1;
        if(range > 50000){
            System.out.println("range is not feasible");
            return null;
        }
        int [] sorted = new int[array.length];
        int [] count = new int[range];
        for(int num : array){
            count[num-min]++;
        }
        if(steps){
            System.out.print("Frequency Array: ");
            Helper.print(count,count.length);
        }
        int pointer = 0;
        for(int i=0;i<range;i++){
            int repeated = count[i];
            for(int j =0;j<repeated;j++){
                sorted[pointer] = i+min;
                pointer++;
            }
            if(steps && repeated!=0) Helper.print(sorted,pointer);
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] a = {1,5,7,7,8,4,6,10,5};
        CountingSort countingSort = new CountingSort();
        int [] b = countingSort.sort(a,true);
    }
}
