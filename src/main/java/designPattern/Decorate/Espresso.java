package designPattern.Decorate;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 18:32 2019-04-08
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class Espresso extends Beverage {
    public String desc(){
        return "This is a cup of Espresso";
    }

    public double cost(){
        return 1.99;
    }
}
