package basic.two;

/**
 * 如何反转单向链表    3为头节点 3->4->5->null    反转后  null<-3<-4<-5 5为头节点
 *
 * @author whz
 */
public class LinkList {


    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node revertLinkList(Node head) {
        /**
         * 反转过程
         * 1)先用一个变量记录当前头节点的下一个节点  因为这个变量会是下一个head
         * 2)记录以后当前节点的next指针指向空
         * 3)记录一个当前节点因为下一个节点的next指针会指向当前的这个节点
         * 4)下次循环的头节点用第一步记录的头节点的下一个节点
         *
         */

        //在反转过程中记录下个节点往回指 应该指到的那个节点    正向 2->3  反向指 2<-3 2节点就是这个pre 需要记录。
        Node pre = null;
        //每次循环中的新头节点
        Node nextHead = null;
        while (head != null) {
            //先记录下一次的头节点
            nextHead = head.next;
            //第一次指向的就是空 因为反转后原始头节点指向应该是null  如果不是第一次 指向的就是上一次的头
            head.next = pre;
            //记录下一次往回指向
            pre =head;
            //下一次的头指向保存好的下一次应该指向的头节点
            head = nextHead;
        }
        //返回反转后的新头部
        return pre;
    }

    /**
     * ru
     * @param args
     */


    public static void main(String[] args) {

    }
}
