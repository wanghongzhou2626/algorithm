package basic.ten;

/**
 * @author whz
 */
public class Edge {

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
