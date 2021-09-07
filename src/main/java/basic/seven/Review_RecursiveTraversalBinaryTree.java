package basic.seven;

/**
 * @author whz
 *
 * 二叉树的 前序 中序 后续 遍历的三种递归 实现方式
 */
public class Review_RecursiveTraversalBinaryTree {


    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 递归 前序遍历
     * @param head
     */
    public static void pre(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    /**
     * 递归 中序遍历
     * @param head
     */
    public static void mid(Node head){
        if(head == null){
            return;
        }
        mid(head.left);
        System.out.println(head.value);
        mid(head.right);
    }

    /**
     * 递归 后续遍历
     * @param head
     */
    public static void last(Node head){
        if(head == null){
            return;
        }
        last(head.left);
        last(head.right);
        System.out.println(head.value);
    }

}
