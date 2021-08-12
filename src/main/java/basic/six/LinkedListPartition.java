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


    public static Node linkedListPartition(Node head, int value){
        //创建六个指针 分别代表 小于区域头节点 尾节点
        // 大于区域 头节点 尾节点
        // 等于区域 头节点 尾节点
        Node sH = null;
        Node sT = null;

        Node eH = null;
        Node eT = null;

        Node bH = null;
        Node bT = null;

        Node next = null;
        while (head != null) {
            //记录一下 下个节点的环境
            next = head.next;
            //断开当前节点与后续节点的联系 你已经用next变量存储了环境 为啥断开 你现在是单独拿出某个节点 往三个区域去发货 并建立新的连接
            head.next = null;
            //如果当前节点的值小于划分值那么规划到小于区域中
            if(head.value < value){
                //如果小于区域的头节点为空说明还没有元素呢  头节点和尾节点都是当前节点
                if(sH == null){
                    sH = head;
                    sT = head;
                }else {
                    //说明此时的小于区域已经存在节点了 怎么把他连进去 并且当前节点为新的尾节点
                    //当前小于区域的尾节点的next指针 应该指向当前节点
                    sT.next = head;
                    //当前节点 应该变成尾节点
                    sT = head;
                }
                //如果当前划分值 与 当前节点值相等 我应该怎么办 还是加入到等于区域 并且也是两种情况
            } else if (head.value == value) {
                //如果我小于区域此时还没有值呢 头尾都指向当前节点即可
                if(eT == null) {
                    eH = head;
                    eT = head;
                }else {
                    //说明有节点了 那么就得插到等于区的尾部节点  并且当前节点为尾部
                    eT.next = head;
                    eT = head;
                }
            } else {
                //此时的当前节点应该去大于区域
                // 如果大于区域为空 直接头尾都指向当前节点
                if(bH == null) {
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;

        }

        //此时的链表分成了三个区域 小于 等于 大于 现在需要把 小于区域的尾 连到等于区域的头 等于区域的尾连到大于区域的头
        //但是要考虑各种情况

        //如果小于区域尾部不为空 说明小于区域有节点 用小于区域的尾巴连等于区域的头
        if(sT != null) {
            sT.next = eH;
            //谁去连大约区域的头 谁就变成eT
            eT = eT == null ? sT : eT;

        }
        //下一步 需要用eT去连接大于区域的头 此时的et可能就是et 但是这个et也是有可能为null的  也有可能是小于区域的头
        //说明我有自己的et
        if(eT != null){
            //等于区域的尾连大于区域的头
            eT.next = bH;
        }

        //如果小于区域头不为空 返回小于区域的头
        // 如果小于区域头为空 看等于区域头是否为空 不为空返回等于区域头 否则返回 大约区域头
        return sH != null ? sH : (eH != null ? eH :bH);

    }
}
