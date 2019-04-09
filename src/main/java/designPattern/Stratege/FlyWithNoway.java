package designPattern.Stratege;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 16:52 2019-04-04
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class FlyWithNoway implements IFlyBehavior {
    public void fly(){
        System.out.println("I can not fly.");
    }
}
