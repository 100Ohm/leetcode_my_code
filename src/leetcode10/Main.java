package leetcode10;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("a", "aa"));
    }
}

/**
 * 自己写一次
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty())
            return s.isEmpty();

        boolean isFirstMatch = !s.isEmpty() &&
                (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if(p.length() >= 2 && p.charAt(1) == '*') {
            return (!isFirstMatch && isMatch(s, p.substring(2)))
                    || (isFirstMatch && isMatch(s.substring(1), p));
        } else {
            return isFirstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}

































// 最好理解的题解 自己默写一次
//class Solution {
//    public boolean isMatch(String s, String p) {
//        if (p.isEmpty()) return s.isEmpty();
//        //第一个字符是否匹配
//        boolean first_match = (!s.isEmpty() &&
//                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
//
//        // 如果正则表达式长度大于2且第二位是*，
//        // 那么匹配s和正则的后续部分，（因为有可能压根没出现这个字母）
//        // 如果不匹配，那么当第一个字符匹配的时候，匹配去除第一个字母后的s和正则
//        if (p.length() >= 2 && p.charAt(1) == '*'){
//            return (isMatch(s, p.substring(2)) ||
//                    (first_match && isMatch(s.substring(1), p)));
//        } else {
//            // 如果不是*，那就可以继续匹配下一个字符了
//            return first_match && isMatch(s.substring(1), p.substring(1));
//        }
//    }
//}