package basic.one;

import javax.naming.PartialResultException;

/**
 * ^ 异或运算的性质  N^N = 0   0^N = N
 *
 *
 * 在一个数组中  只有一种数出现了奇数次 其余数都出现了偶数次  请找出这个出现奇数次的数
 * @author whz
 */
public class Review_FindOldNum {

    /**
     * 在一个数组中  只有一种数出现了奇数次 其余数都出现了偶数次  请找出这个出现奇数次的数
     * @param arr
     * @return
     */
    public static int findOldNum(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        return eor;
    }

    /**
     * 给定一个数 提取出最右侧的1   001101001000  -> 000000001000
     * @param num
     * @return
     */
    public static int getRightOne(int num){
        return num & (~num + 1);
    }

    /**
     * 一个数组中两种数都出现了奇数次,并且他们不想等 剩下的数都出现偶数次，怎么找到这两种数
     * @param arr
     * @return
     */
    public static int[] findTwoOldNum(int[] arr){
        if(arr == null || arr.length == 0){
            return new int[]{-1,-1};
        }

        int eor = 0;
        for (int i = 0; i < arr.length ; i++) {
            eor ^= arr[i];
        }

        //此时的 eor = a^b 并且 a b不等 所有 eor ！= 0  说明 a或者b 在某一位上一定有1  所以找到最右边的1
        //此时整个数组中分为两大类 某一位置上是1的  某一位置上不是1的 但是我要找的那两个奇数一定是互斥的
        //提取出eor最右侧的1
        int a = 0;
        int rightOne = eor & (~eor + 1);
        for (int j = 0; j < arr.length ; j++) {
            if((arr[j] & rightOne) != 0 ){
                //在数组中最右位置是1的元素
                //此时的a就是 其中一个奇数
                a^= arr[j];
            }

        }
        return new int[]{a,eor ^ a};




    }





}
