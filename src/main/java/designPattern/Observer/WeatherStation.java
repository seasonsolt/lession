package designPattern.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 16:03 2019-03-29
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class WeatherStation {
    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        CurrenetConditionsDisplay currenetConditionsDisplay = new CurrenetConditionsDisplay(weatherData);

        weatherData.setMeasurements(60, 80, 30.4f);
        weatherData.setMeasurements(55, 79, 31.4f);
        weatherData.setMeasurements(50, 78, 32.4f);

        List<String> list = new ArrayList<String>();
        List<String> llist = new LinkedList<String>();
        Iterator<String> listIt = list.iterator();
    }

}
