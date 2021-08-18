package basic.ten;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author whz
 *
 * 图的点结构描述
 *
 */
public class Node {

    public int value;
    /**
     * 当前节点的入度 别人指向它
     */
    public int in;

    /**
     * 当前节点的出度 它指向别的点
     *
     */
    public int out;

    /**
     * 当前节点的直接邻居
     */
    public ArrayList<Node> nexts;

    /**
     * 当前节点它对应的边的集合
     */

    public ArrayList<Edge> edges;

    public static class Edge{
        /**
         * 边上的权重
         */
        public int weight;

        /**
         * 这条边 的头部指向
         */
        public Node from;

        /**
         * 这条边的 尾部指向
         */
        public Node to;

        public Edge(int weight, Node from, Node to){
            this.weight = weight;
            this.from = from;
            this.to = to;
        }


    }

    /**
     * 我的图整体节点  由节点与边组成
     *
     *
     */
    public static class Graph{
        public HashMap<Integer, Node> nodes;
        //防止边产生环 应该去重
        public HashSet<Edge> edges;
    }

    /**
     * 如何生成一张图
     *
     */
    public static class GraphGenerator{


    }
}
