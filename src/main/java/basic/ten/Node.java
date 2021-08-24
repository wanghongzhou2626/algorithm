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

    public Node(int value){
        this.value = value;
    }







}
