package basic.eight;

/**
 * @author whz
 *
 * 在一棵二叉树中 给定头节点 寻找出节点间的最大距离
 *
 */
public class MaxDistance {

    /**
     * 树形dp 二叉树的递归套路
     * *     1.假设以x为头节点，假设可以向x左树和x右树要任何信息
     * *     2.在上一步的假设下，讨论以x为头节点的树，得到答案的可能性（最重要），通常情况考虑与x有关的情况 与x无关的情况
     * *     3.列出所有可能性后，确定到底需要向左树和右树要什么的信息
     * *     4.把左树信息和右树信息求全集，就是任何一颗子树都需要返回的信息s
     * *     5.递归函数都返回s 每一颗子树都这么要求
     * *     6.写代码，在代码中考虑如何把左数的信息和右树的信息整合出整棵树的信息
     */

    //这道题 很容易想到的是  是否与x有关  说白了就是你的最长路径是否经过 x
    //如果说不经过x 那么最大距离可能出现在左树上 或者 右树上最大距离
    //如果说经过x 那么最大距离只有一种情况 x左树最左的节点 到 右树最右的节点。 那是不是需要知道 那是不是就是一棵树的高度呢 左高+右高+1
    // info 的信息 高度 和 最大距离 两种情况的全集

    public static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static class Info{
        //这个最大距离 可以分为两个大类   与x无关的时候 最大距离出现在左右子树中
        private int maxDistance;
        //与x有关的时候 最大距离是 x左树最左位置高度 + x右树最右位置高度 + 1
        private int height;

        public Info(int maxDistance, int height){
            this.height = height;
            this.maxDistance = maxDistance;
        }

    }

    public static int getMaxDistance(Node x){
        return process(x).maxDistance;
    }
    public static Info process(Node x){
        if(x == null){
            return new Info(0, 0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance),height);
        return new Info(maxDistance,height);
    }

}
