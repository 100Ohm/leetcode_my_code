package leetcode122;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
class Solution {
    //122
    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i+1])
                ans += prices[i+1] - prices[i];
        }
        return ans;
    }

    //242. 有效的字母异位词(应该没通过)
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer times = map.get(c);
            if(times == null)
                map.put(c, 1);
            else
                map.put(c, times+1);
        }
        for (char c : t.toCharArray()) {
            Integer times = map.get(c);
            if(times == null)
                return false;
            else if(times == 0)
                map.remove(c);
            else
                map.put(c, times-1);
        }
        if(map.isEmpty())
            return true;
        return false;
    }

    //快乐数
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        double num = 0;
        while(true) {
            while (doubleIsZero(num)) {
                num = num + Math.pow(n % 10, 2);
                n /= 10;
            }
            if(doubleEqual(num, 1d))
                return true;
            else if (!set.add((int) num))
                return false;
            n = (int) num;
            num = 0;
        }
    }

    private boolean doubleIsZero(double num) {
        return Math.abs(num) < 0.0000001d;
    }

    private boolean doubleEqual(double num, double v) {
        double ans = v-num;
        return Math.abs(ans) < 0.0000001d;
    }
}