package basic.two;

/**
 * @author whz
 *
 * 使用二分查找 找数组中的最大值
 */
public class GetMaxBinarySearch {

    /**
     * 数组中寻找最大值
     * @param arr
     * @return
     */


    public static int getMax(int[] arr){
        return process(arr, 0, arr.length -1);
    }

    private static int process(int[] arr, int L, int R) {
        if(L == R){
            return arr[L];
        }
        int mid = L + ((R - L)/2);
        int leftMax = process(arr, L, mid - 1);
        int rightMax = process(arr, mid, R);
        return Math.max(leftMax,rightMax);

    }



}
