package algorithm.sorting;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 10:45 2019-03-01
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class Bubble extends SortBase implements Sortable {
    @Override
    public void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++){
            for(int j = 0 ; j < arr.length - i - 1; j++){
                if(less(arr[j+1],arr[j])){
                    swap(arr, j+1, j);
                }
            }
        }
    }
}
