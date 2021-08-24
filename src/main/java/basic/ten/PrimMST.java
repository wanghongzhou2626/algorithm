package basic.ten;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author whz
 * <p>
 * p算法生成最小生成树
 * <p>
 * 怎么生成  还是使用优先级队列 由最小边构成的边队列   通过一个点 解锁出他的所有边 再从最小边对应的新的点to再去解锁一批边
 * 每次加入节点 需要去重  每次加入边队列 已经走过的边 也不要再次加入了
 * <p>
 * 返回set<edge></>
 */
public class PrimMST {

    public class MyComparator implements Comparator<Edge> {


        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight = o2.weight;
        }
    }

    public Set<Edge> pri(Graph graph) {

        //点集 去重
        HashSet<Node> nodeSet = new HashSet<Node>();

        //边集 去重
        HashSet<Edge> edgeSet = new HashSet<Edge>();

        //结果集
        HashSet<Edge> result = new HashSet<>();

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new MyComparator());

        //随便选一个节点 这么做的目的是为了防森林
        for (Node node : graph.nodes.values()) {

            if (!nodeSet.contains(node)) {
                nodeSet.add(node);
                //把这点点对应的边按照从小到大 放入队列
                for (Edge edge : node.edges) {
                    if (!edgeSet.contains(edge)) {
                        edgeSet.add(edge);
                        priorityQueue.add(edge);
                    }
                }
            }

            while (!priorityQueue.isEmpty()) {
                Edge edge = priorityQueue.poll();

                //找到最小边对应的笑一个node
                Node newNode = edge.to;

                if (!nodeSet.contains(newNode)) {
                    nodeSet.add(newNode);
                    result.add(edge);
                    for (Edge nextEdge : newNode.edges) {
                        if (!edgeSet.contains(nextEdge)) {
                            edgeSet.add(nextEdge);
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
            break;
        }
        return result;
    }
}


