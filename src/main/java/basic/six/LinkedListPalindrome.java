package basic.six;

import java.util.Stack;

/**
 * @author whz
 *
 * 链表回文结构   aba   1221  12344321  正着念与反着念一样
 */
public class LinkedListPalindrome {

    public static class Node{

        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }

    }

    /**
     * 单链表判断是否是回文结构   循环压栈 循环与栈中元素进行比较 不相同说明不是回文结构
     * @param head
     * @return
     */
    public static boolean linkedListPalindrome(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null){
            if(stack.pop().value != head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }


    /**
     * 快慢指针 找中点 中点后位置压栈 比对
     */
    public static boolean isPalindromeMid(Node head){
        //如果他只有一个元素 不管他是啥 都算是回文
        if(head == null || head.next == null){
            return true;
        }

        //设置快慢指针
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //循环后的slow就是中点位置了 如果节点数为奇数那么返回的就是中点位置 如果节点数为偶数返回的就是下中点位置
        //现在将slow后续的节点压入栈中
        Stack<Node> stack = new Stack<Node>();
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        //拿出栈中数据 与 链表头节点开始作比较
        while (!stack.isEmpty()){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

}
