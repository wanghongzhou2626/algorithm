package basic.two;

import java.util.Stack;

/**
 * 使用数组实现栈结构
 */
public class Review_ArrayImplStack {

    public int[] arr;
    public int index;
    public int size;
    public Review_ArrayImplStack(int limit){
        arr = new int[limit];
        index = 0;
        size = limit;
    }

    public void add(int value){
        if(index >= size){
            throw new RuntimeException("栈满了 不能再放了");
        }
        arr[index++] = value;
    }


    public Integer popInArray(){
        if(index == 0){
            throw new RuntimeException("栈空了 不能再拿了");
        }
        int res = arr[index-1];
        index--;
        return res;
    }



    public static class MyStack{
        public Review_ArrayImplStack arrayImplStack;

        public MyStack(int limit){
            arrayImplStack = new Review_ArrayImplStack(limit);
        }


        public int pop() throws Exception{
            return arrayImplStack.popInArray();
        }

        public void push(int value) throws Exception{
            arrayImplStack.add(value);
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
