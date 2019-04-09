package designPattern.Decorate;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 18:32 2019-04-08
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class Mocha extends CondimentDecorator{
    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    public String desc(){
        return beverage.desc() + " + mocha";
    }

    public double cost(){
        return beverage.cost() + 2;
    }

}
