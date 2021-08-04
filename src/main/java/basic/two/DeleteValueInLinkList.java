package basic.two;

/**
 * 在单链表中删除某一指定元素后返回删除后的链表头节点
 *
 * @author whz
 */
public class DeleteValueInLinkList {


    public static class Node{

        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node deleteValueInLinkList(Node head, int value) {
        //首先考虑头节点就是要删除的元素呢 要考虑换头的操作 首先从头开始找 找到第一个不是要删除节点的元素他就是新的头部
        while (head != null) {
            if(head.value != value) {
                break;
            }
            head = head.next;
        }

        //经过上面的操作 会出现两种情况 1.head为空 说明没有节点 那么直接返回null  2 head ！= null 说明找到了第一个不是要删除的节点
        //需要删除的节点也都被跳过了。

        //
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            //说明需要删除
            if (cur.value == value) {
                //第一个这个分支 是永远不会走的 因为这个节点要是需要被删除 上边就过滤掉了
                pre.next = cur.next;
            }else {
                //这步其实就是在把当前节点记录下 让下一个cur跳转后删除时能有正确的指向
                pre = cur;
            }
            //当前的节点调到下一个
            cur = cur.next;
        }
        // 链表的题目都是想办法记住当前节点的状态 或者上一节点的状态
        return head;
    }

}
