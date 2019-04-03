package designPattern.Observer;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 15:06 2019-03-29
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
