package basic.eleven;

/**
 * @author whz
 * <p>
 * <p>
 * 背包问题
 * 从左往右的尝试模型
 * 给定两个长度为N的数组weights 和 values
 * weights[i]和values[i]分别代表i号物品的重量与价值
 * 给定一个正数tag 表示袋子能载的最大重量
 * 返回你能装下的最多价值
 * <p>
 * 如何尝试  其实就是问 一个物品你的选择与不选择两种情况中 选择对你价值最大的一种  然后在tag的承受范围内 继续选择
 */
public class Knapsack {

    public static int getMaxValues(int[] weights, int[] values, int tag) {
        return process(weights, values, 0, 0, tag);
    }

    /**
     * @param weights    重量数组
     * @param values     价值数组
     * @param alreadyTag 已经计算的重量
     * @param tag        要求的最大重量
     * @return
     */
    private static int process(int[] weights, int[] values, int index, int alreadyTag, int tag) {
        //表示没有可选方案
        if (alreadyTag > tag) {
            return -1;
        }

        //表示我的重量没有超过给定 但是我的数组走到了尽头 所以也算一种方案 返回 0
        if (index == weights.length) {
            return 0;
        }


        //假如我没有选择当前商品 那么后续货物得到的价值是多少呢
        int p1 = process(weights, values, index + 1, alreadyTag, tag);

        //加入我选择了当前商品那么我后续所得到的最大价值是多少呢

        int p2Next = process(weights, values, index + 1, alreadyTag + weights[index], tag);


        if (p2Next != -1) {
            p2Next = p2Next + values[index];
        }
        return Math.max(p1, p2Next);


    }


    public static int getMaxValues2(int[] weights, int[] values, int rest) {
        return process2(weights, values, 0, rest);
    }



    //按照剩余价值去递归算
    /**
     * @param weights    重量数组
     * @param values     价值数组
     * @param rest        剩余重量
     * @return
     */
    private static int process2(int[] weights, int[] values, int index, int rest) {
        //表示没有可选方案
        if (rest <= 0) {
            return -1;
        }

        //表示我的重量没有超过给定 但是我的数组走到了尽头 所以也算一种方案 返回 0
        if (index == weights.length) {
            return 0;
        }


        //假如我没有选择当前商品 那么后续货物得到的价值是多少呢
        int p1 = process2(weights, values, index + 1, rest);

        //加入我选择了当前商品那么我后续所得到的最大价值是多少呢

        int p2Next = process2(weights, values, index + 1, rest-weights[index]);


        if (p2Next != -1) {
            p2Next = p2Next + values[index];
        }
        return Math.max(p1, p2Next);


    }

    public static void main(String[] args) {
        int[] weights = {50, 100};
        int[] values = {200, 300};
        int bag = 200;
        System.out.println(getMaxValues2(weights, values, bag));
        //System.out.println(dp(weights, values, bag));
    }

}
