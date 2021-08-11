package basic.seven;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author whz
 * 1.二叉树的先序 中序 后序 遍历的递归实现
 */
public class RecursiveTraversalBinaryTree {

    /**
     * 二叉树中的节点类型
     */
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }


    /**
     * 二叉树的先序递归遍历
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
     * 二叉树中序遍历
     * @param head
     */
    public static void in(Node head){
        if(head == null){
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    /**
     * 二叉树后序遍历
     * @param head
     */
    public static void pos(Node head){
        if(head == null){
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);

    }



}
