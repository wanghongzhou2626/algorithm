package basic.eleven;


import java.util.Stack;

/**
 * 逆序一个栈 不使用额外空间
 * 不能申请额外的数据结构
 * 只能使用递归函数
 *
 * @author whz
 */
public class RevertStackNoNewSpace {

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }

    /**
     * 栈低的元素移除 上面的元素盖下来 返回移除掉的底部元素
     * @param stack
     * @return
     */
    private static int f(Stack<Integer> stack) {

        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else {
            int last = f(stack);
            stack.push(result);
            return last;
        }

    }


}


/**
 * 从左向右的尝试模型
 *
 *
 * 规定1和A对应 2和B对应 3和C对应
 * 那么一个数字字符串比如 ”111“ 就可以转化为  ”AAA“ ”kA“ ”AK“
 * 给定一个只有数字字符组成的字符串str 返回有多少种转化结果
 *
 */

/**
 *  范围上的尝试模型
 *  给定一个整型数组arr 代表数值不同的纸牌排成一条线
 *  玩家A和玩家B一次拿走每张纸牌
 *  规定玩家A先拿 玩家B后拿
 *  但是每个玩家每次只能拿走最左或最右的纸牌
 *  玩家A和玩家B都绝顶聪明，请返回最后获胜者分数
 *
 *
 *
 */

/**
 *
 * n 皇后问题
 */


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
