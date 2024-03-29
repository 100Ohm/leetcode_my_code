package leetcode121;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * @author ohm
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;
        int p;
        for(int i = 0; i < prices.length; i ++) {
            if(prices[i] < minPrices)
                minPrices = prices[i];
            else if((p = prices[i] - minPrices) > maxProfit)
                maxProfit = p;
        }
        return maxProfit;
    }
}
