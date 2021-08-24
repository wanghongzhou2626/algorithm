package basic.ten;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 我的图整体节点  由节点与边组成
 *
 *
 */
public class Graph {

    public HashMap<Integer, Node> nodes;
    //防止边产生环 应该去重
    public HashSet<Edge> edges;
}
