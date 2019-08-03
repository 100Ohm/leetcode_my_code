package leetcode283;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        int[] num = {0, 0, 1, 2, 0, 3, 4, 5, 0, 0};
        moveZeroes(num);
        System.out.println(Arrays.toString(num));
    }
    public static void moveZeroes(int[] nums) {
        int k = 0;//用于表示当前的非0数组填充位置
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                swap(nums,i,k++);
            }
        }
        //自己写的垃圾算法：冒泡
//        boolean flag = true;
//        int n = 0;
//        int i = 0;
//        while(n < nums.length) {
//            for(; i < nums.length - n - 1; i ++){
//                if(nums[i] == 0 && nums[i + 1] != 0) {
//                    swap(nums, i, i + 1);
//                    flag = false;
//                }
//            }
//            if(flag)
//                break;
//            flag = true;
//            i = 0;
//            n++;
//        }
    }

    private static void swap(int[] nums, int i, int j) {
        if(i == j)
            return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
