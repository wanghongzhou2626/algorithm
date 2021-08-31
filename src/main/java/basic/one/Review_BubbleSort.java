package basic.one;

/**
 * review 冒泡排序
 *
 * @author whz
 */
public class Review_BubbleSort {
    
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for (int i = arr.length - 1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
            
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}

