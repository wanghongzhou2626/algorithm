package basic.eleven;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author whz
 */
public class RobootMove {



    /**
     * 动态规划 阿里原题
     *
     * 假设有排成一行的n个位置 记为1~n n一定大于或等于2
     * 开始时机器人在其中的m位置上（m一定是 1~n中的一个）
     * 如果机器人来到1位置，那么下一步只能往右来到2位置
     * 如果机器人来到n位置 那么下一步只能往左来到 n-1位置
     * 如果机器人来到中间位置 那么下一步可以往左走或者往右走
     * 规定机器人必须走k步 最终能来到p位置（p也是1~n中的一个）的方法有多少种
     * 给定四个参数n m k p 返回方法数
     *
     *
     */


    /**
     *
     * @param n  一共有n个位置
     * @param m  当前位置
     * @param k  要走的步数
     * @param p  你最终要到的位置
     * @return
     */
    public static int way(int n, int m, int k, int p){


        return process(n,m,k,p);
    }

    private static int process(int n, int m, int k, int p) {

        //basecase
        if(k == 0){
            //步数走没了
            return m == p ? 1 :0;
        }
        //如果当前走到了1位置 只能往2位置走
        if(m == 1){
            return process(n,2,k-1,p);
        }
        //如果当前走到n位置 只能往回走了
        if(m == n){
            return process(n,n-1,k-1,p);
        }
        return process(n,m-1,k-1,p) + process(n,m+1,k-1,p);
    }

    public static void main(String[] args) {
        int s = way(7,3,4,5);
        System.out.println(s);
    }

}
