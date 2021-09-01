package basic.one;

/**
 * @author whz
 * 给定一个数组 寻找局部最小值问题 他肯定存在局部最小 返回任意一个局部最小
 * 什么是局部最小 零位置比一位置小 零位置就是局部最小
 * n位置比n-1位置小 n位置就是局部最小  中间位置也可能存在局部最小  n-1 n n+1 左右两个位置都比中间大 n就是局部最小
 */

public class Review_BinarySearchFindPartSmall {


    public static int findPartSmall(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //如果零位置是局部最小直接返回
        if (arr[0] < arr[1]) {
            return 0;
        }

        //如果n位置是局部最小
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        //开头和结尾都不是局部最小 趋势是先向下 后来向上的 所以中间一定存在局部最小 二分去找

        int L = 1;
        int R = arr.length - 2;
        int mid = 0;
        while(L < R){
            mid = L + (R - L) >> 1;
            if(arr[mid] > arr[mid+1]){
                L = mid + 1 ;
            }else if (arr[mid] > arr[mid -1]){
                R = mid - 1;
            }else {
                return mid;
            }
        }

        return L;

    }


}
