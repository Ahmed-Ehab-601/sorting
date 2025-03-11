public class SortFactory {
    public ISortingAlgorithms sortingAlgorithms(String type){
        if (type.equalsIgnoreCase("bubble")) {
            return new BubbleSort();
        } else if (type.equalsIgnoreCase("merge")) {
            return new MergeSort();
        }
        else {
            return new CountingSort();
        }
    }
}
