package basic.one;

/**
 * 选择排序实现回顾
 * 思路 默认0位置最小 1 - n 选择一个最小的  如果比零位置小跟 零位置交换
 *     2 - n 重复这个过程
 *
 */
public class Review_SelectSort {

    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        int minIndex;
        for(int i = 0; i < arr.length -1; i++){
            minIndex = i;
            for (int j = i + 1;j < arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

}
