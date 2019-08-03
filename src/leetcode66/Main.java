package leetcode66;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{8, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
    }

    public static int[] plusOne(int[] digits) {
        if(digits.length == 0)
            return digits;
        int[] ans = add1(digits, digits.length - 1, 1);
        return ans;
    }

    private static int[] add1(int[] nums, int i, int plus) {
        if(plus == 0)
            return nums;
        if(i < 0) {
            int[] ans = new int[nums.length + 1];
            ans[0] = plus;
            System.arraycopy(nums, 0, ans, 1, nums.length);
            return ans;
        }

        int tmp = nums[i] + plus;
        int np = tmp / 10;
        nums[i] = tmp % 10;
        return add1(nums, --i, np);
    }

}
