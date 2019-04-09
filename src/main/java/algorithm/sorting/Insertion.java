package algorithm.sorting;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 10:45 2019-03-01
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class Insertion extends SortBase implements Sortable {
    @Override
    public void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++){
            for(int j = i + 1; j > 0 && j < arr.length; j--){
                if(less(arr[j],arr[j - 1])){
                    swap(arr, j, j-1);
                }
            }
        }
    }
}
