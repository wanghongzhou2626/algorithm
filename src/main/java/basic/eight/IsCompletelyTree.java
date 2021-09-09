package basic.eight;

import java.util.LinkedList;

/**
 * @author whz
 * <p>
 * 给定一颗二叉树的头节点head 返回这颗二叉树是不是完全二叉树
 */
public class IsCompletelyTree {


    /**
     * method 1  任何节点有右无左 返回false  否则继续
     * 一旦遇到左右不双全的节点 那么他的后继节点必须都是叶子节点
     */

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static boolean isCompletelyTree(Node node) {
        if (node == null) {
            return true;
        }
        //准备一个队列
        LinkedList<Node> queen = new LinkedList<Node>();

        //准备一个变量 判断是不是左右子树都全情况  一旦遇到不是双全 那么他的后面节点必须都是叶子节点
        //是否遇到过左右两个还是不双全的节点
        boolean leaf = false;
        queen.add(node);
        Node l = null;
        Node r = null;
        while (!queen.isEmpty()) {
            Node cur = queen.poll();
            l = cur.left;
            r = cur.right;
            //如果任何节点有右无左直接返回false
            if (r != null && l == null) {
                return false;
            }
            //如果他是左右节点不爽全 并且 他的后面节点不是叶子 return false
            if (leaf && (l != null || r != null)) {
                return false;
            }
            if (l != null) {
                queen.add(l);
            }
            if (r != null) {
                queen.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }


        }
        return true;


    }


    /**
     * method 2  二叉树递归套路
     * <p>
     * x 以什么为分类呢  以最后一层到哪里了 来分类 都可能到哪里呢 没有过最后一层的左树  过了左树 左右不在同一层  过了左树 左右在同一层
     * 1）我所有层都是满的 就是最后一层到最后位置了呢 满二叉树一定是完全二叉树 无缺口 左树满 右树满 高度相同
     * <p>
     * 2）有缺口 最后的一层一个节点 没有越过左树 左树完 右树满  左树告诉比右树高度大一
     * 3）过了左树  左树是满的 右数是满的 左比右高度差1
     * 4）左树满的 右树完全 高度相等
     * <p>
     * <p>
     * 我要啥信息  对于每一颗子树 是否是满的二叉树 是否是完全的 你的高度
     * 高度 如何加工  左树与右树中高度最大值 加 1
     * 是不是满二叉树 怎么加工 左数是满二叉树 并且 右树是满 并且他们的高度相同
     * 是不是完全二叉树怎么加工
     */

    public static class Info {
        //以某一个节点为头他的最大高度
        private int height;
        //已某一个节点为头的 他是不是完全二叉树
        private boolean isCBT;
        //已某一个节点为头的 他是不是满二叉树
        private boolean isFST;

        public Info(int height, boolean isCBT, boolean isFST) {
            this.height = height;
            this.isCBT = isCBT;
            this.isFST = isFST;

        }
    }

    public static boolean isCBT(Node node) {
        if (node == null) {
            return true;
        }
        return process(node).isCBT;

    }

    private static Info process(Node node) {
        if (node == null) {
            return new Info(0, true, true);
        }

        //索要信息
        Info infoLeft = process(node.left);
        Info infoRight = process(node.right);

        int height = Math.max(infoLeft.height, infoRight.height) + 1;

        boolean isFBT = false;
        if (infoLeft.isFST && infoRight.isFST && infoLeft.height == infoRight.height) {
            isFBT = true;
        }

        boolean isCBT = false;
        if (isFBT) {
            isCBT = true;
        } else {
            //基本条件 就是左右必须都是完全的才有讨论的意义
            if (infoLeft.isCBT && infoRight.isCBT) {
                //如果没越过左树 左树是完全的 右数是满的 并且左树高度比右树高1
                if (infoLeft.isCBT && infoRight.isFST && Math.abs(infoLeft.height - infoRight.height) >= 1) {
                    isCBT = true;
                }
                //如果左树被填满了 左树是满的 右树是满的  并且 左数比右数高1
                if (infoLeft.isFST && infoRight.isFST && Math.abs(infoLeft.height - infoRight.height) >= 1) {
                    isCBT = true;
                }
                //如果左树是满的 右树是完全的 并且高度相同 在一层上
                if (infoLeft.isFST && infoRight.isCBT && infoLeft.height == infoRight.height) {
                    isCBT = true;
                }
            }
        }

        return new Info(height, isCBT, isFBT);

    }


}
