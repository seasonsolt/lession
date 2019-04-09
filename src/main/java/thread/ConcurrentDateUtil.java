package thread;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 8:16 PM 2019/2/13
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcurrentDateUtil {

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private static ThreadLocal<String> treadLocal1 = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return new String("hello");
        }
    };

    private static ThreadLocal<String> treadLocal2 = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return new String("threadLocal");
        }
    };

    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

    public static String format(Date date) {
        return threadLocal.get().format(date);
    }

    public static void main(String []args){
        ConcurrentDateUtil.treadLocal1.remove();
        ConcurrentDateUtil.treadLocal2.remove();
        System.out.println(ConcurrentDateUtil.treadLocal1.get());
        System.out.println(ConcurrentDateUtil.treadLocal2.get());

    }
}

