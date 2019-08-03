package leetcode122;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
class Solution {
    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i+1])
                ans += prices[i+1] - prices[i];
        }
        return ans;
    }

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