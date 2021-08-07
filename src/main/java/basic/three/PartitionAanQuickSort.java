package basic.three;

/**
 * 快排 与 partition 过程
 * 还有一些相关经典问题
 *
 * @author whz
 */
public class PartitionAanQuickSort {


    /**
     * 在给定数组中 以数组中某个数进行划分 小于等与这个数的在左边 大于这个数的在右边
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int partition(int[] arr, int L, int R) {
        /**
         * 1.边界条件校验
         * 2.以做左侧-1的位置为划分值
         * 3.如果当前index位置的数小于等于num 将index位置的数 与小于区域下一个位置进行交换 小于区域阔一位置
         *
         *
         */
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

    private static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;

    }

    /**
     * 荷兰国旗划分问题
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值 小于区域在左边 等于区域在中间 大于区域在右边
    // 返回等于区域的左部分右部分的下标
    // <arr[R] ==arr[R] > arr[R]
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        // 划分条件不满足
        if (L > R) {
            return new int[]{-1, -1};
        }

        //划分范围上只有一个数
        if (L == R) {
            return new int[]{L, R};
        }

        //定义左边界
        int less = L - 1;
        //定义数组移动时的下标
        int index = L;
        int more = R;
        //在这个范围上进行划分  右边界为当前R的位置上 最后在交换正确
        while (index < more) {
            //以 r 位置数进行划分 如果当前位置数小于R位置数 当前位置数与左侧边界的下一个数进行交换
            // 并且左侧边界像外扩一个区域
            if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else if (arr[index] > arr[R]) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
        //划分之后的 r位置一定是属于等于区域的  L...less  less+1...more-1  more...R-1
        // 交换完之后     L....less less+1...more more+1..R
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }


    /**
     * 上面代码 看着比较怪异 我应该把它改成经典的荷兰国旗问题。
     */

    /**
     * 上面两个题 其实本质上都是在完partition的过程 实际上目的是要引出经典的快排算法 partition过程
     * 快排 1.0 2.0 3.0
     */






}
