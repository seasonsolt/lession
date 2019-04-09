package designPattern.Decorate;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 18:39 2019-04-08
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class StartBucks {
    public static void main(String[] args){
        Beverage espresso = new Espresso();
        Mocha mocha = new Mocha(espresso);

        System.out.println(mocha.desc());
    }
}
