package basic.one;

/**
 * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数？
 * @author whz
 */
public class FindOldNum {

    /**
     * N ^ N = 0 所以一起异或剩下的那个数也就是出现了奇数次的数字。
     */
    public static int findOldNum(int[] arr) {

        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        return eor;

    }


    /**
     * 如何将一个数的二进制表示下，提取出最后一个1
     *
     * N &  (~N + 1)
     *
     */


    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并且打印这两种数。时间复杂度O(N) 空间复杂度O(1)
     * 1)把数组中所有的数进行^ 运算  得到 a ^ b  因为所有成对的偶数都变成零了
     * 2) a与b 不相等 所有 a ^ b的结果不等于零  这能说明什么呢？因为异或运算是无进位相加  这两个数在进行按位 ^ 的时候不为零一定有在某一位上是0或者是1
     *   啥意思？ 就是说如果 假设第八位相加不为零 那么如果a的第八位为 0 那么b的第八位一定是 1，如果a的第八位是1 那么b的第八位一定是零 但是他俩一定是互斥的
     *   那么我现在将整个数组分为两个阵营 一部分为第八位是1的所有数字 一部分是第八位是0的所有数字 拿第八位是1的所有数字说 这其中所有数出现偶数次的会抵消剩下
     *   的那个数一定是ab中的一个 记住他们是互斥的
     *
     *  3)这里我们就去取最后一位为1的 其余为零
     *
     * @param arr
     * @return
     */
    public static int[] findTwoOldNum(int[] arr){

        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        //eor 就是 a ^ b
        //根据eor 提取出 最右侧为 1 的rightOne
        int rightOne = eor & (~eor + 1);

        int otherNum = 0;
        for (int j = 0; j < arr.length ; j++) {
            if ((arr[j] & rightOne) != 0) {
                //arr[i] 这个就是那个出现奇数次的数
                otherNum ^= arr[j];
            }

        }
        return new int[]{otherNum,otherNum^eor};



    }

}
