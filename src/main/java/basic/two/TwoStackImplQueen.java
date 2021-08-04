package basic.two;

import java.util.Stack;

/**
 * 使用两个栈 去实现一个队列    重点是 push栈的数据像 pop栈导的过程  add的时候需要push后进行导入
 * @author whz
 */
public class TwoStackImplQueen {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackImplQueen(){
        this.stackPop = new Stack<Integer>();
        this.stackPush = new Stack<Integer>();
    }

    public void pushToPop(){
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int value){
        stackPush.push(value);
        pushToPop();
    }

    public int poll(){
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.pop();

    }

    public int peek(){
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.peek();

    }
}
