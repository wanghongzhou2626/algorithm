package basic.one;

import java.util.Arrays;

/**
 * 在一个有序数组中， 找>= 某个数最左侧的位置 也是二分的思想
 *
 * @author whz
 */
public class BinarySearchFindLeftNum {

    public static int binarySearchFindLeftNum(int[] arr, int num) {

        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        int index = -1;
        while (L <= R) {
            mid = L + ((R - L) / 2);
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
     * 二分查找对数器
     */

    public static int noProblem(int[] arr, int num) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
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
            int i1 = noProblem(arr1, value);
            int i2 = binarySearchFindLeftNum(arr2, value);

            //看看arr1 与 arr2 的数据是否完全一致

            if (i1 != i2) {
                success = false;
                System.out.println("i1 = " + i1 + "  " + "i2 = " + i2);
                System.out.println("value = " + value);
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }

        System.out.println(success ? "success" : "fail");


    }


}
