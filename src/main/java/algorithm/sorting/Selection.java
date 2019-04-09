package algorithm.sorting;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 10:45 2019-03-01
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class Selection extends SortBase implements Sortable {
    @Override
    public void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

}
