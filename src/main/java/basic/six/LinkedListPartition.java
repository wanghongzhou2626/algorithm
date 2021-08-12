package basic.six;

/**
 * @author whz
 * 6.将单向链表按某值 划分成左边小，中间相等，右边大的形式
 * 1)链表放入数组中进行 partition 过程 笔试 时间复杂度O(N)
 * 2)分成小 中 大 三部分 然后串起来(*串起来的过程很重要)。面试
 * 六个指针
 */
public class LinkedListPartition {


    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static Node linkedListPartitionInArray(Node head, int value) {
        //把链表放入数组中进行partition

        //1.确定数组的长度 怎么确定遍历链表 用一个变量记录
        //2 创建一个长度为上一步变量的数组 然后把链表中的节点复制进去 得到一个数组
        //3 在这个数组中进行partition
        if (head == null) {
            return null;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        //重置 cur
        cur = head;
        //没别的含义 就是省一个变量
        i = 0;
        Node[] node = new Node[i];
        for (i = 0; i < node.length; i++) {
            node[i] = cur;
            cur = cur.next;
        }
        //经历完partition过程后 数组中的元素以某个值进行划分 小于在左侧 等于在中间 大于在右侧
        partition(node, value);

        //然后呢 把数组中的每个节点串联起来 怎么穿 0位置next是1 1位置next是2 2位置next是3
        for (i = 1; i < node.length; i++) {
            node[i - 1].next = node[i];
        }
        node[i - 1].next = null;
        //串完之后的结果返回数组中零位置的节点
        return node[0];

    }

    /**
     * 数组中partition 以某个数
     * @param nodes
     * @param value
     */
    private static void partition(Node[] nodes, int value) {
        //L 为数组的左边界 -1 位置 不停的向右扩
        int L = -1;
        //R 为数组右边界 没包含最后一个值
        int R = nodes.length;
        //定义一个 数组向下跳的指针
        int index = 0;

        //在这个范围内进行partition
        while (index < R) {
            if (nodes[index].value < value) {
                //数组中指针向后移动 并且当前index位置的数字与小于区域的下一个进行交换 就是小于区域扩充一个位置
                swap(nodes, index++, ++L);
            } else if (nodes[index].value == value) {
                index++;
            } else {
                //index 位置的值大于 划分值 怎么做呢  index位置的值 与大于区域的前一个值进行交换如果是第一次就是和数组最后一个进行交换
                // 交换前 大于区域想左阔一个 index维持不动 因为你不知道新换过来的index位置的值的情况 所以继续看index位置的值
                swap(nodes, index, --R);
            }
        }

    }

    /**
     * 交换数组中两个元素
     * @param nodes
     * @param i
     * @param j
     */
    public static void swap(Node[] nodes, int i, int j) {
        int temp = nodes[i].value;
        nodes[i].value = nodes[j].value;
        nodes[j].value = temp;
    }
}
