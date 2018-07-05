package redis;
import java.util.Arrays;

/**
 * 自己设计一个数据结构，快速查找是否有重复元素？
 * 审题： 1-快速=插入复杂度+查找复杂度  2-查找重复元素,原有数组是否绝对随机，或者相对有序
 * 3-没有考虑空间复杂度！！！ 4-只能用基础数据类型
 */
public class Duplicate {
    public static void main(String[] args) {
        int[] sourceArr = {5, 2, 3, 1, 4,87,13,21,11,10,9};

//        DupArr dup = new DupArr();
//        int[] dupArr = dup.findDup(sourceArr);
//        System.out.println(Arrays.toString(dupArr));
//
//        DupArr2 dup2 = new DupArr2();
//        dup2.BuildMinHeap(sourceArr, sourceArr.length);
//        dup2.HeapSort(sourceArr, sourceArr.length);
//
//        DupArr3 dup3 = new DupArr3();
//        dup3.quickSort(sourceArr, 0, 9);
//        System.out.println(Arrays.toString(sourceArr));
        sort(sourceArr);
        System.out.println(2);
    }

    //O(1)
    public static class DupArr {
        private int[] oriArr = new int[5000];
        private int[] dupArr = new int[5000];
        int dupSize = 0;

        //push-必须是随机访问才能做到最快插入速度O(1)
        private void push(int[] arr) {
            int i = 0;
            for (int ele : arr) {
                oriArr[ele]++;
                if (oriArr[ele] > 1) {
                    dupArr[i] = ele;
                    i++;
                }
            }
            dupSize = i;
        }

        public int[] findDup(int[] arr) {
            this.push(arr);
            int[] result = new int[dupSize];
            System.arraycopy(dupArr, 0, result, 0, dupSize);
            return result;
        }
    }

    //O(logN) 堆排序
    public static class DupArr2 {
        public void MinHeapIfy(int A[], int length, int i) {
            int left = i * 2 + 1;  //节点i的左孩子
            int right = left + 1; //节点i的右孩子节点
            int largest = i;  //默认父节点

            if (left < length && A[largest] > A[left]) {
                largest = left;
            }

            if (right < length && A[largest] > A[right]) {
                largest = right;
            }

            if (i != largest) {
                int temp = A[largest]; //exchange
                A[largest] = A[i];
                A[i] = temp;
                MinHeapIfy(A, length, largest);  //继续维护
            }
        }

        public void BuildMinHeap(int A[], int length) {
            for (int i = (length) / 2 - 1; i >= 0; i--) {
                MinHeapIfy(A, length, i);
            }
        }

        public void HeapSort(int A[], int length) {
            int temp;

            BuildMinHeap(A, length);      //建堆

            for (int i = length - 1; i >= 0; ) {
                temp = A[i];    //交换堆的第一个元素和堆的最后一个元素
                A[i] = A[0];
                A[0] = temp;
                i--;        //堆的大小减一
                MinHeapIfy(A, i, 0);  //调堆
            }
            for (int i = 0; i < length; i++)
                System.out.println(A[i] + "  ");
        }
    }

    //快速排序

    //O(logN)
    public static class DupArr3 {
        public void quickSort(int A[], int begin, int end) {
            if( begin > end) {
               return;
            }
            int left = begin;
            int right = end;
            int pivotal = A[begin];

            while( left < right) {
                while (A[right] > pivotal && left < right) {
                    right--;
                }

                while (A[left] <= pivotal && left < right) {
                    left++;

                }

                if(left < right) {
                    //交换
                    int tmp = A[left];
                    A[left] = A[right];
                    A[right] = tmp;
                }
            }

            //left = right
            int tmp = A[left];
            A[left] = A[begin];
            A[begin]= tmp;

            quickSort(A, begin, left-1);
            quickSort(A, left + 1, end);
        }

    }

    public static void sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            heapTop(array, i);
            swap(array, 0, i);
        }
    }

    private static void heapTop(int[] array, int i) {
        if(i!=0) {
            int j = i / 2;
            if (array[i] > array[j]) {
                swap(array, i, j);
            }
            heapTop(array, --i);
        }
    }

    private static void swap(int[] array, int i, int i2) {
        int temp = array[i];
        array[i] = array[i2];
        array[i2] = temp;
    }
}
