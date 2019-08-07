package leetcode67;

import javafx.util.Pair;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "11"));

    }
    public static String addBinary(String a, String b) {
        if(a.isEmpty() ^ b.isEmpty())
            return a.isEmpty() ? b : a;
        StringBuilder sb = new StringBuilder();
        int p = 1;//迭代位置
        int plus = 0;//进位
        while(true) {
            if(a.length() - p < 0 && b.length() - p < 0) {
                if(plus != 0)
                    sb.append("1");
                break;
            }
            int n1 = a.length() - p >= 0 ? a.charAt(a.length() - p) - '0' : 0;
            int n2 = b.length() - p >= 0 ? b.charAt(b.length() - p) - '0' : 0;
            int sum = n1 + n2 + plus;
            plus = sum / 2;
            sb.append(Integer.toString(sum % 2));
            p++;
        }
        return sb.reverse().toString();
    }
}
