package basic.eight;



/**
 * @author whz
 *
 * 给定一颗二叉树的头节点，如何确定这颗树是否为平衡二叉树 每颗子树都是平衡二叉树
 *     什么是平衡二叉树？ 任意节点他的左树是平衡的 右数是平衡的 并且左右高度差不能超过1
 *
 *
 *
 *     树形dp 二叉树的递归套路
 *     1.假设以x为头节点，假设可以向x左树和x右树要任何信息
 *     2.在上一步的假设下，讨论以x为头节点的树，得到答案的可能性（最重要），通常情况考虑与x有关的情况 与x无关的情况
 *     3.列出所有可能性后，确定到底需要向左树和右树要什么的信息
 *     4.把左树信息和右树信息求全集，就是任何一颗子树都需要返回的信息s
 *     5.递归函数都返回s 每一颗子树都这么要求
 *     6.写代码，在代码中考虑如何把左数的信息和右树的信息整合出整棵树的信息
 */
public class IsBalance {

    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 我要向我的左数 右数 索要的信息
     * 1.是否平衡
     * 2.高度差是否为1
     * 
     */
    public static class Info{
        private boolean isBalance;
        private int height;
        public Info(boolean isBalance, int height){
            this.isBalance = isBalance;
            this.height = height;
        }
    }
    
    
    
    public static boolean isBalance(Node x){
        
        return process(x).isBalance;
        
    }

    public static Info process(Node x) {
        //递归的终止条件
        if (x == null){
            return new Info(true, 0);
        }
        //向我的左树以及右树索要我需要的信息
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        //整合我的左右树的全集
        int height = Math.max(leftInfo.height , rightInfo.height) + 1;

        boolean isBalance = false;
        //如果我的左数是平衡的 并且我的右数是平衡的 并且左右两课子树的高度差不超过1
        if(leftInfo.isBalance && rightInfo.isBalance && Math.abs(leftInfo.height - rightInfo.height) <= 1){
            isBalance = true;
        }

        //回返info信息
        return new Info(isBalance,height);

    }
}
