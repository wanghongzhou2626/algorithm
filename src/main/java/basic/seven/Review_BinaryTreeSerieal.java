package basic.seven;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author whz
 *
 * 二叉树的 前序遍历 序列化 与 反序列化
 */
public class Review_BinaryTreeSerieal {

    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }

    }


    /**
     * 先序 方式 序列化二叉树
     * @param head
     * @return
     */
    public static Queue preSerieal(Node head){
        Queue<Integer> ans = new LinkedList<>();
        pres(head,ans);
        return ans;

    }

    private static void pres(Node head, Queue<Integer> ans) {
        if(head == null){
            //空的情况
            ans.add(null);
        }else {
            //头
            ans.add(head.value);
            //左
            pres(head.left,ans);
            //右
            pres(head.right,ans);
        }
    }

    public static Node buildPreSerial(Queue<Integer> queue){
        if(queue == null || queue.size() == 0){
            return null;
        }
        return preBuild(queue);
    }

    /**
     * 二叉树 先序方式 反序列化 已什么方式构建 已什么方式进行反序列化
     * @param queue
     * @return
     */
    private static Node preBuild(Queue<Integer> queue) {
        Integer value = queue.poll();
        if(value == null){
            return null;
        }
        Node head = new Node(value);
        head.left = preBuild(queue);
        head.right = preBuild(queue);
        return head;
    }


    /**
     * 中序方式序列化二叉树
     */
    public static Queue<Integer> midSerial(Node head){
        Queue<Integer> ans = new LinkedList<>();
        midS(head,ans);
        return ans;
    }

    private static void midS(Node head, Queue<Integer> ans) {

        if(head == null){
            ans.add(null);
        }else {
            midS(head.left,ans);
            ans.add(head.value);
            midS(head.right,ans);
        }
    }


}
