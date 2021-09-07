package basic.seven;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.LinkedList;
import java.util.Queue;

/**
 * review 二叉树的层序遍历  使用队列的方式
 * @author whz
 */
public class Review_BinaryTreeLevel {


    public static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 使用队列的方式 二叉树的层序遍历
     * @param head
     */
    public static void level(Node head){
        if(head != null){
            Queue<Node> queue = new LinkedList<>();
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
}
