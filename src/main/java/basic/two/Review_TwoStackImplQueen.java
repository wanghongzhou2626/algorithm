package basic.two;


import java.util.Stack;

/**
 * 两个栈结构实现一个队列结构
 *
 */
public class Review_TwoStackImplQueen {


    public Stack<Integer> dataStack;
    public Stack<Integer> popStack;

    public Review_TwoStackImplQueen(){
        dataStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int value){
        dataStack.push(value);
        pushToPop();
    }

    public Integer pop(){
        if(popStack.isEmpty() && dataStack.isEmpty() ){
            throw new RuntimeException("stack is empty");
        }

        int res = popStack.pop();
        pushToPop();
        return res;

    }

    public void pushToPop(){

        //导数据的前提条件  data栈必须每次都导空  并且 pop栈必须为空
        if(popStack.isEmpty()){
            while (!dataStack.isEmpty()){
                popStack.push(dataStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        Review_TwoStackImplQueen test = new Review_TwoStackImplQueen();
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.pop());
        test.push(4);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
