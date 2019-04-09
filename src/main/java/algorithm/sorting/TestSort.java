package algorithm.sorting;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 11:05 2019-03-01
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class TestSort extends SortBase{
    public static void main(String args[]){
        int len= 30000;

        Insertion insert = new Insertion();
        long begin = System.currentTimeMillis();
        Integer[] ranArr = ranArr(len);
        insert.sort(ranArr);
        long end = System.currentTimeMillis();
        System.out.println("insert sort result =" + isSorted(ranArr) + " cost:" + (end - begin));


        ranArr = ranArr(len);
        Selection selection = new Selection();
        begin = System.currentTimeMillis();
        ranArr = ranArr(len);
        selection.sort(ranArr);
        end = System.currentTimeMillis();
        System.out.println("select sort result =" + isSorted(ranArr) + " cost:" + (end - begin));

        ranArr = ranArr(len);
        Bubble bubble = new Bubble();
        begin = System.currentTimeMillis();
        bubble.sort(ranArr);
        end = System.currentTimeMillis();
        System.out.println("bubble sort result =" + isSorted(ranArr) + " cost:" + (end - begin));

        ranArr = ranArr(len);
        Merge merge= new Merge();
        begin = System.currentTimeMillis();
        merge.sort(ranArr);
        end = System.currentTimeMillis();
        System.out.println("merge sort result =" + isSorted(ranArr) + " cost:" + (end - begin));
    }

    public static Integer[] ranArr(int len){
        Integer[] ranArr = new Integer[len];
        for(int i = 0; i <len; i++){
            ranArr[i] = Integer.valueOf(Double.valueOf(Math.random() * 10000).intValue());
        }

        return ranArr;
    }

    public static Integer[] revArr(int len){
        Integer[] revArr = new Integer[len];
        for(int i = 0; i <revArr.length; i++){
            revArr[i]=len - i;
        }
        return revArr;
    }

    public static Integer[] orderArr(int len){
        Integer[] orderArr = new Integer[len];
        for(int i = 0; i <orderArr.length; i++){
            orderArr[i] = i;
        }
        return orderArr;
    }
}
