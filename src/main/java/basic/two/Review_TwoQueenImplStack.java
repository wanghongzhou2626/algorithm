package basic.two;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author whz
 * 两个队列实现一个栈结构
 */
public class Review_TwoQueenImplStack {

    public Queue<Integer> queue;
    public Queue<Integer> help;

    public Review_TwoQueenImplStack(){
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    /**
     *
     * @param value
     */
    public void push(Integer value){
        //向队列中添加元素 如果加不进去了会报错
        queue.offer(value);
    }

    /**
     * 弹出逻辑
     * @return
     */
    public Integer poll(){
        //queue 队列一次弹出 直到剩一个元素位置 这个元素就是 你要弹出的元素
        while (queue.size() > 1){
            help.offer(queue.poll());
        }
        //应该得到的答案 出队 此时的queue是空的
        Integer res = queue.poll();
        //queue变help   help变queue
        Queue<Integer> temp = queue;
        queue = help;
        help = temp;
        return res;
    }

    /**
     * 取栈顶的逻辑
     */
    public Integer peek(){
        //queue 队列一次弹出 直到剩一个元素位置 这个元素就是 你要弹出的元素
        while (queue.size() > 1){
            help.offer(queue.poll());
        }
        //应该得到的答案 出队 此时的queue是空的
        Integer res = queue.poll();
        //还得塞回去到help中去  你只是取他的值 并不是把他弹出
        help.offer(res);
        //queue变help   help变queue
        Queue<Integer> temp = queue;
        queue = help;
        help = temp;
        return res;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println("test begin");
        Review_TwoQueenImplStack myStack = new Review_TwoQueenImplStack();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.poll().equals(test.pop())) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
        }

        System.out.println("test finish!");

    }




}
