package leetcode204;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出＜n的质数的个数
 * @author ohm
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(countPrimes(499979));
    }

    public static int countPrimes(int n) {
        if(n <= 0)
            return 0;
        boolean[] nums = new boolean[n];
        for (int i = 2; i < n; i++) {//全部置为true;
            nums[i] = true;
        }

        //比如i是3，i*i就是9，从9开始找，而2*i之前已经排除过了
        for(int i = 2; i*i < nums.length; i++) {
            if(nums[i]) {
                for (int j = i*i; j < nums.length; j+=i) {
                    nums[j] = false;
                }
            }
        }
        int ans = 0;
        for (boolean b : nums) {
            ans += b ? 1 : 0;
        }
        return ans;
    }
}
