package designPattern.Observer.JdkVersion;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 09:18 2019-04-04
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class WeatherStation {

    public static void main(String[] args){
        WeatherData weatherData = new WeatherData(31.3f);
        CurrentWeather curr = new CurrentWeather();

        weatherData.addObserver(curr);
        weatherData.setTemp(33.f);


    }
}
