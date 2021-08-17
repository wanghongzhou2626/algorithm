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
     * 一旦遇到左右还是不是双全的节点 那么他的后继节点必须都是叶子节点
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

}
