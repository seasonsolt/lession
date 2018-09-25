package other;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 下午2:36 2018/9/20
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class qiting {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        /*
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c ==(a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g==(a+ b));
        System. out. println(g.equals(a+ b));
        */


        String s1 = "abc";
        String s2 = "abc";
        String s3= new String("abc");
//        String s4 = "";
//        String s5 = "";
        String str2 = "abc";
        String str3 = "a" + "b" + "c";
        System.out.println(str2 == str3);

        final String s4 = "a";
        final String s5 = "bc";

        System.out.println("s1 == s2 ? "+(s1==s2));
        System.out.println("s1 == s3 ? "+(s1==s3));
        System.out.println("s1 == s4 + s5 ? "+(s1 == s4 + s5));
        System.out.println("s1 equals s3 ? "+(s1.equals(s3)));
    }
}
