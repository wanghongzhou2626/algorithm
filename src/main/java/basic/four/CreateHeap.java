package basic.four;


/**
 * 如何构建一个堆结构  （大根堆）
 *
 * 小根堆 同理
 */
public class CreateHeap {

    public static class MyMaxHeap{

        public int[] heap;
        public int limit;

        //堆的大小
        public int heapSize;

        public MyMaxHeap(int limit){
            this.heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;
        }

        public void push(int value){
            if(heapSize == limit){
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap,heapSize++);
        }

        public Integer pop(){

            //弹出的元素应该是堆定  并且保证弹出以后 剩下的结构依然为大根堆
            int res = heap[0];
            //堆定位置 与 最后一个位置交换 然后重新调整大根堆
            swap(heap,heap[0],--heapSize);
            //如何进行heapify 我与我左右孩子（如果有） 比较 如果比我左右孩子中最大的小 跟最大的交换 然后继续
            heapify(heap,0,heapSize);
            return res;

        }

        private void heapify(int[] heap, int i, int heapSize) {
            int left = i * 2 + 1;
            while(left < heapSize){
                    //如果我存在右孩子 找我的左右孩子最大的
                int maxChildrenIndex = left+1 < heapSize && heap[left] > heap[left+1] ? left : left + 1;
                /*if(heap[maxChildrenIndex] > heap[i]){
                    maxChildrenIndex = maxChildrenIndex;
                }else {
                    maxChildrenIndex = i;
                }*/
                maxChildrenIndex = heap[maxChildrenIndex] > heap[i] ? maxChildrenIndex : i;
                if(maxChildrenIndex == i){
                    //i位置大于他的左右孩子不需要向下沉了
                    break;
                }

                //不相等的情况 交换两个位置
                swap(heap,maxChildrenIndex,i);
                i = maxChildrenIndex;
                left = i * 2 + 1;

            }


        }

    }


    /**
     * 以下表i等于0开始  左孩子 2*i+1 右孩子 2*i+2  某个节点的父 i-1/2
     * 首先明确什么是大根堆 每颗子树的头节点都是整课数最大的节点 堆结构首先是完全二叉树
     *
     * @param arr
     */

    private static void heapInsert(int[] arr, int i) {

        //当前i位置的元素 如果i大于他的父亲 他俩交换 继续向上调整
        //当前节点的父怎么表示
        while (arr[i] > arr[i - 1 / 2]) {
            swap(arr, i, i - 1 / 2);
            i = i - 1 / 2;
        }


    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
