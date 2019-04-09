package designPattern.Stratege;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 15:33 2019-04-04
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class MountDuck extends Duck {
    public MountDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new QuackLoud();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public static void main(String[] args){
        MountDuck duck = new MountDuck();
        duck.performFly();
        duck.performQuack();
    }

}

