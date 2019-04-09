package leetcode;

import java.util.Observer;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 18:21 2019-03-26
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x / 10 >= 1) {
            result = result * 10 + (x % 10);
            x = x / 10;
        }
        result = x;

        if (x > 0) {
            return result;
        }
        return result * -1;
    }

    public static void main(String[] args){
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(123));
    }
}
