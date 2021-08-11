package basic.seven;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Stack;

/**
 * @author whz
 * 二叉树的 先序 中序 后序 的三种遍历方式的迭代版本
 */
public class UnRecursiveTraverSalBinaryTree {


    public static class Node{

        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 迭代版本先序遍历
     * 1.头节点不为空放入栈中
     * 2.弹出打印  如果右节点不为空压入栈中 如果左节点不为空 压入栈中
     * @param head
     */
    public static void pre(Node head){

        if(head == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        //头节点压入栈中
        stack.push(head);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.value);
            //因为先序遍历 是 头左右  栈是先进后出 先压入右 后面先出来的就是左
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }
}
