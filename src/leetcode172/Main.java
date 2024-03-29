package leetcode172;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 *
 * @author ohm
 */
public class Main {
    public static int trailingZeroes(int n) {
        //解释：
        //因为是阶乘后的0
        //0是由于2*5得出一个0
        //因此便是求2*5有多少个
        //因为2<5
        //有5一定有2
        //因此便是求5的个数
        int count = 0;
        while(n >= 5) {//大于等于5才算
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}

