package basic.two;

/**
 * 在单向链表中删除某一个节点 并返回新的头部
 * @author whz
 */
public class Review_LinkedListDeleteHead {


    public static class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node deleteHead(Node head, int value){
        //如果头节点是要删除的节点 涉及到一个换头的操作 先确定出要返回的新头部
        while(head != null){
            if(head.value != value){
                break;
            }

            head = head.next;
        }

        //删表中的节点
        Node pre = head;
        Node cur = head;

        while (cur!= null){
            if(cur.value == value){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;

    }
}
