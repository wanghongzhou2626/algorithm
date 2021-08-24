package basic.ten;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author whz
 *
 * 图的宽度优先遍历 需要队列 与 set set的作用避免有环的时候死循环
 */
public class GraphBFS {

    /**
     * 图的宽度优先遍历
     * @param node
     */
    public static void bfs(Node node){
        if (node == null){
            return;
        }

        Queue<Node> nodeQueue = new LinkedList<Node>();
        HashSet<Node> set = new HashSet();
        nodeQueue.add(node);
        set.add(node);

        while (!nodeQueue.isEmpty()){
            Node cur = nodeQueue.poll();
            System.out.println(cur.value);

            for (Node next : cur.nexts) {
                //只有不在set中的节点 才会放入队列中
                if(!set.contains(next)){
                    set.add(next);
                    nodeQueue.add(next);
                }
            }
        }
    }
}
