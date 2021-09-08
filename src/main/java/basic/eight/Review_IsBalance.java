package basic.eight;

/**
 * @author whz
 *
 * 给定二叉树的一个头节点，返回这棵树是否为平衡二叉树（二叉树的递归套路）
 * 什么是平衡二叉树定义是什么，平衡性的概念，左右子树高度差不超过1 左树达到平衡 右树达到平衡
 *
 *
 *  二叉树的递归套路
 *  1) 假设以X节点为头，假设可以向x左树和x右树要任何信息
 *  2) 在上一步的假设下，讨论已x为头节点的树，得到答案的可能性（最重要）
 *  3) 列出所有可能性后，确定到底需要向左树右树要什么样的信息
 *  4) 把左树信息和右树信息求全集，就是任何一颗子树都需要返回的信息s
 *  5) 递归函数都返回s 每一颗子树都这么要求
 *  6) 写代码，在代码中考虑如何把左树的信息和右树的信息整合出整棵树的信息
 *
 *
 *  只有与x有关这一种  我需要向我的左树 右树索要的信息 也就是你是否是平衡 你的高度是多少
 *
 *
 *
 *
 */
public class Review_IsBalance {



    public static class Info{
        //是否平衡
        boolean isBalance;
        //子树高度
        int height;

        public Info(boolean isBalance, int height){
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
        }
    }


    public static boolean isBalance(Node node){
        if(node == null){
            return false;
        }

        return process(node).isBalance;
    }

    private static Info process(Node node) {
        //base case
        if(node == null){
            return new Info(true,0);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        //树高度 左树 或者 右树中高度最大的那个 再加1
        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        //是否平衡
        boolean isBalance = false;
        if(leftInfo.isBalance
                && rightInfo.isBalance
                && Math.abs(leftInfo.height - rightInfo.height) <= 1){
            isBalance = true;
        }


        return new Info(isBalance,height);


    }
}
