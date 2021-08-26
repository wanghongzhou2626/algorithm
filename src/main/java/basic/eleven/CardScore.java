package basic.eleven;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author whz
 *
 *  *  范围上的尝试模型
 *  *  给定一个整型数组arr 代表数值不同的纸牌排成一条线
 *  *  玩家A和玩家B一次拿走每张纸牌
 *  *  规定玩家A先拿 玩家B后拿
 *  *  但是每个玩家每次只能拿走最左或最右的纸牌
 *  *  玩家A和玩家B都绝顶聪明，请返回最后获胜者分数
 *  *
 *  *
 *  *
 *
 */
public class CardScore {

    /**
     *
     * 先手 后手拿牌问题
     *
     * 先手 取最大   后手里用到先手 只有先手拿到最小 后手才能得到最大
     *       A:       3 100 7                        B:
     *              f(0,2)
     *         3               7
     *     s(1,2)             s(0,1)
     * f(2,2)    f(1,1)    f(1,1)   f(0,0)
     * 后手肯定把先手最小的选出来 他才能得到最大
     *
     *
     */


    public static int getMaxScore(int[] arr,int L,int R){




        return Math.max(f(arr,L,R),s(arr,L,R));



    }


    /**
     * 先手拿牌 得到最大的结果 当先手拿完第一次之后 下次在拿其实他就是后手了
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int f(int[] arr, int L, int R){
        if(L == R){
            return arr[L];
        }

        //如果我先手拿到的是L位置 那么后手只能在L+1到R
        return Math.max(
                (arr[L] + s(arr,L+1,R)),(arr[R]+s(arr,L,R-1)));


    }

    /**
     * 后手函数如何拿到最大  先手得到最小 后手得到最大
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int s(int[] arr,int L, int R){
        if(L == R){
            //你是后手 没牌了
            return 0;
        }
        return Math.min(
                f(arr, L+1,R),f(arr,L,R-1)
        );
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,100,7,10};
        int maxScore = getMaxScore(arr, 0, 3);
        System.out.println(maxScore);
    }


}
