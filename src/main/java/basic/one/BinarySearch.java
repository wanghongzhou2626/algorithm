package basic.one;

import java.util.Arrays;

/**
 * 二分查找 (数据有顺序 从小到大排列的情况 )某个数是否在数组中   按照二分的规模递归查找
 * 时间复杂度O(logn)  空间复杂度O(1)
 *
 * @author whz
 */
public class BinarySearch {


    public static boolean binarySearch(int[] arr, int num) {

        if (arr == null || arr.length == 0) {
            return false;
        }

        int L = 0;
        int R = arr.length - 1;
        int mid = 0;

        while (L < R) {
            mid = L + ((R - L) / 2);
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }


        }
        return arr[L] == num;

    }


    /**
     * 二分查找对数器
     */

    public static boolean noProblem(int[] arr, int num) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }


    /**
     * 数组随机发生器
     *
     * @param maxValue 数组中最大值
     * @param maxSize  数组中最大长度
     * @return
     */
    public static int[] randomArrayList(int maxValue, int maxSize) {

        //math.random 产生0到1 左闭右开
        //产生一个数组长度随机的数组
        int[] arr = new int[(int) ((Math.random() * (maxSize)) + 1)];

        for (int i = 0; i < arr.length; i++) {
            //数组中数据也随机
            arr[i] = (int) ((Math.random() * (maxValue + 1)) - (Math.random() * (maxValue + 1)));
        }


        return arr;

    }

    private static void printArray(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }

    private static boolean isEquals(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * copy 数组
     *
     * @param ints
     * @return
     */
    private static int[] copyArray(int[] ints) {

        int[] arr = new int[ints.length];

        for (int i = 0; i < ints.length; i++) {
            arr[i] = ints[i];
        }
        return arr;
    }


    public static void main(String[] args) {
        int max = 500000;
        boolean success = true;
        for (int i = 0; i < max; i++) {
            int[] ints = randomArrayList(100, 5);
            /**
             * 不要忘记排序  二分查找的过程实在有序的前提条件的
             */
            Arrays.sort(ints);
            // copy出来两份数据
            int[] arr1 = copyArray(ints);
            int[] arr2 = copyArray(ints);

            if (arr1.length == 0 || arr2.length == 0) {
                System.out.println(" some array is null ");
            }

            int value = (int) ((Math.random() * (100 + 1)) - (Math.random() * (100 + 1)));
            //System.out.println("value = " + value);
            boolean i1 = noProblem(arr1, value);
            boolean i2 = binarySearch(arr2, value);

            //看看arr1 与 arr2 的数据是否完全一致

            if (i1 != i2) {
                success = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }

        System.out.println(success ? "success" : "fail");


    }

}
