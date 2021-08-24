package basic.ten;

import java.util.*;

/**
 * @author whz
 * <p>
 * 图的最小生成树算法  以最小边权重的代价生成一颗最小生成树
 * <p>
 * 啥是 k算法啊  怎么玩呢
 * 给你一个图 把图中的边 从小到大排序  优先级队列  堆
 * 边的左右节点 如何是一个集合 不操作  如果不是一个集合 union操作
 * 返回生成最小生成树边的集合 set
 * <p>
 * 判断是否是一个 集合 union操作 最好的方法就是使用 并查集
 * 那么如何实现一个并查集呢
 */
public class Kruskal {


    public static class UnionFind {
        //存父节点的集合  key 当前节点  value 当前节点的father
        public HashMap<Node, Node> father;
        //位置节点对应的子节点数量
        public HashMap<Node, Integer> sizeMap;


        public UnionFind() {
            father = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
        }

        public void init(Collection<Node> nodes) {
            for (Node node : nodes) {
                father.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public boolean isSame(Node o1, Node o2) {
            return findFather(o1) == findFather(o2);

        }

        public Node findFather(Node node) {
            //path 的作用是在整个找父的过程中的path 拆离开
            Stack<Node> path = new Stack<Node>();
            if (node != father.get(node)) {
                path.push(node);
                node = father.get(node);
            }
            //path路径上的node的父都变成代表节点
            while (!path.isEmpty()) {
                father.put(path.pop(), node);
            }
            return node;
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }

            //先看看a b 是否是一个集合
            Node nodeA = findFather(a);
            Node nodeB = findFather(b);

            if (nodeA != nodeB) {
                //说明需要合并啊 合并的规则是小集合挂大集合 所以我需要知道 代表节点她下面挂的节点数
                Integer nodeASize = sizeMap.get(nodeA);
                Integer nodeBSize = sizeMap.get(nodeB);

                if (nodeASize > nodeBSize) {
                    // b 挂 a
                    father.put(nodeB, nodeA);
                    sizeMap.put(nodeA, nodeASize + nodeBSize);
                    sizeMap.remove(nodeB);
                } else {
                    // a 挂 b
                    father.put(nodeA, nodeB);
                    sizeMap.put(nodeB, nodeASize + nodeBSize);
                    sizeMap.remove(nodeA);

                }
            }
        }
    }

    public class MyComparator implements Comparator<Edge> {


        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight = o2.weight;
        }
    }

    public Set<Edge> k(Graph graph) {
        HashSet<Edge> result = new HashSet<Edge>();

        UnionFind unionFind = new UnionFind();
        unionFind.init(graph.nodes.values());

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new MyComparator());

        //得到一个边从小到大的队列  其中的结构是一个堆
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            boolean isSame = unionFind.isSame(edge.from, edge.to);
            if (!isSame) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;

    }

}
