package algorithm.sorting;

import java.util.Random;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 09:34 2019-03-01
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public abstract class SortBase {
    public static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean less(Comparable a, Comparable b){
       return a.compareTo(b) < 0;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(less(arr[i+1], arr[i])){
               return false;
            }
        }
        return true;
    }

}
