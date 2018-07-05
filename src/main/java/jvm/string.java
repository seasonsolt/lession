package jvm;

public class string {
    volatile int a = 9;
    int b = 10;

    public static void main(String[] args) {
//        for(int i=0;;) {
//            System.out.println("fafa");
//        }

//        new NewConcurrentHashMap().put("key", "value");
//        new Hashtable<String, String>();
//        new HashMap<String, String>();




        int a = 10;
        int b = a;

            System.out.println(b);
        a = 11;
        System.out.println(b);

    }



}
