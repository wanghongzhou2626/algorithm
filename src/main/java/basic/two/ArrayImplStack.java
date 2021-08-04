package basic.two;

import java.util.Stack;

/**
 * 使用数组来模拟 一个栈结构    定义一个index变量  初始值为零 随着数据的增加index进行++操作  取数据呢  index-- - 1
 * @author whz
 */
public class ArrayImplStack {

    public int[] arr;
    //记录位置的下表
    public int index = 0;
    //限制数据的大小 因为是数组
    public int limit;

    public ArrayImplStack(int limit){
        this.limit = limit;
        arr = new int[limit];
    }

    public int popInArray() throws Exception{
        if(index == 0) {
            throw new RuntimeException("栈已经空了，不能再取元素了");

        }
        int ret = arr[index - 1];
        index--;
        return ret;

    }

    public void pushInArray(int value) throws Exception{
        if (index > limit - 1) {
            throw new RuntimeException("栈已经满了！不能在存放元素了");
        }
        arr[index++] = value;
    }

    public static class MyStack{
        public ArrayImplStack arrayImplStack;

        public MyStack(int limit){
            arrayImplStack = new ArrayImplStack(limit);
        }


        public int pop() throws Exception{
            return arrayImplStack.popInArray();
        }

        public void push(int value) throws Exception{
            arrayImplStack.pushInArray(value);
        }


    }

    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }


    public static void main(String[] args) {
        try {
            Stack stack = new Stack();
            MyStack myStack = new MyStack(100000);


            for (int j = 0; j < 100000; j++) {
                int nums = (int) (Math.random() * 100);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {

                        if (!isEqual(myStack.pop(), (Integer) stack.pop())) {
                            System.out.println("mystack pop = " + myStack.pop() +"  "+ "stack.pop = " + stack.pop());
                            System.out.println("oops!");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
