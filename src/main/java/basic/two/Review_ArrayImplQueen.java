package basic.two;

public class Review_ArrayImplQueen {

    public int[] arr;
    public int limit;
    public int popIndex;
    public int putIndex;
    public int size;

    public Review_ArrayImplQueen(int limit){
        this.limit = limit;
        this.size = 0;
        popIndex = 0;
        putIndex = 0;
        arr = new int[limit];
    }

    public void add(int value){
        //通过一个size去控制
        if(size == limit){
            throw new RuntimeException("队列满了 不能在放了");
        }
        size++;
        arr[putIndex] = value;
        putIndex = nextIndex(putIndex);
    }

    public Integer poll(){
        if(size == 0){
            throw new RuntimeException("队列空了 不能在拿了");
        }
        size--;
        int res = arr[popIndex];
        popIndex = nextIndex(popIndex);
        return res;
    }

    private int nextIndex(int index) {
        //零的含义就是 如果我数据index到头了 但是我size还显示有空间  所以 index重新回到零 继续添加元素  通过size控制所有逻辑
        return index < limit -1 ? index + 1 : 0;
    }


}
