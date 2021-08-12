package basic.six;

import java.util.HashMap;

/**
 * @author whz
 *
 */
public class CopyListWithRandom {

    public static class Node{
        private int value;
        private Node next;
        private Node rand;
        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 7.一种特殊的单链表节点类描述如下
     *     class Node{
     *         int value;
     *         Node next;
     *         Node rand;
     *         Node(int value){
     *             this.value = value
     *         }
     *     }
     *     rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null;
     *     给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
     *     时间复杂度O(n) 空间复杂度O(1)   hashMap<Node,Node'>
     *     1)使用hash表的方式
     *     2)操作链表
     *         1.构建 1-》1‘-》2-》2’-》3-》3‘-》null
     *         2.取两个为一组操作 设置clone节点的rand
     *         3.分离
     */

    public static Node copyLinkedListRandom(Node head){
        if(head == null) {
            return null;
        }
        //key 为 老节点 value为新节点
        HashMap<Node,Node> map = new HashMap<Node,Node>();
        Node cur = head;
        //链表存入map
        while (cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        //继续从头开始指向
        cur = head;
        while (cur != null) {
            //map中cur的新节点的next指针 指向cur节点的next对应的新节点
            map.get(cur).next = map.get(cur.next);
            //map中cur的新节点的rand指针 指向cur节点的rand对应的新节点
            map.get(cur).rand = map.get(cur.rand);
            //指针后移
            cur = cur.next;
        }
        return map.get(head);
    }


    /**
     * 不使用辅助空间map 直接在链表上修改
     * @param head
     * @return
     */
    public static Node copyLinkedListRandom2(Node head){
        if(head == null) {
            return null;
        }

        /**
         * 1->2  变成 1 -> 1' -> 2
         */
        Node next = null;
        Node cur = head;

        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //此时我的head还是不变的 因为我把head给cur了

        //取两个为一组 设置clone节点的rand
        cur = head;
        Node clone = null;
        while (cur != null){
            //下一次的环境
            next = cur.next.next;

            //当前clone节点
            clone = cur.next;
            //设置clone节点的rand指针 如果当前节点的rand指针不为空 那么当前当前节点的rand指针的next指向的就是克隆节点了 否则指向null
            clone.rand = cur.rand != null ? cur.rand.next : null;
            //跳到下一次
            cur = next;
        }
        //经过这次循环 结构变为 1 -》 1’ -》 2 -》 2‘ -》 3 -》 3’  并且clone 节点的所有rand指针也都连接好了
        // 下一步需要把 原本节点与克隆节点断开

        //定义一个返回的头节点 第一个clone节点
        Node res = head.next;
        cur = head;
        while (cur != null) {
            //记录一下环境 当前节点的下一个非clone节点
            next = cur.next.next;
            //当前节点的克隆节点
            clone = cur.next;
            //当前节点的next 指向clone的next
            cur.next = next;
            //clone节点的next 指向下一个节点的clone节点  因为需要.next 所以需要判断next是否为空
            clone.next = next != null ? next.next : null;
            //跳向下一环境
            cur = next;

        }
        return res;
    }

}
