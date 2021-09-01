package basic.two;

/**
 * @author whz
 */
public class Review_DoubleLinkedListImplQueen {


    public DoubleNode head;
    public DoubleNode tail;

    public static class DoubleNode {
        private int value;
        private DoubleNode next;
        private DoubleNode last;


        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 双向链表尾部添加一个节点
     */
    public DoubleNode addInTail(int value){
        DoubleNode node = new DoubleNode(value);
        if(head == null){
            head = node;
            tail = node;
        }else {
            node.last = tail;
            tail.next = node;
            tail = node;
        }
        return node;
    }


    /**
     * 在双向链表的头部弹出一个节点
     */
    public Integer popInHead(){
        if(head == null){
            return null;
        }
        DoubleNode cur = head;
        if(head == tail){
            //只有一个
            head = null;
            tail = null;
        }else {
            //不止一个
            //换头
            head = head.next;
            //新头last指向null
            head.last = null;
            cur.next = null;

        }
        return cur.value;
    }


    /**
     * 在双向链表的尾部弹出一个节点
     */
    public Integer pollInLast() {
        if (head == null) {
            return null;
        }
        //记录老的tail 最后需要返回他的信息呢
        DoubleNode cur = tail;

        if (head == tail) {
            //链表中只有一个节点
            head = null;
            tail = null;
        } else {
            //存在不止一个节点
            //新头
            tail = tail.last;
            //新头next是空
            tail.next = null;
            //老头last指向null
            cur.last = null;

        }
        return cur.value;

    }

    public static class MyQueen{
        private Review_DoubleLinkedListImplQueen doubleLinkedListImplQueen;
        public MyQueen(){
            doubleLinkedListImplQueen = new Review_DoubleLinkedListImplQueen();
        }

        public void add(int value){
            doubleLinkedListImplQueen.addInTail(value);
        }

        public Integer poll(){
            return doubleLinkedListImplQueen.popInHead();
        }

        public static void main(String[] args) {
            MyQueen myQueen = new MyQueen();
            myQueen.add(1);
            myQueen.add(2);
            Integer poll = myQueen.poll();
            System.out.println(poll);
        }
    }


}
