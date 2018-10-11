package leetcode;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 4:05 PM 2018/10/10
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int begin = 0, end = Math.min(x, 46340);
        while(begin <= end){
            int mid = (begin + end)/2;
            if(mid * mid == x){
                return mid;
            }else if(mid * mid > x){
                end = mid - 1;
            }else {
                begin = mid + 1;
            }
        }

        return begin-1;

    }

    public static void main(String[] args){

        Sqrtx test = new Sqrtx();
//        System.out.println(test.mySqrt(6));
//        System.out.println(test.mySqrt(8));
        System.out.println(test.mySqrt(2147395600));
    }
}
