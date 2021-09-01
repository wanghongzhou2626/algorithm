package basic.two;

/**
 * review 反转单向链表
 *
 * @author whz
 */
public class Review_LinkedList {

    /**
     * 定义节点类型
     */

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 给定一个头节点 反转单链表 返回反转后的头节点
     */

    public static Node reverseListNode(Node head){
        if(head == null){
            return head;
        }

        Node pre = null;
        Node next = null;
        while (head!= null){
            //记录下次位置
            next = head.next;
            //第一次指向null  后续都是指向前一次记录的pre指向的head
            head.next = pre;
            pre = head;
            //指针跳转
            head = next;
        }
        return pre;
    }

}
