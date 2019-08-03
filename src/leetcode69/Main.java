package leetcode69;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ohm
 */
public class Main {

    public static void main(String[] args) {
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(6));
//        System.out.println(mySqrt(8));
//        System.out.println(mySqrt(9));
//        System.out.println(mySqrt(10));
//        System.out.print(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if(x == 1)
            return 1;
        int l = 0, r = x;
        long guess = x/2;//防止平方溢出，所以使用long
        while(true) {
            if (guess * guess == x)//猜中
                return (int) guess;
            else if (guess * guess < x) {//猜小了
                if ((guess + 1) * (guess + 1) > x) {//猜的下一位是大了，则当前是对的
                    return (int) guess;
                } else {//猜小了，往大了猜
                    int tmp = (int) guess;
                    guess = guess + (r - guess) / 2;
                    l = tmp;
                }
            }else {//猜大了，往小了猜
                int tmp = (int) guess;
                guess = l + (guess - l) / 2;
                r = tmp;
            }
        }
    }

//    //牛顿迭代法
//    public int mySqrt(int a) {
//        long x = a;
//        while (x * x > a) {
//            x = (x + a / x) / 2;
//        }
//        return (int) x;
//    }
}
