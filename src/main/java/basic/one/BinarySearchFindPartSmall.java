package basic.one;

/**
 * 局部最小值问题  给定一个无序数组 任意两个相邻数不相等 返回任意一个局部最小
 * 什么是局部最小？ 比如 0位置比1位置大 就不是局部最小 否则就是局部最小
 * 如果 0 1 位置不存在局部最小 说明趋势是向下的 n-2位置到n-1位置不存在局部最小说明趋势是向上的   开头的趋势向下的 结尾是趋势向上的
 * 那么不管怎么连线 中间必有局部最小。
 *
 * @author whz
 */
public class BinarySearchFindPartSmall {

    public static int binarySearchFindPartSmall(int[] arr) {

        //数组非空判断
        if (arr == null || arr.length == 0) {
            return -1;
        }

        //如果数组长度为1
        if (arr.length == 1 || arr[0] < arr[1]) {
            //此时零位置为局部最小
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            //说明右边存在这局部最小返回
            return arr.length - 1;
        }


        int L = 1;
        int R = arr.length - 2;
        int mid = 0;


        //说明左右都不存在这局部最小 左边趋势向下 右边趋势向上 那么中间必存在着局部最小
        //这里为什么不需要等于  2 1 3 这种情况 L == 1  R==1 左右还都不是局部最小 那么只有中间的这个数是局部最小了 直接返回他的下标
        while (L < R) {
            mid = L + ((R - L) / 2);

            if (arr[mid] > arr[mid - 1]) {
                //说明mid不是局部最小 局部最小在mid左侧
                R = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                //mid 比他后一个数大 他还不是局部最小 趋势先向上后向下 所以mid右侧必有局部最小
                L = mid + 1;
            } else {
                //否则mid位置就是局部最小
                return mid;
            }
        }
        return L;


    }


    /**
     * 这个对数器怎么写啊 。。。
     * 如何验证他的正确性呢
     *
     */

}
