package basic.ten;

import java.util.*;

/**
 * 图的拓扑排序
 * <p>
 * 在一张有向无环图中 寻找入度为零的节点 并把他的next节点-1 在寻找下一个入度为零的节点  得到的result 就是图的拓扑排序
 *
 * @author whz
 */
public class GraphTopologySort {


    public static List<Node> sort(Graph graph) {
        HashMap<Node, Integer> nodeIn = new HashMap<Node, Integer>();
        Queue<Node> zeroInQueue = new LinkedList<Node>();

        for (Node node : graph.nodes.values()) {
            nodeIn.put(node, node.in);
            //构造数据时一定会有一个入度为0的点  把他放入一个队列中
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        ArrayList<Node> result = new ArrayList<Node>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                nodeIn.put(next, nodeIn.get(next) - 1);
                if (nodeIn.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;

    }

}
