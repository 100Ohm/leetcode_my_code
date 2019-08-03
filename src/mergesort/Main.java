package mergesort;

import java.util.Arrays;

/**
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{57,6,32,7,6,487,53,232,543,65};
        mergeSort(a, 0, a.length - 1, (a.length - 1) / 2);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 递归归并排序
     * @param arr 元数组
     * @param left 左边第一个元素位置
     * @param right 右边最后一个元素位置
     * @param mid 左边待排序队列中最后一个一个元素的位置
     */
    private static void mergeSort(int[] arr, int left, int right, int mid) {
        if(left >= right)
            return;
        mergeSort(arr, left, mid, left + (mid - left)/2);
        mergeSort(arr, mid + 1, right, mid + 1 +(right - mid - 1)/2);

        //复制数组
        int[] copyArr = new int[right - left + 1];
        System.arraycopy(arr, left, copyArr, 0, copyArr.length);

        //归并
        int a = left, b = mid + 1, t = left;// 待排序左右串指针(用a-l，b-l来表示)，目标指针。
        while(t <= right) {
            if(a > mid) {
                arr[t] = copyArr[b - left];
                b++;
            } else if(b > right) {
                arr[t] = copyArr[a - left];
                a++;
            } else if(copyArr[a - left] <= copyArr[b - left]) {
                arr[t] = copyArr[a - left];
                a++;
            } else {
                arr[t] = copyArr[b - left];
                b++;
            }
            t++;
        }
    }

//    private static void mergeSortNR(int[] arr) {
//        int l = 1;//待排序队列长度
//        int p = 0;//排序下标
//        while(l < arr.length) {
//            while(p < arr.length) {
//                int p1 = p;
//                int p2 = p + l;
//                int[] a1 = new int[l];
//                int[] a2 = new int[l];
//                System.arraycopy(arr, p1, a1, 0, l);
//                System.arraycopy(arr, p2, a1, 0, l);
//                while(p1 < arr.length && p2 < arr.length && p1 < p + l && p2 < p + 2l){
//
//                }
//                p += 2 * l;
//            }
//        }
//    }
}
