package designPattern.Observer.JdkVersion;

import java.util.Observable;
import java.util.Observer;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 20:10 2019-04-03
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class CurrentWeather implements Observer {
    public void update(Observable o, Object temp){
        System.out.println(temp);
    }


}
