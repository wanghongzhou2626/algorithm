package basic.two;

/**
 *  如何反转双向链表
 * @author whz
 */
public class Review_DoubleLinkedList {

    public static class DoubleNode{
        private int value;
        private DoubleNode next;
        private DoubleNode last;

        public DoubleNode(int value){
            this.value = value;
        }
    }

    /**
     * 反转双向链表
     */
      public static DoubleNode reverseDoubleLinkedList(DoubleNode head){
          DoubleNode pre = null;
          DoubleNode next = null;

          while (head != null){
              next = head.next;
              head.next = pre;
              //last指针指向当前的节点  相当与1的last指向二 完成反转
              head.last = next;
              pre = head;
              head = next;

          }
          return pre;
      }

}
