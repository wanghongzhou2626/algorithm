package basic.two;

/**
 * 在双向链表中删除某个节点
 */
public class Review_DoubleLinkedListDeleteNode {

    public static class DoubleNode{
        private int value;
        private DoubleNode next;
        private DoubleNode last;

        public DoubleNode(int value){
            this.value = value;
        }
    }

    /**
     * 双向链表中删除某个元素 考虑头是要删除的
     */

    public static DoubleNode deleteValue(DoubleNode head, int value){

        while (head != null){
            if(head.value != value){
                break;
            }
            head = head.next;
        }
        DoubleNode pre = head;
        DoubleNode cur = head;

        while (cur != null){
            if(cur.value == value){
                pre.next = cur.next;
                cur.next.last = pre;
            }else {
                pre = cur;
            }
            cur = cur.next;

        }
        return head;
    }


}
