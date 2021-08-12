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
        if (head == null){
            return false;
        }
        Stack<Node> stack = new Stack<Node>();

        while (head != null){
            stack.push(head);
            head = head.next;
        }

        while (head != null){
            if(stack.pop().value != head.value){
                return false;
            }
        }
        return true;
    }

}
