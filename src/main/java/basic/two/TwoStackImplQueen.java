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

    /**
     * 导数的原则 导必须pop为空 push必须导空  在进行操作的时候 add poll peek 全都进行 pushtopop
     */
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
        if (stackPop .empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();//如果倒数的过程没发生 就说明pop里还有东西 直接弹出就可以啦
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
