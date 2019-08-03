package quicksort;

import java.util.Arrays;

/**
 * @author ohm
 * 手撕快速排序
 */
public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{57,6,32,7,6,487,53,232,543,65};
        quickSort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 递归快排
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end){
        if(end - start <= 0)
            return;
        int p = start;//分割<=flag, >flag
        int i = start + 1;//当前判断数字
        while(i < end) {
            if(arr[i] <= arr[start]){
                swap(arr, i, ++p);
            }
            i++;
        }
        swap(arr, start, p);
        quickSort(arr, start, p);
        quickSort(arr, p + 1, end);
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
