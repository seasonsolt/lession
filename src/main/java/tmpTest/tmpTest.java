package tmpTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 1:55 PM 2019/1/28
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class tmpTest {
    public static void main(String args[]){
        int a = 10;
        int b = Integer.MAX_VALUE;
        System.out.println((a+b)/2);
        System.out.println((a+b)>>>1);


        Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();

        Observer ob = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                //
            }
        };
    }
}
