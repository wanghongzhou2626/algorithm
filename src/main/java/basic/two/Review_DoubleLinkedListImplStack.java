package basic.two;

/**
 * @author whz
 * 使用双向链表的结构实现一个栈的功能
 */
public class Review_DoubleLinkedListImplStack {
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
     * 在双向链表的头部添加一个元素 返回新的head
     */
    public DoubleNode addNodeInHead(int value) {
        DoubleNode node = new DoubleNode(value);
        if (head == null) {
            //说明此时链表是空的 没有头没有尾 直接加进去
            head = node;
            tail = node;
        } else {
            //说明之前链表已经有节点了
            node.next = head;
            head.last = node;
            //当前节点做头部
            head = node;
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


    public static class MyStack{

        private Review_DoubleLinkedListImplStack doubleLinkedListImplStack;

        public MyStack(){
            doubleLinkedListImplStack = new Review_DoubleLinkedListImplStack();
        }

        public DoubleNode push (int value){
            return doubleLinkedListImplStack.addNodeInHead(value);
        }

        public Integer pop(){
            return doubleLinkedListImplStack.popInHead();
        }

        public static void main(String[] args) {
            MyStack myStack = new MyStack();
            myStack.push(1);
            DoubleNode push = myStack.push(2);
            //System.out.println(push.value);
            myStack.push(3);
            Integer pop = myStack.pop();
            System.out.println(pop);


        }
    }
}
