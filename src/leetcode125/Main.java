package leetcode125;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * @author ohm
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abbA"));
        System.out.println(isPalindrome("aabb"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        int a = 0, b = s.length() - 1;
        while(a <= b) {
            if(isWD(s.charAt(a)) && isWD(s.charAt(b))) {
                if(Character.isAlphabetic(s.charAt(a)) && Character.isAlphabetic(s.charAt(b))) {
                    if(Character.toUpperCase(s.charAt(a)) != Character.toUpperCase(s.charAt(b)))
                        return false;
                } else {
                    if(s.charAt(a) != s.charAt(b))
                        return false;
                }
            }
            if(!isWD(s.charAt(a)) && !isWD(s.charAt(b))) {
                a++;
                b--;
            } else {
                int tmpA = a;
                a = isWD(s.charAt(b)) ? a + 1 : a;
                b = isWD(s.charAt(tmpA)) ? b - 1 : b;
            }
        }
        return true;
    }

    private static boolean isWD(char c) {
        return Character.isDigit(c) || Character.isAlphabetic(c);
    }
}
