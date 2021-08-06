package basic.two;

import java.util.Stack;

/**
 * @author whz
 *
 * 实现在一个栈中 存 取 或者最小值 等三个操作的时间复杂度为O(1)
 * 1.采用两个栈  一个为数据栈 一个为最小值栈
 */
public class GetMinInStack {

    public static Stack<Integer> dataStack = new Stack<Integer>();
    public static Stack<Integer> minStack = new Stack<Integer>();


    public static Integer getMinInStack(){
        /**1
         * 1.如果最小栈 与 数据栈都为空 说明没有元素
         */

        if (dataStack.isEmpty()){
            throw new RuntimeException("min stack is empty");
        }
        return minStack.peek();

    }


    public static Integer pop(){
        /**
         * 1.如果数据栈为空 抛异常
         * 2.取出数据站元素  如果发现取出元素  与 最小栈取出元素相同 那么最小栈也弹出 因为数据已经没了 最小的不是他了
         * 3.返回数据栈的元素
         */
        if(dataStack.isEmpty()){
            throw new RuntimeException("dataStack is empty");
        }
        Integer dataPop = dataStack.pop();
        if(dataPop.equals(getMinInStack())){
            minStack.pop();
        }
        return dataPop;
    }


    public static void push(Integer value){
        /**
         * 1. 不管什么情况 data栈来元素是一定存入的
         * 2. 如果最小栈中元素空  存入 如果最小栈中元素大于等于要存入的元素 说明新来的数就是最小的 所以应该进入最小站。
         */
        if (minStack.isEmpty()) {
            minStack.push(value);
        }else if(value <= getMinInStack()){
            //当存入的值小于最小站中的值时，将这个值存入最小站。
            minStack.push(value);
        } else {
            //当前栈的栈顶更小 应该重复压入
            minStack.push(minStack.peek());
        }
        dataStack.push(value);
     }






}
