package designPattern.Observer;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 15:26 2019-03-29
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class CurrenetConditionsDisplay implements  Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrenetConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display(){
        Set<Integer> set = new HashSet<>();
        set.size();
        System.out.println("Current conditions:" + temperature + "F degrees and " + humidity + "% humidity");
    }
}
