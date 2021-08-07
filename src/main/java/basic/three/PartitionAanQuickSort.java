package basic.three;

/**
 * 快排 与 partition 过程
 * 还有一些相关经典问题
 * @author whz
 */
public class PartitionAanQuickSort {


    /**
     * 在给定数组中 以数组中某个数进行划分 小于等与这个数的在左边 大于这个数的在右边
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int partition(int[] arr, int L, int R){
        /**
         * 1.边界条件校验
         * 2.以做左侧-1的位置为划分值
         * 3.如果当前index位置的数小于等于num 将index位置的数 与小于区域下一个位置进行交换 小于区域阔一位置
         *
         *
         */
        if (L > R){
            return -1;
        }
        if (L == R) {
            return L;
        }

        int less = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]){
                swap(arr,index,++less);
            }
            index++;
        }
        swap(arr, ++less,R);
        return less;
    }

    private static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;

    }

}
