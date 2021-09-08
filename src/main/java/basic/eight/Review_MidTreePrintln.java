package basic.eight;

/**
 * @author whz
 * <p>
 * 3.请把一段纸条竖着放在桌子上，然后从纸条的下边像上方对折一次，压出折痕后展开。此时折痕是凹下去的，即折痕突起的方向指向纸条的背面。如果从纸条的
 * 下边向上方连续对折两次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕，下折痕和上折痕。
 * 给定一个输入参数N，代表纸条都从下边向上方联系对折N次。请从上到下打印所有折痕的方向
 * 例如n=1时，打印 down N=2 时 打印 down down up
 * 思考 如果从上到下打印这个纸条上的所有凹凸折痕 其实就是一颗树的中序遍历  怎么构造树呢 应该根据他给的N吧
 * 就是在你脑海中想象出的一棵树 头节点凸 左树节点都是凹 右树节点都是凸 每个节点是有凹凸规律的 不需要构建
 */
public class Review_MidTreePrintln {


    public static void printlnMidTree(int N) {

        if (N < 1) {
            return;
        }

        println(1, N, true);

    }

    /**
     * @param i 当前的层数
     * @param n 一共多少层
     * @param b true 代表凹  false 代表 凸
     */
    private static void println(int i, int n, boolean b) {
        //base case
        if (i > n) {
            return;
        }
        //每颗子树的头都是凹 左树是凹 右树是凸  整体想象成一颗树  中序遍历的结果
        //左
        println(i + 1, n, true);
        //中
        System.out.println(b ? "凹" : "凸");
        //右
        println(i + 1, n, false);
    }

    public static void main(String[] args) {
        printlnMidTree(3);
    }


}
