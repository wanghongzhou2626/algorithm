package basic.eight;

/**
 *
 * @author whz
 *
 * 给定一颗二叉树 如何判断是否为满二叉树
 *
 * 什么是满二叉树 2^n - 1 等于整颗树上的所有节点
 *
 * 树形dp 二叉树的递归套路
 *  *     1.假设以x为头节点，假设可以向x左树和x右树要任何信息
 *  *     2.在上一步的假设下，讨论以x为头节点的树，得到答案的可能性（最重要），通常情况考虑与x有关的情况 与x无关的情况
 *  *     3.列出所有可能性后，确定到底需要向左树和右树要什么的信息
 *  *     4.把左树信息和右树信息求全集，就是任何一颗子树都需要返回的信息s
 *  *     5.递归函数都返回s 每一颗子树都这么要求
 *  *     6.写代码，在代码中考虑如何把左数的信息和右树的信息整合出整棵树的信息
 *
 *
 *  分析 以x为头的节点 我需要收集什么样的信息  树高度 以及 节点数
 *
 *
 */
public class IsFull {

    public static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;

        }
    }


    /**
     * 向子树索要的信息
     */

    public static class Info{
        private int height;
        private int nodes;
        public Info(int height, int nodes){
            this.height = height;
            this.nodes = nodes;
        }

    }


    public static boolean isFull(Node x){
        if(x == null){
            return true;
        }
        Info process = process(x);
        return (1 << process.height) - 1 == process.nodes;


    }

    private static Info process(Node x) {

        if(x == null){
            return new Info(0,0);
        }

        //向我的左树右树索要信息
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height)  + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height,nodes);
    }

}
