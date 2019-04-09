package algorithm.sorting;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 15:49 2019-03-01
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class Merge extends SortBase implements Sortable {
    public static Comparable[] result;

    @Override
    public void sort(Comparable[] arr) {
        result = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Comparable[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = begin + (end - begin) / 2;
        sort(arr, begin, mid);
        sort(arr, mid + 1, end);

        merge(arr, begin, mid, end);
    }

    private void merge(Comparable[] arr, int begin, int mid, int end) {
        //deep copy
        for (int i = begin; i <= end ; i++) {
            result[i] = arr[i];
        }

        //merge
        for (int i = begin, j = mid + 1, k = begin; k <= end; k++) {
            if (i > mid) {
                arr[k] = result[j++];
            } else if (j > end) {
                arr[k] = result[i++];
            } else if (!less(result[i], result[j])) {
                arr[k] = result[j++];
            } else {
                arr[k] = result[i++];
            }
        }

    }

}
