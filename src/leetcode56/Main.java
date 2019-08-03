package leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                new int[]{1,3},
                new int[]{2,6},
                new int[]{8,10},
                new int[]{15,18}
        };
        int[][] ans = merge(arr);
        for(int[] i : ans) {
            System.out.print(Arrays.toString(i) + " ");
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {//预排序
            if(o1[0] > o2[0])
                return 1;
            else if(o1[0] < o2[0])
                return -1;
            return 0;
        });

        int a = 0;//比较的第一个区间下标
        int b = 1;//比较的第二个区间下标
        int size = intervals.length;//数组大小
        int[] a1, a2;
        while(b < intervals.length) {//合并区间
            a1 = intervals[a];
            a2 = intervals[b];
            if(a1[1] >= a2[0]) {
                a1[0] = Math.min(a1[0], a2[0]);
                a1[1] = Math.max(a1[1], a2[1]);
                intervals[b] = null;
                size--;
            } else {
                a = b;
            }
            b++;
        }

        int[][] ansArr = new int[size][];
        int p = 0;
        for (int i = 0; i < size; i++) {//复制不为空的序列出来
            while(p < intervals.length && intervals[p] == null) {
                p++;
            }
            ansArr[i] = intervals[p];
            p++;
        }

        return ansArr;
    }
}
