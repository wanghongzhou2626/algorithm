package basic.one;

import java.util.Arrays;

/**
 * 插入排序思想 时间复杂度O(n^2)
 * 扑克牌 每次排序都是在已经有序的基础上插入进行排序 默认0位置已经为有序状态
 *
 * @author whz
 */
public class InsertSort {

    public static void insertSort(int[] arr){
        // 默认零位置数字有序 从1位置数字向前看
        for (int i = 1; i < arr.length ; i++) {
            //每次循环都是后一个数字 一直向前看 知道不满足条件以后 模拟扑克牌插入过程
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1] ; j--){
                //交换 然后继续
                swap(arr,j, j+1);
            }
        }
    }


    public static void swap(int [] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[i] ^ arr[j];
    }


    /**
     * 写一个对数器 来验证你的算法是否是正确的
     * 1.首先 你需要一个绝对正确的方法 可以是复杂度非常高的方法 或者 系统提供的一些方法
     * 2.制造一个数组随机发生器 就是样本量
     * 3.用绝对正确的方法 和你自己写的方法做测试 看看在大样本量下 你的算法是否是正确的。
     *
     *
     * @param arr
     */

    // 绝对正确的方法
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // 数组随机发生器
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random() -> [0,1) 所有的小数，等概率返回一个
        // Math.random() * N -> [0,N) 所有小数，等概率返回一个
        // (int)(Math.random() * N) -> [0,N-1] 所有的整数，等概率返回一个
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; // 长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 数组间复制的方法
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 两个数组元素之间比较是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印有问题的数组数据
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 测试主函数
     * @param args
     */
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 3; // 随机数组的长度0～100
        int maxValue = 100;// 值：-100～100
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            insertSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                // 打印arr1
                // 打印arr2
                succeed = false;
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertSort(arr);
        printArray(arr);
    }

}
