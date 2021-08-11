package basic.seven;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author whz
 *
 * 二叉树的层序遍历 可以考虑使用队列去实现
 */
public class BinaryTreeLevel {

    public static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 使用队列实现一个二叉树层序遍历
     * @param head
     */
    public static void level(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList();
        //层序遍历就是按照从左到右的顺序 依次打印出树中的节点 先把头节点放入 然后弹出 弹出节点有左孩子放入 有右孩子方法 队列是先进先出的
        //然后再根据入队的节点依次找到他们的左右孩子并打印
        queue.add(head);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }
}
