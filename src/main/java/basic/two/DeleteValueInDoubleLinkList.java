package basic.two;

/**
 * 在双向链表中删除某一个指向元素后 返回新的头部节点
 *
 * @author whz
 */
public class DeleteValueInDoubleLinkList {

    public static class DoubleNode {

        private int value;
        private DoubleNode next;
        private DoubleNode last;

        public DoubleNode(int value) {
            this.value = value;
        }
    }


    public static DoubleNode deleteValueInDoubleLinkList(DoubleNode head, int value){
        //还是先考虑如果第一个元素就是要删除的节点进行跳过 找到第一个不是要删除的头节点
        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }
        //前驱节点记录
        DoubleNode pre = head;
        //当前节点记录
        DoubleNode cur = head;

        while (cur != null) {
            if (cur.value == value) {
                //前驱节点的next指针指向当前节点的next指针
                pre.next = cur.next;
                //当前节点的next指针指向的下一个节点的前驱指针指向删除节点的前驱节点
                cur.next.last = pre;
            }else {
                //不是要删除节点  把当前的节点记录成前驱节点
                pre = cur;
            }
            //当前节点跳下一个
            cur = cur.next;
        }
        return head;
    }


}
