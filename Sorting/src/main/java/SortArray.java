import java.io.*;

public class SortArray {
    int [] array;
    ISortingAlgorithms sortingAlgorithms;
    boolean steps;

    public void print(int [] sorted,int n) {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if(i!=n-1)
                System.out.print(sorted[i]+", ");
            else
                System.out.print(sorted[i]);
        }
        System.out.println("]");
    }
    SortArray(File file, ISortingAlgorithms sortingAlgorithms, boolean steps) throws IOException {

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        bufferedReader.close();
        fileReader.close();
        String [] tocken = line.split(", ");
        int n = tocken.length;
        array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(tocken[i]);
        }
    }
    SortArray(int [] array, ISortingAlgorithms sortingAlgorithms){
        this.array = array;
        this.sortingAlgorithms = sortingAlgorithms;
    }

    public void sort(){
        if(sortingAlgorithms == null) return;
        int [] sorted = sortingAlgorithms.sort(array,steps);
        if(!steps) print(sorted,sorted.length);
    }
    public int [] test(){
        if(sortingAlgorithms == null) return null;
        return sortingAlgorithms.sort(array,steps);
    }




    public static void main(String[] args) {
        // read file

        // bool

        // 3 types of algo

        //.sort

    }


}
