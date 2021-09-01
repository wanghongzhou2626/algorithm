package basic.one;

/**
 * 二分查找 在数组中的某一个数
 *
 * @author whz
 */
public class Review_BinarySearch {

    /**
     * 经典二分
     *
     * @param arr
     * @param num
     * @return
     */
    public static boolean findNum(int[] arr, int num) {

        if (arr == null || arr.length == 0) {
            return false;
        }

        int L = 0;
        int R = arr.length - 1;

        int mid = 0;

        while (L < R) {
            mid = L + (R - L) >> 1;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return num == arr[L];
    }


    /**
     * 在有序数组中 寻找等于某个数的最左侧的位置
     *
     * @param arr
     * @param num
     * @return
     */
    public static int findLeftNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        int index = -1;
        while (L <= R) {
            mid = L + (R - L) >> 1;
            if (arr[mid] >= num) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }


    /**
     * 在有序数组中 寻找等于某个数的最右侧的位置
     *
     * @param arr
     * @param num
     * @return
     */
    public static int findRightNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        int index = -1;
        while (L <= R) {
            mid = L + (R - L) >> 1;
            if (arr[mid] <= num) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }
}
