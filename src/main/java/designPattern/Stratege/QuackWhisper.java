package designPattern.Stratege;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 16:54 2019-04-04
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class QuackWhisper implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack whisper.");
    }
}
