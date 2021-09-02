package basic.four;

/**
 * 堆排序
 * 1.构建堆  堆顶 与数组最后一个交换 然后 heapify 重复这个过程
 *
 * @author whz
 */
public class HeapSort {
    /**
     * 堆排序时间复杂度 O(n * logn)
     * @param arr
     */

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int heapSize = arr.length;
        //这里是从上到下去构建堆的 时间复杂度为O(n)
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //如果是从下到上去构建堆的 时间复杂度可以达到logn 但是堆排序的整体的时间复杂度不会有改变
        /*for (int j = arr.length - 1; j >= 0 ; j--) {
            heapify(arr,j,heapSize);
        }*/
        //交换 数组中的最大值来到了最后
        swap(arr, 0, --heapSize);

        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }


    }

    private static void heapify(int[] arr, int i, int heapSize) {
        int left = i * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] > arr[left + 1] ? left : left + 1;
            largest = arr[largest] > arr[i] ? largest : i;
            if (largest == i) {
                //不需要下沉
                break;
            }
            swap(arr, largest, i);
            i = largest;
            left = i * 2 + 1;
        }


    }



    private static void heapInsert(int[] arr, int i) {
        //构建大根堆
        while (arr[i] > arr[i * 2 + 1]) {
            swap(arr, i, i * 2 + 1);
            i = i * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
