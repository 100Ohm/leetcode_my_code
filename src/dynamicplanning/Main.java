package dynamicplanning;

/**
 * 经典的动态规划问题：
 * 一共有N个物品，每个的价值为value[i]，重量为weight[i]
 * 背包容量为bv，
 *
 * int bv = 10 ;
 * int n = 5 ;
 *
 * int value[] = {0, 8 , 10 , 4 , 5 , 5};
 * int weight[] = {0, 6 , 4 , 2 , 4 , 3};
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(maxValue(10, 5, new int[]{0, 8, 10, 4, 5, 5}, new int[]{0, 6, 4, 2, 4, 3}));
    }
    private static int maxValue(int bv, int n, int[] value, int[] weight) {
        int[][] dp = new int[bv + 1][n + 1];

        for(int i = 1; i <= bv; i++) {
            for(int j = 1; j <= n; j++) {
                if(i > weight[j])
                    dp[i][j] = Math.max(dp[i][j-1], dp[i - weight[j]][j-1] + value[j]);
                else
                    dp[i][j] = dp[i][j-1];
            }
        }
        return dp[bv][n];
    }
}
