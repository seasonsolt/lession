package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 2:59 PM 2018/9/29
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class SimpleDateFormateMuiltThreadError {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd HH:mm");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-mm-dd HH");
    SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-mm-dd");

    public static void main(String[] args){
        SimpleDateFormateMuiltThreadError sdf = new SimpleDateFormateMuiltThreadError();
        Date now = new Date();
        System.out.println(sdf.sdf1.format(now));
        System.out.println(sdf.sdf2.format(now));
        System.out.println(sdf.sdf3.format(now));
        System.out.println(sdf.sdf4.format(now));
    }


}
