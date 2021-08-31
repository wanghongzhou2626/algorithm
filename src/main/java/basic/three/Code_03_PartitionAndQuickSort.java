package basic.three;


/**
 * review partition and quickSort
 */
public class Code_03_PartitionAndQuickSort {

    /**
     * 经典partition过程  已arr[R] 做划分  小于等于放左边 大于放右边
     *
     * @param arr
     */
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int less = L - 1;
        int index = L;

        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++less);
            }
            index++;
        }
        swap(arr, ++less, R);
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
    public static int[] threeColorLands(int[] arr, int L, int R) {

        if (L == R) {
            return new int[]{L, R};

        }
        if (L > R) {
            return new int[]{-1, -1};
        }

        //左边界
        int less = L - 1;
        //右边界
        int more = R;

        //走的位置
        int index = L;

        while (index < more) {

            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }

        }
        //最后一个位置比较的值 与 大于区域第一个值进行交换
        swap(arr, more, R);
        //小于区后一个 到等于区最后一个返回
        return new int[]{less + 1, more};
    }

    /**
     * 第一种快排方式 时间复杂度为O(N^2)
     *
     * @param arr
     */
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    private static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = partition(arr, L, R);
        process1(arr, L, mid - 1);
        process1(arr, mid, R);
    }

    /**
     * 根据荷兰国旗partition 的快排 时间复杂度依然是O(n^2)
     */

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    private static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //他返回的数组第一个元素 是等于区域第一个 第二个元素是等于区域最后一个 每次都是有可能搞定一批数的
        int[] mid = threeColorLands(arr, L, R);
        process2(arr, L, mid[0] - 1);
        process2(arr, mid[1] + 1, R);
    }


    /**
     * 经典的随机快排  在随机划分值的情况下 时间复杂度可以达到 n*log n
     */

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process3(arr, 0, arr.length - 1);
    }

    private static void process3(int[] arr, int L, int R) {

        if (L >= R) {
            return;
        }

        int randIndex = L + (int) Math.random() * (R - L + 1);
        swap(arr, randIndex, R);
        int[] mid = threeColorLands(arr, L, R);
        process3(arr, L, mid[0] - 1);
        process3(arr, mid[1] + 1, R);

    }
}
