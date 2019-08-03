package leetcode58;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * @author ohm
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        if(!s.contains(" "))
            return s.length();
        int n = s.lastIndexOf(' ');
        return s.length() - n - 1;
    }
}
