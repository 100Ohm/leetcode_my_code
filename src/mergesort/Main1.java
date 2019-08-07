package mergesort;

import java.util.Arrays;

/**
 * 再刷一次归并
 * @author ohm
 */
public class Main1 {
    public static void main(String[] args) {
        int[] a = new int[]{57,6,32,7,6,487,53,232,543,65};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 递归归并排序
     * @param arr 元数组
     * @param l 左边第一个元素位置
     * @param r 右边最后一个元素位置
     */
    private static void mergeSort(int[] arr, int l, int r) {
        if(r <= l)
            return;
        int mid = l + (r - l)/2;//第一个子串最后一个位置
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        int[] copyArr = new int[r - l + 1];
        System.arraycopy(arr, l, copyArr, 0, copyArr.length);
        int a = l, b = mid + 1;
        for(int i = l; i <= r; i ++) {
            if(a > mid) {
                arr[i] = copyArr[b - l];
                b++;
            } else if(b > r) {
                arr[i] = copyArr[a - l];
                a++;
            } else if(copyArr[a - l] > copyArr[b - l]) {
                arr[i] = copyArr[b - l];
                b++;
            } else {
                arr[i] = copyArr[a - l];
                a++;
            }
        }
    }
}
