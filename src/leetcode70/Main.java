package leetcode70;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().climbStairs(44));//1134903170
    }

//    //递归
//    Map<Integer, Integer> m = new HashMap<>();
//    public int climbStairs(int n) {
//        if(n == 0) {
//            return 0;
//        } else if(n == 1) {
//            return 1;
//        } else if(n == 2) {
//            return 2;
//        }
//        if(m.get(n) != null)
//            return m.get(n);
//
//        int ans = climbStairs(n-1) + climbStairs(n-2);
//        m.put(n, ans);
//        return ans;
//    }
    public int climbStairs(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }

        int p1 = 2;
        int p2 = 1;
        int sum = 0;
        for(int i = 2; i < n; i++) {
            sum = p1 + p2;
            p2 = p1;
            p1 = sum;
        }

        return sum;
    }
}
