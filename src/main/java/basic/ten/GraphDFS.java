package basic.ten;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author whz
 *
 * 图的深度优先遍历
 * 栈的作用 记录某条路径的记录一直到底
 * set作用记录走过的路 防止重复走
 */
public class GraphDFS {

    /**
     * 给定一个图的节点  深度优先遍历图算法
     * @param node
     */
    public static void dfs(Node node){
        if(node == null){
            return;
        }
        Stack<Node> nodeStack = new Stack<Node>();
        HashSet<Node> set = new HashSet<Node>();
        //第一个节点两个容器都进入
        nodeStack.add(node);
        set.add(node);
        //打印
        System.out.println(node.value);
        while (!nodeStack.isEmpty()){
            Node cur = nodeStack.pop();
            for (Node next: cur.nexts) {
                if(!set.contains(next)){
                    nodeStack.push(cur);
                    nodeStack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
