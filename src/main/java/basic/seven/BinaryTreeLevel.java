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

    public static void level(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList();
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
