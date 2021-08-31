package basic.three;


/**
 * review partition and quickSort
 *
 */
public class Code_03_PartitionAndQuickSort {

    /**
     * 经典partition过程  已arr[R] 做划分  小于等于放左边 大于放右边
     *
     * @param arr
     */
    public static int partition(int[] arr,int L,int R){
        if(L > R){
            return -1;
        }
        if(L == R){
            return L;
        }
        int less = L -1;
        int index = L;

        while (index < R){
            if(arr[index] <= arr[R]){
                swap(arr,index,++less);
            }
            index++;
        }
        swap(arr,++less,R);
        return less;
    }

    private static void swap(int[] arr, int i, int i1) {

        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

}
