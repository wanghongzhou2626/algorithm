package basic.eight;

/**
 * @author whz
 * <p>
 * 给定二叉树的头节点 判断二叉树是否为二叉搜索树
 * 什么是二叉搜索树 以某个节点为例 他的左子树都比自己小 他的右子树都比自己大
 */
public class IsSerachTree {

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    /**
     * 树形dp 二叉树的递归套路
     * *     1.假设以x为头节点，假设可以向x左树和x右树要任何信息
     * *     2.在上一步的假设下，讨论以x为头节点的树，得到答案的可能性（最重要），通常情况考虑与x有关的情况 与x无关的情况
     * *     3.列出所有可能性后，确定到底需要向左树和右树要什么的信息
     * *     4.把左树信息和右树信息求全集，就是任何一颗子树都需要返回的信息s
     * *     5.递归函数都返回s 每一颗子树都这么要求
     * *     6.写代码，在代码中考虑如何把左数的信息和右树的信息整合出整棵树的信息
     */

    //这道题 我左右子树 需要返回的信息 只有是不是搜索二叉树 并且左树 需要返回最小值  右树 需要返回最大值
    //为了做到我向我的左右子树索要的信息保持一直 所以我的info定义为  isSearchTree min max

    public static class Info {
        private boolean isSearch;
        private int max;
        private int min;

        public Info(boolean isSearch, int max, int min) {
            this.isSearch = isSearch;
            this.max = max;
            this.min = min;
        }
    }

    public static boolean isSearchTree(Node head) {
        if(head == null){
            return true;
        }
        return process(head).isSearch;
    }

    public static Info process(Node head) {
        if (head == null) {
            //这里为啥可以返回null  因为当我节点为空的时候 我也不好确定 min max的值的情况   后续使用的时候需要都做非空判断了
            return null;
        }

        //向我的左右节点索要信息
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        //整合信息

        int max = head.value;

        if (leftInfo != null) {
            //更新max的值 左节点 更新 max
            max = Math.max(max, leftInfo.max);
        }

        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
        }


        int min = head.value;

        if (leftInfo != null) {
            //更新min的值 左节点
            min = Math.min(min, leftInfo.min);
        }

        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
        }


        //如何判断当前节点是否满足二叉搜索树
        boolean isSerach = true;
        if (leftInfo != null && !leftInfo.isSearch && leftInfo.max >= head.value) {
            isSerach = false;
        }

        if (rightInfo != null && !rightInfo.isSearch && rightInfo.min <= head.value) {
            isSerach = false;
        }

        //返回
        return new Info(isSerach, max, min);

    }


}
