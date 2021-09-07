package basic.seven;

import java.util.Stack;

/**
 * review 二叉树 的三种遍历方式的非递归版本
 */
public class Review_UnRecursiveTraversalBinaryTree {


    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

    }


    /**
     * 二叉树 的前序遍历 非递归  头左右  在考虑压栈的时候 先压右节点 在压左 处理的时候就变成先左在右了
     *
     * @param head
     */
    public static void pre(Node head) {

        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        //先压入头节点
        stack.push(head);
        while (!stack.isEmpty()) {
            //栈不为空就弹出打印
            Node cur = stack.pop();
            System.out.println(cur.value);
            //当前节点右孩子不为空 压入右
            if (cur.right != null) {
                stack.push(head.right);
            }
            //当前节点左孩子不为空 压入左
            if (cur.left != null) {
                stack.push(head.left);
            }
        }
    }


    /**
     * 二叉树的后续遍历 可以在前序遍历的基础上玩  先压左再压右  只不过在弹出的时候不打印 而是压入一个新的栈中 最后这个栈在依次打印 得到的就是后序遍历
     *
     * @param head
     */
    public static void last(Node head) {

        if (head == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            Node cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) {
                s1.push(cur.left);
            }

            if (cur.right != null) {
                s1.push(cur.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.println(s2.pop().value);
        }

    }

    /**
     * 使用一个栈 与有限的几个变量进行后续遍历
     *
     * @param head
     */
    public static void last2(Node head) {

    }


    /**
     * 二叉树 中序遍历 非递归版本
     */
    public static void mid(Node head) {
        if (head == null) {
            return;
        }

        Stack<Node> s1 = new Stack<>();
        while (!s1.isEmpty() || head != null) {
            if(head != null){
                s1.push(head);
                head = head.left;
            }else {
                //表明从跟节点出发 左树上的所有节点都已经入栈了 当前栈顶元素应该为第一个要弹出打印的
                head = s1.pop();
                System.out.println(head.value);
                //再从这个弹出节点的右孩子继续向左树窜 如果有的情况下 没有的话向上弹出 继续这个逻辑
                head = head.right;
            }

        }
    }
}
