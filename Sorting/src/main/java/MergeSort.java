import com.sun.source.tree.BinaryTree;

import javax.swing.*;

public class MergeSort implements ISortingAlgorithms{
   int [] copyArray;
   int [] temp;
   boolean steps;
   BinaryTree bt;
    @Override
    public int[] sort(int[] array, boolean steps) {
        this.steps=steps;
        int len=array.length;
        this.temp= new int[len];
        this.copyArray=array.clone();
        mySort(0,len-1);
        return this.copyArray ;
    }
    private void merge(int l, int r,int mid){

        if (r + 1 - l >= 0) System.arraycopy(this.copyArray, l, this.temp, l, r + 1 - l);
        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){
            if(i>mid) this.copyArray[k]=temp[j++];
            else if(j>r) this.copyArray[k]=temp[i++];
            else{
                if(temp[i]<temp[j]) this.copyArray[k]=temp[i++];
                else this.copyArray[k]=temp[j++];
            }

        }

    }
     private void mySort(int l ,int r){

        if(r<=l) return;
        int mid=(l+r)/2;
        if (steps) print(l,mid);
        mySort(l,mid);
         if (steps) print(mid+1,r);
        mySort(mid+1,r);

        if(copyArray[mid]<this.copyArray[mid+1]) return;
        merge(l,r,mid);


     }
    private void print(int l,int r){
//        System.out.print("[ ");
//        for(int i=l;i<=mid;i++){
//            System.out.print(copyArray[i]+" ");
//            if(i!=mid) System.out.print(",");
//        }
//        System.out.print("]");
//        System.out.print("<===========================>");
    System.out.print("[ ");
        for(int i=l;i<=r;i++){
            System.out.print(copyArray[i]+" ");
            if(i!=r) System.out.print(",");
        }
        System.out.print("]");
        System.out.println();

    }

     public static void main(String[] args) {
        int []a={2,3,6,7,8,1,5};
        ISortingAlgorithms m=new MergeSort();
       int []res=  m.sort(a,true);
         System.out.print("[ ");
         for(int i=0;i<a.length;i++){
             System.out.print(res[i]+" ");
             if(i!= a.length-1) System.out.print(",");
         }
         System.out.print("]");
         System.out.println();
    }

}