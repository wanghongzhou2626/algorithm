package basic.eleven;

/**
 * @author whz
 *
 *
 *
 *  * 从左向右的尝试模型
 *  *
 *  *
 *  * 规定1和A对应 2和B对应 3和C对应
 *  * 那么一个数字字符串比如 ”111“ 就可以转化为  ”AAA“ ”kA“ ”AK“
 *  * 给定一个只有数字字符组成的字符串str 返回有多少种转化结果
 *  *
 *
 */
public class Code_01 {

    // 所有的货，重量和价值，都在w和v数组里
    // 为了方便，其中没有负数
    // bag背包容量，不能超过这个载重
    // 返回：不超重的情况下，能够得到的最大价值
    public static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        // 尝试函数！
        return process(w, v, 0, bag);
    }

    // index 0~N
    // rest 负~bag
    // 就是考虑我当前货物 要不要 的问题  要产生的最大价值 与 不要产生的最大价值 两者中的最大的 将是我最好的结果
    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        //我没有要当前货物的前提下 我后续货物得到的最大价值
        int p1 = process(w, v, index + 1, rest);
        int p2 = 0;
        //我要了当前的货物 后续货物得到的最大价值
        int next = process(w, v, index + 1, rest - w[index]);
        if (next != -1) {
            //当前货物的价值 加上后续货物的价值

            p2 = v[index] + next;
        }
        //可能性1 与 可能性2 中我选择对我最好的
        return Math.max(p1, p2);
    }

    public static int dp(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
                if (next != -1) {
                    p2 = v[index] + next;
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = { 50, 100 };
        int[] values = { 200, 300 };
        int bag = 200;
        System.out.println(maxValue(weights, values, bag));
        //System.out.println(dp(weights, values, bag));
    }
}
