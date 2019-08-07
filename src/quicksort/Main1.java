package quicksort;

import java.util.Arrays;

/**
 * 快排，再来一次
 * @author ohm
 */
public class Main1 {
    public static void main(String[] args) {
        int[] a = new int[]{57,6,32,7,6,487,53,232,543,65};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 排序一个区间，[l,r]
     * @param arr
     * @param l
     * @param r
     */
    public static void quickSort(int[] arr, int l, int r) {
        if(l > r)
            return;
        int p = l;
        for(int i = l + 1; i <= r; i++) {
            if(arr[i] <= arr[l])
                swap(arr, ++p, i);
        }
        swap(arr, p, l);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
