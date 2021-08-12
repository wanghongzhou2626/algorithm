package basic.six;

/**
 * @author whz
 *
 *1.(快慢指针)给定一个链表的头节点，如果链表中节点个数为奇数 返回中点位置的节点 如果链表的中的个数为偶数 返回上中点位置的节点
 */
public class LinkedListFindMid {

    public static class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 在链表中寻找中点位置  偶数 上中点 奇数 中点
     * @param head
     * @return
     */
    public static Node findMid(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        //说明链表中有三个节点或以上
        //慢指针在1位置
        Node slow = head.next;
        //快指针在二位置
        Node fast = head.next.next;
        //说明后续还有节点 并且跳动的长度够快慢指针走一次的长度
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //最后返回的慢指针就是最终中点位置 并且如果节点个数偶数返回的是上中点位置 如果是奇数的话返回的就是中点位置。
        return slow;
    }


    /**
     * 在链表中寻找中点位置  偶数 下中点 奇数 中点
     * 1->2
     *    S
     *    F
     * 1->2->3
     *    S
     *    F         返回2
     * 1->2->3->4
     *    S1 S2
     *    F1    F2  返回3
     * @param head
     * @return
     */
    public static Node findMidNext(Node head){
        if(head == null || head.next == null){
            return head;
        };
        Node slow = head.next;
        Node fast = head.next;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        };
        return slow;
    }



}
