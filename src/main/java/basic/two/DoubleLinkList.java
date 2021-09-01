package basic.two;

/**
 * 双向链表的结构  反转双向链表
 *
 * @author whz
 */
public class DoubleLinkList {

    public static class Node{

        private int value;
        private Node next;
        private Node last;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public static Node revertDoubleLinkList(Node head) {

        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            //断开 当前头节点的前指针指向pre pre第一次是null  后续代表上一次的head
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;


    }


    /**
     * 对数器
     */



}
