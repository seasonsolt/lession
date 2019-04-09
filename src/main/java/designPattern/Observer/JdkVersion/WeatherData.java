package designPattern.Observer.JdkVersion;

import java.util.Observable;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 20:07 2019-04-03
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class WeatherData extends Observable {
    private float temp;

    public WeatherData(float temp) {
        this.temp = temp;
        setChanged();
        notifyObservers(this.temp);
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
        setChanged();
        notifyObservers(this.temp);
    }

    public void getWeatherData(float temp) {
        this.temp = temp;
        notifyObservers();

    }
}
