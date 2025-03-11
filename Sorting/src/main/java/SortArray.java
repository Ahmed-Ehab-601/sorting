import java.awt.print.PrinterIOException;
import java.io.*;
import java.util.Scanner;

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




    public static void main(String[] args) throws IOException, PrinterIOException {
        System.out.print("Enter File Name : ");
        Scanner in= new Scanner(System.in);
        String fileName = in.nextLine();
        File file= new File(fileName+".txt");
        System.out.print("Enter 1 to print steps otherwise 0: ");
        int inSteps= in.nextInt();
        boolean steps= inSteps == 1;
        System.out.println("Choose type of Algorithm : ");
        System.out.println("1.Bubble Sort            2.Merge Sort          3.Counting Sort");
        int type= in.nextInt();
        String algoType=(type==1)?("bubble"):
                (type==2)?("merge") : ("counting");
         SortFactory sortFactory=new SortFactory();
         ISortingAlgorithms algorithm=sortFactory.sortingAlgorithms(algoType);

         try {
             SortArray sortArray=new SortArray(file,algorithm,steps);
             sortArray.sort();
         } catch (IOException e) {
             System.out.println("FILE NOT FOUND !!");}
        }


    }


}
