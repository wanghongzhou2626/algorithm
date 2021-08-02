package basic.one;

import java.util.Arrays;

/**
 * 选择排序 思想？  假设起始位置0 的元素为数组中最小 后边数字以此与零位置数字进行比较 比他小交换 比他大跳下一个 每次循环完确定一个最小值
 * 时间复杂度O(n^2) 空间复杂度O(1) 只用了有限的几个变量
 * @author whz
 */
public class SelectSort {


    public static void selectSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            //位 运算时 两个相同index交换位置会出现问题
            if (i != min){
                swap(arr,i,min);
            }
        }
    }

    public static void swap(int[] arr,int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[i] ^ arr[j];

        /*int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;*/

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
        int[] arr = new int[(int)(Math.random() * (maxSize + 1))];

        for (int i = 0; i < arr.length; i++) {
            //数组中数据也随机
            arr[i] = (int)((Math.random() * (maxValue+1)) - (Math.random() * (maxValue + 1)));
        }

        return arr;

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

    public static void main(String[] args) {
        int max = 500000;
        boolean success = true;
        for (int i = 0; i < max; i++) {
            int[] ints = randomArrayList(100, 100);

            // copy出来两份数据
            int [] arr1 = copyArray(ints);
            int [] arr2 = copyArray(ints);

            if (arr1 == null || arr2 == null) {
                System.out.println(" some array is null ");
            }
           /* printArray(arr1);
            printArray(arr2);*/

            noProblem(arr1);
            selectSort(arr2);

            //看看arr1 与 arr2 的数据是否完全一致

            if (!isEquals(arr1,arr2)){
                success = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }

        System.out.println(success ? "success" : "fail");


    }



}
