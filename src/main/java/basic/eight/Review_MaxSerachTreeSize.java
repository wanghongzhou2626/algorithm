package basic.eight;


/**
 * @author whz
 * 给定一颗二叉树的头节点head 返回这颗二叉树中最大二叉搜索子树的节点数量
 * 什么时搜索树 已谋个节点为头的子树 左树的值都比 右树的值都比自己大
 * <p>
 * 分析 以某个节点x为例  当与x有关时 那他的含义就是整颗都是搜索树 我需要知道左树最小值 右树最大值
 * 还有左树的最大搜索树size 右树最大搜索树size 各自是不是搜索树*
 * <p>
 * 与x无关  左最大搜size 右最大搜size
 */
public class Review_MaxSerachTreeSize {


    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info {
        //最大二叉搜索子树size
        int maxBSTSize;
        boolean isBST;
        int max;
        int min;

        public Info(int maxBSTSize, boolean isBST, int max, int min) {
            this.maxBSTSize = maxBSTSize;
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }


    public static int maxSize(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head).maxBSTSize;
    }

    private static Info process(Node head) {
        //base case
        if (head == null) {
            //因为最大值 最小值不好定义 那么我就返回null
            // 在使用的时候 需要判空了
        }

        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int max = head.value;
        int min = head.value;

        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }

        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }


        //设置初始值
        int maxBSTSize = 0;
        if (leftInfo != null) {
            maxBSTSize = leftInfo.maxBSTSize;
        }
        if (rightInfo != null) {
            maxBSTSize = Math.max(maxBSTSize, rightInfo.maxBSTSize);
        }


        boolean isBST = false;
        //满足整颗是不是 二叉搜索子树
        if (
            //左树是不是二叉搜索树
                (leftInfo == null ? true : leftInfo.isBST)
                        &&
                        //右树是不是二叉搜索树
                        (rightInfo == null ? true : leftInfo.isBST)
                        &&
                        (leftInfo == null ? true : leftInfo.max < head.value)
                        &&
                        (rightInfo == null ? true : rightInfo.min > head.value)
        ) {

            isBST = true;
            maxBSTSize = (leftInfo == null ? 0 : leftInfo.maxBSTSize)
                    + (rightInfo == null ? 0 : rightInfo.maxBSTSize)
                    + 1;
        }


        return new Info(maxBSTSize, isBST, max, min);

    }
}
