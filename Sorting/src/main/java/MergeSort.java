public class MergeSort implements ISortingAlgorithms{
   int [] array;
   int [] temp;
    @Override
    public int[] sort(int[] array, boolean steps) {
        int len=array.length;
        this.temp= new int[len];
        this.array=array.clone();
        mySort(0,len-1);
        return array ;
    }
    private void merge(int l, int r,int mid){

        if (r + 1 - l >= 0) System.arraycopy(this.array, l, this.temp, l, r + 1 - l);
        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){
            if(i>mid) this.array[k]=temp[j++];
            else if(j>r) this.array[k]=temp[i++];
            else{
                if(temp[i]<temp[j]) this.array[k]=temp[i++];
                else this.array[k]=temp[j++];
            }

        }

    }
     private void mySort(int l ,int r){
        if(r<=l) return;
        int mid=(l+r)/2;
        mySort(l,mid);
        mySort(mid+1,r);
        if(array[mid]<this.array[mid+1]) return;
        merge(l,r,mid);
        print(l,r);

    }
    private void print(int l ,int r){
        System.out.println("[ ");
        for(int i=l;i<=r;i++){
            System.out.println(array[i]+" ");
            if(i!=r) System.out.println(",");
        }
        System.out.println(" ]");
        System.out.println();

    }
}