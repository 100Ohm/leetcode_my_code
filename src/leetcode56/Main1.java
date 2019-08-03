package leetcode56;

/**
 * @author ohm
 */

import java.util.Arrays;
import java.util.Comparator;

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
public class Main1 {
    public static void main(String[] args) {
//        int[][] arr = new int[][]{
//                new int[]{1,3},
//                new int[]{2,6},
//                new int[]{8,10},
//                new int[]{15,18}
//        };
        //[[0,2],[2,3],[4,4],[0,1],[5,7],[4,5],[0,0]]
        int[][] arr = new int[][]{
                new int[]{0,2},
                new int[]{2,3},
                new int[]{4,4},
                new int[]{0,1},
                new int[]{5,7},
                new int[]{4,5},
                new int[]{0,0},
        };
        int[][] ans = merge(arr);
        for(int[] i : ans) {
            System.out.print(Arrays.toString(i) + " ");
        }
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (o1, o2) -> {//区间先排序
            if(o1[0] > o2[0])
                return 1;
            else if(o1[0] < o2[0])
                return -1;
            return 0;
        });

        int i = 0, j = 1;//待合并的两个数组
        int p = 0;//减少的个数，要往前移动的大小
        while(j < intervals.length) {//如果有交集就向前合并区间
            if(intervals[i][1] >= intervals[j][0]) {
                p ++;
                intervals[j - p][0] = Math.min(intervals[i][0], intervals[j][0]);
                intervals[j - p][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else {//否则就单纯往前移动
                intervals[j - p] = intervals[j];
                i = j;
            }
            j++;
        }
        int[][] ans = new int[intervals.length - p][];
        System.arraycopy(intervals, 0, ans, 0, intervals.length - p);
        return ans;
    }
}
