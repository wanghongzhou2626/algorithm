package basic.two;

/**
 * 通过递归寻找数组中的最大值
 */
public class Review_GetMaxNum {


    public static int getMax(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if(L == R){
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr,0,mid);
        int rightMax = process(arr, mid+1,R);
        return Math.max(leftMax,rightMax);

    }


    public static void main(String[] args) {
        int[] a = new int[]{1,2,4,5,7,3,8,9,10};

        int max = getMax(a);
        System.out.println(max);
    }
}
