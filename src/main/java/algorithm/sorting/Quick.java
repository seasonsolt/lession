package algorithm.sorting;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 16:29 2019-02-27
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class Quick {
    int[] array;

    public Quick(int[] array) {
        this.array = array;
    }

    void sort() {
        if (null == array || array.length <= 1) {
            return;
        }

        int pivital = array[0];
        for (int i = 0; i < array.length; i++) {
        }

    }

    void baseSort(int[] array, int begin, int end){
        if(begin >= end){
            return;
        }
        int pivot = array[begin];
        while(begin < end){
           if(array[begin] < pivot){

           }

        }

    }

    void swap(int[] array, int left, int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public String toString(){
        return array.toString();
    }

    public static void main(String args[]) {
        int[] array = {13,11,31,21,33,99,2,8,4,6};
        Quick qsort = new Quick(array);
        qsort.sort();
        System.out.println(qsort.toString());
    }
}
