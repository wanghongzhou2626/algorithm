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


    /**
     * 荷兰国旗问题 在 l - r 范围内 以arr[r] 做划分 小于区域在左边 等于区域在中间 大于区域在右边
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static  int[] threeColorLands(int[] arr,int L , int R){

        if(L == R){
            return new int[]{L,R};

        }
        if(L > R){
            return new int[]{-1,-1};
        }

        //左边界
        int less = L -1;
        //右边界
        int more = R;

        //走的位置
        int index = L;

        while (index < more){

            if(arr[index] ==  arr[R]){
                index++;
            }else if(arr[index] < arr[R]){
                swap(arr,index++,++less);
            }else {
                swap(arr,index,--more);
            }

        }
        //最后一个位置比较的值 与 大于区域第一个值进行交换
        swap(arr,more,R);
        //小于区后一个 到等于区最后一个返回
        return new int[]{less+1,more};
    }

}
