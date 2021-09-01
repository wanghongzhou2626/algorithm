package basic.two;

import java.util.Stack;

/**
 * 实现在一个栈中 存 取 或者最小值 等三个操作的时间复杂度为O(1)
 */
public class Review_GetMinStack {

    public Stack<Integer> dataStack;
    public Stack<Integer> minStack;

    public Review_GetMinStack(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }


    public void push(int value){

        //两个栈都为空时 数据栈 最小栈 都加入元素
        if(minStack.isEmpty()){
            minStack.push(value);
            dataStack.push(value);
        }else {
            if(value <= minStack.peek()){
                minStack.push(value);
                dataStack.push(value);
            }
        }



    }

    public Integer pop(){
        minStack.pop();
        return dataStack.pop();
    }


    public Integer getMin(){
        return minStack.peek();
    }


}
