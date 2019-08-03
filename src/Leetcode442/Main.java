package Leetcode442;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicates(new int[]{5, 5, 4, 4, 7, 7, 8, 8, 1, 1, 6}).toString());
        System.out.println(new Solution().findDuplicates(new int[]{3,11,8,16,4,15,4,17,14,14,6,6,2,8,3,12,15,20,20,5}).toString());
    }

}

class Solution {
    //用了额外空间
//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> ans = new ArrayList<>();
//        boolean[] bucket = new boolean[nums.length];
//        for(int i : nums) {
//            if(bucket[i - 1])
//                ans.add(i);
//            else
//                bucket[i - 1] = true;
//        }
//        return ans;
//    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int j = 0;
        while(j < nums.length) {// 将数字移动到对应的下标位置
            if(nums[nums[j] - 1] != nums[j]) {//交换过之后，当前元素可能没有比较过
                swap(nums, nums[j] - 1, j);
            } else {
                j ++;
            }
        }
        for(int i = 0; i < nums.length; i++) {// 不在自己下标位置，并且对应下标位置数字与自己一样的，都是重复数字
            if(nums[i] - 1 != i && nums[nums[i] - 1] == nums[i]) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        if(i == j)
            return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
