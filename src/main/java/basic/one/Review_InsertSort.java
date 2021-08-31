package basic.one;


/**
 * review insert sort
 * 思路 每次向前看 直到不能在交换了 打扑克牌插入
 */
public class Review_InsertSort {


    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        /**
         * 0-i有序
         */
        for (int i = 1; i < arr.length ; i++) {
            for (int j = i - 1; j >=0 && arr[j] > arr[j+1] ; j--) {
                swap(arr,j,j+1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
