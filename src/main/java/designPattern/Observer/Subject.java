package designPattern.Observer;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 15:05 2019-03-29
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public interface  Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
