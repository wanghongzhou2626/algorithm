package basic.two;

/**
 *
 * 用数组实现队列       摒弃快慢指针的方式   使用size变量++ -- 进行控制
 *
 *
 * 思路 push 满了不放 size++ 放数 找下个位置    poll 空了不弹出  size--  拿数  调下一个位置 poll有个控制数组指针的变量  push有一个控制数组指针的变量
 * @author whz
 */
public class ArrayImplQueen {

    public static class MyQueen{

        private int[] arr;
        private int size;
        private int pushi;
        private int polli;
        private int limit;


        public MyQueen(int limit) {
            this.arr = new int[limit];
            this.size = 0;
            this.polli = 0;
            this.pushi = 0;
            this.limit = 0;
        }

        public void add(int value){
            if(size == limit){
                throw new RuntimeException("queen is full");
            };
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);

        }

        public int peek(){
            if(size == 0){
                throw new RuntimeException("queen is empty");
            }
            size--;
            int value = arr[polli];
            polli = nextIndex(polli);
            return value;
        }

        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }



    }






}
