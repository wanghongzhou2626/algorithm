package basic.seven;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * review 二叉树最大宽度
 *
 * @author whz
 */
public class Review_BinaryTreeLevelMaxWeight {

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }


    }

    /**
     * 采用hashmap 的方式 寻求一种机制 能知道某一层的开始或者结束
     * 然后在下一层开始的时候去结算上一层的最大节点个数 取全局max
     * <p>
     * 额外空间 O(n)
     *
     * @param head
     * @return
     */
    public static int maxWeight(Node head) {
        // 记录每个节点 在第几层
        HashMap<Node, Integer> map = new HashMap<>();
        // 当前层
        int curLevel = 1;
        // 当前层节点数  为什么是零 我约定好的规则在当前层结束后 统计数量
        int curLevelNodes = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        map.put(head, 1);
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            //当前节点所在的层数
            int curNodeLevel = map.get(cur);
            if (cur.left != null) {
                map.put(cur.left, curLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, curLevel + 1);
                queue.add(cur.right);
            }
            //说明 还有没跳到下一次 当前层还没有结束 所以当前层节点数++
            if (curLevel == curNodeLevel) {
                curLevelNodes++;
            } else {
                //说明新的一层开始了 应该去结算上一层了
                max = Math.max(max, curLevelNodes);
                curLevel++;
                //已经开始了 所以从1开始
                curLevelNodes = 1;
            }

        }
        max = Math.max(max, curLevelNodes);
        return max;
    }


    /**
     * 能不能 不使用辅助空间 用有限的几个变量来搞定这件事情
     * 可能需要换一种记录策略 之前是记录什么时候新的一层开始了
     * <p>
     * 现在我能不能记录节点的位置 当前层的最后节点  下一层的最后节点
     *
     * @param head
     * @return
     */
    public static int maxWeight2(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;
        Node nextEnd = null;
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            //说明当前层结束了 应该结算了
            if (cur == curEnd) {
                max = Math.max(max, curLevelNodes);
                //下一层变当前
                curEnd = nextEnd;
                //来到新的一层了重新开始
                curLevelNodes = 0;
            }
        }

        return max;


    }
}
