import static java.util.Collections.swap;

public class BubbleSort implements ISortingAlgorithms{

    @Override
    public int[] sort(int[] array, boolean steps) {
    int [] sorted= array.clone();
    int n=array.length;
    boolean swapped;

    for (int j = n - 1; j > 0; j--) {
        swapped=false;
            for (int i = 0; i < j; i++) {
                if (sorted[i] > sorted[i + 1]) {
                    int tmp=sorted[i];
                    sorted[i]=sorted[i+1];
                    sorted[i+1]=tmp;
                     swapped=true;
                }
            }if(steps) {
           Helper.print(sorted,sorted.length);}
            if(swapped==false) break;
        }
        return sorted;

    }


    public static void main(String[] args) {
        int[] arr = {6, 4, 8, 7, 0, 1, 9, 25};
        BubbleSort bubbleSort = new BubbleSort();
        int[] sortedArr = bubbleSort.sort(arr, true);

        System.out.print("Final Sorted Array: ");
        Helper.print(sortedArr,sortedArr.length);
    }
}
