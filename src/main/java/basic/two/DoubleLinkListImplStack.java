package basic.two;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * 使用双向链表结构来实现 栈结构  队列结构  （头部增加节点  尾部增加节点 头部取出节点 尾部取出节点 等方法）
 *
 * @author whz
 */
public class DoubleLinkListImplStack {


    public static class DoubleNode{

        private int value;
        private DoubleNode next;
        private DoubleNode last;

        public DoubleNode (int value){
            this.value = value;
        }

    }

    /**
     * 使用 双向链表 来模拟 栈 或者 队列的操作。
     */
    public static class DoubleLinkListImplStackOrQueen{
        public DoubleNode head;
        public DoubleNode tail;
        /**
         * 双向链表的头部添加新节点
         */
        public void addNodeFront(int value){
            DoubleNode cur = new DoubleNode(value);
            if (head == null) {
                //设置头尾节点
                head = cur;
                tail = cur;
            }else {
                //说明链表中有节点
                //新节点的next指针指向head
                cur.next = head;
                //头节点的前驱指针指向新节点
                head.last = cur;
                //新节点变头
                head = cur;
            }
        }

        /**
         * 在双向链表的尾部添加新节点
         * @param value
         */
        public void addNodeTail(int value) {

            DoubleNode cur = new DoubleNode(value);
            if (head == null) {
                //设置头尾节点
                head = cur;
                tail = cur;
            }else {
                //说明链表中有节点
                //尾节点的next指针指向当前新节点
                tail.next = cur;
                //新节点的last指针指向tail
                cur.last = tail;
                //新节点变头
                tail = cur;
            }

        }

        /**
         * 在双向链表的头部弹出结点
         * @return
         */
        public Integer popNodeInFront(){
            //如果头节点是null  所以直接返回null
            if (head == null) {
                return null;
            }


            //记录当前的头节点 最后要返回头节点信息
            DoubleNode cur = head;

            //如果链表中只有一个节点呢  那说明这个节点即使头节点也是为节点  需要全部制空
            if(head == tail){
                head = null;
                tail = null;
            }else {
                //链表中存在不止一个节点
                //记录下次的头节点
                head = head.next;

                //这次的头节点的next指针指向空
                cur.next = null;
                //这次头节点的下一个节点的前驱节点指向空
                head.last = null;
            }
            return cur.value;
        }

        /**
         * 在双向链表的尾部弹出结点
         */
        public Integer popInTail(){

            //如果头节点是null  所以直接返回null
            if (head == null) {
                return null;
            }
            //记录当前的尾节点 最后要返回尾节点信息
            DoubleNode cur = tail;

            //如果链表中只有一个节点呢  那说明这个节点即使头节点也是为节点  需要全部制空
            if(head == tail){
                head = null;
                tail = null;
            }else {
                //链表中存在不止一个节点
                //记录下次的尾节点 需要换尾
                tail = tail.last;

                //这次的尾节点的last指针指向空
                cur.last = null;
                //这次尾节点的上一个节点的前驱节点指向空
                tail.next = null;
            }
            return cur.value;
        }

        public boolean isEmpty(){
            return head == null ? false : true;
        }

    }

    /**
     * 使用双向链表模拟出来的栈结构
     */
    public static class Mystack{
        public DoubleLinkListImplStackOrQueen doubleLinkListImplStackOrQueen;

        public Mystack(){
            doubleLinkListImplStackOrQueen = new DoubleLinkListImplStackOrQueen();
        }
        public Integer pop() {
            return doubleLinkListImplStackOrQueen.popNodeInFront();
        }

        public void push(int value){
            doubleLinkListImplStackOrQueen.addNodeFront(value);
        }

        public boolean isEmpty(){
            return doubleLinkListImplStackOrQueen.isEmpty();
        }

    }

    public static class MyQueen{
        public DoubleLinkListImplStackOrQueen doubleLinkListImplStackOrQueen;
        public MyQueen() {
            doubleLinkListImplStackOrQueen = new DoubleLinkListImplStackOrQueen();
        }

        public void push(int value){
            doubleLinkListImplStackOrQueen.addNodeFront(value);
        }

        public Integer poll(){
            return doubleLinkListImplStackOrQueen.popInTail();
        }
    }

   /* public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }


    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            Mystack myStack = new Mystack();
            MyQueen myQueue = new MyQueen();
            Stack<Integer> stack = new Stack();
            Queue<Integer> queue = new LinkedList();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }*/




}
