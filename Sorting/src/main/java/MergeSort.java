import com.sun.source.tree.BinaryTree;

public class MergeSort implements ISortingAlgorithms {
    int[] copyArray;
    int[] temp;
    boolean steps;
    BinaryTree bt;

    @Override
    public int[] sort(int[] array, boolean steps) {
        this.steps = steps;
        int len = array.length;
        this.temp = new int[len];
        this.copyArray = array.clone();
        int level = 0;
        mySort(0, len - 1, level);
        return this.copyArray;
    }

    private void merge(int l, int r, int mid) {

        if (r + 1 - l >= 0) System.arraycopy(this.copyArray, l, this.temp, l, r + 1 - l);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) this.copyArray[k] = temp[j++];
            else if (j > r) this.copyArray[k] = temp[i++];
            else {
                if (temp[i] < temp[j]) this.copyArray[k] = temp[i++];
                else this.copyArray[k] = temp[j++];
            }

        }

    }

    private void mySort(int l, int r, int level) {

        if (r <= l) return;

        int mid = (l + r) / 2;
        if (steps) printStep(l, r, mid, level);
        mySort(l, mid, level + 1);
        mySort(mid + 1, r, level + 1);
        if (copyArray[mid] < this.copyArray[mid + 1]) return;
        merge(l, r, mid);
        if (steps) printMerge(l, r, level);

    }

    private void printStep(int l, int r, int m, int level) {
        String indent = "  ".repeat(level);
        System.out.println(indent + "Level " + level + " :" + arrayToString(l, m) + " and " + arrayToString(m + 1, r));
    }

    private void printMerge(int l, int r, int level) {
        String indent = "  ".repeat(level);
        System.out.println(indent + "merged level " + level + " :" + arrayToString(l, r));
    }

    private String arrayToString(int l, int r) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = l; i <= r; i++) {
            sb.append(copyArray[i]);
            if (i < r) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 8, 1, 5};
        ISortingAlgorithms m = new MergeSort();
        int[] res = m.sort(a, true);
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(res[i] + " ");
            if (i != a.length - 1) System.out.print(",");
        }
        System.out.print("]");
        System.out.println();
    }

}


