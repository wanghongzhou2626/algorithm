package basic.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
     * 如何写单向链表反转的对数器
     * @param head
     */

    /**
     * 绝对正确的方法
     * @param head
     * @return
     */
    public static Node noProblem(Node head){
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);


       /* Stack<Node> stack = new Stack<Node>();
        Node pre = head;
        stack.push(pre);
        LinkedList linkList = new LinkedList();
        while (head != null){
            stack.push(head.next);
            head = head.next;
        }

        while (stack != null){
            linkList.add(stack.pop());
        }
        return (Node) linkList.getFirst();*/
    }

    /**
     * 链表随机发生器
     * @return
     */
    public static Node randLinkList(int len, int value){
        //设置链表长度
        int size = (int)((Math.random() * len) + 1);

        //生成一个头节点 在头节点的基础上添加元素
        Node head = new Node((int)((Math.random() * value) + 1));
        //过程中需要用到的节点初始时为头节点
        Node pre = head;
        //有头了减去一个空间
        size--;
        //构造单向链表
        while (size != 0){
            //当前生成的头节点 需要放入链表中
            Node cur =  new Node((int)((Math.random() * value) + 1));
            //头节点的下一个是当前节点
            pre.next = cur;
            //当前节点是下一个节点的前驱节点
            pre = cur;
            size--;
        }
        //
        return head;




    }

    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }


    public static void main(String[] args) {


        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            Node node1 = randLinkList(len, value);
            List<Integer> list1 = getLinkedListOriginOrder(node1);
            node1 = revertLinkList(node1);
            if (!checkLinkedListReverse(list1, node1)) {
                System.out.println("Oops1!");
            }

            Node node2 = randLinkList(len, value);
            List<Integer> list2 = getLinkedListOriginOrder(node2);
            node2 = noProblem(node2);
            if (!checkLinkedListReverse(list2, node2)) {
                System.out.println("Oops2!");
            }
        }

    }
}
