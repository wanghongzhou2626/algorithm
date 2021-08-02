package basic.one;

import java.util.Arrays;

/**
 *
 * 冒泡排序 基本思想 0 位置与 1 位置比较 谁大移动，1位置与2位置谁大谁移动  一圈以后确定元素中最大值在末尾
 * 时间复杂度  O(n^2)  空间复杂度 O(n^2) 有限几个变量
 *
 * @author whz
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i ; j ++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j ,j+1);
                }
            }

        }
    }

    /**
     * 交换数组中的两个元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr,int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[i] ^ arr[j];
    }


    /**
     * 写一个对数器 来验证自己的方法是否正确
     *
     * 1. 写一个绝对正确的方法
     * 2. 产生一个数组随机发生器
     *
     *
     *
     */

    /**
     * 绝对正确的方法 采用系统提供的排序方法
     * @param arr
     */
    public static void noProblem(int[] arr){

        Arrays.sort(arr);

    }


    /**
     * 数组随机发生器
     * @param maxValue 数组中最大值
     * @param maxSize  数组中最大长度
     * @return
     */
    public static int[] randomArrayList(int maxValue, int maxSize){

        //math.random 产生0到1 左闭右开
        //产生一个数组长度随机的数组
        int[] arr = new int[(int)(Math.random() * maxSize)];

        for (int i = 0; i < arr.length-1; i++) {
            //数组中数据也随机
            arr[i] = (int)((Math.random() * maxValue) - (Math.random() * maxValue));
        }

        return arr;

    }


    public static void main(String[] args) {
        int max = 500000;

        for (int i = 0; i < max; i++) {
            int[] ints = randomArrayList(100, 3);

            // copy出来两份数据
            int [] arr1 = copyArray(ints);
            int [] arr2 = copyArray(ints);


            noProblem(arr1);
            bubbleSort(arr2);

            //看看arr1 与 arr2 的数据是否完全一致

            if (!isEquals(arr1,arr2)){
                printArray(arr1);
                break;
            }
        }

        System.out.println("success");


    }

    private static void printArray(int[] arr1) {
        for (int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }

    private static boolean isEquals(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length ; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * copy 数组
     * @param ints
     * @return
     */
    private static int[] copyArray(int[] ints) {

        int[] arr = new int[ints.length];

        for (int i = 0; i < ints.length; i++){
            arr[i] = ints[i];
        }
        return arr;
    }


}
