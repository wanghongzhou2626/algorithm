package basic.eight;

/**
 * @author whz
 * <p>
 * 给定一颗二叉树的头节点 返回这颗二叉树中最大的搜索子树的节点数量
 */
public class MaxSerachTreeSize {


    /**
     * 树形dp 二叉树的递归套路
     * *     1.假设以x为头节点，假设可以向x左树和x右树要任何信息
     * *     2.在上一步的假设下，讨论以x为头节点的树，得到答案的可能性（最重要），通常情况考虑与x有关的情况 与x无关的情况
     * *     3.列出所有可能性后，确定到底需要向左树和右树要什么的信息
     * *     4.把左树信息和右树信息求全集，就是任何一颗子树都需要返回的信息s
     * *     5.递归函数都返回s 每一颗子树都这么要求
     * *     6.写代码，在代码中考虑如何把左数的信息和右树的信息整合出整棵树的信息
     */


    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 与x无关  左子树产生最大搜索子树或右子树 产生最大搜索子树
     * 与x有关  左是搜 右是搜 左最大是否小于头 右最小是否小于头
     */
    public static class Info {

        //从左右子树得到的最大搜索子树的节点数量
        private int maxSearchSize;
        //以某一个为头的节点的树 是否是搜索树
        private boolean isSearchTree;
        // 如果与x有关 说明左右子树中可能有最大子树了还要与x关联 就是 x左是搜 x右是搜 还需要判断 x左的max 是不是小于 x右的min是不是大于x
        private int max;
        private int min;

        public Info(int maxSearchSize, boolean isSearchTree, int max, int min) {
            this.isSearchTree = isSearchTree;
            this.maxSearchSize = maxSearchSize;
            this.max = max;
            this.min = min;
        }
    }

    public static int maxSearchTreeSize(Node x) {
        if (x == null) {
            return 0;
        }

        return process(x).maxSearchSize;
    }

    private static Info process(Node x) {

        if (x == null) {
            return null;
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);


        //整合信息
        int max = x.value;
        int min = x.value;


        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }

        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }


        int maxSearchTreeSize = 0;
        if (leftInfo != null) {
            maxSearchTreeSize = leftInfo.maxSearchSize;
        }
        if (rightInfo != null) {
            maxSearchTreeSize = Math.max(maxSearchTreeSize, rightInfo.maxSearchSize);
        }


        //整体是搜索二叉树 就是与x有关 什么时候这个值可以变为true呢
        // 满足左树是搜索二叉树 右树是搜索二叉树 并且 左树最大值 小于 x 右数最小值大于x
        boolean isAllSearchTree = false;
        //满足左树是搜索二叉树 右树是搜索二叉树 并且 左树最大值 小于 x 右数最小值大于x
        if ((leftInfo == null ? true : leftInfo.isSearchTree)
                && (rightInfo == null ? true : rightInfo.isSearchTree)
                && (leftInfo == null ? true : leftInfo.max < x.value)
                && (rightInfo == null ? true : rightInfo.min > x.value)) {

            isAllSearchTree = true;
            maxSearchTreeSize = (leftInfo == null ? 0 : leftInfo.maxSearchSize)
                    + (rightInfo == null ? 0 : rightInfo.maxSearchSize);


        }

        return new Info(maxSearchTreeSize, isAllSearchTree, max, min);


    }


}
