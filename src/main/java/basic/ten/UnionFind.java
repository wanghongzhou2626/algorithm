package basic.ten;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author whz
 * 并查集  啥是并查集  给你一大堆元素 可能是原始类型 也可能是引用类型  把他封装一下 每个元素有一个指向自己的引用
 * 每个元素单独成为一个集合
 * 并查集 有两个操作
 * isSameSet  两个集合是否相同
 * union 合并操作 如果两个集合不相同 如果是引用类型就是引用不同 那么就将他们合并成一个大集合 合并规则是小的集合直接挂到大集合上
 * <p>
 * 如何实现
 */
public class UnionFind {

    /**
     * 并查集的 元素 本身是个引用类型
     * v 表示他装的东西的类型  上边说有一个指向自己的引用 为啥在这里没体现呢？ 看后续代码实现规则
     */

    public static class Node<V> {

        V value;

        public Node(V v) {
            this.value = v;
        }

    }

    public static class UnionFindOperation<V> {

        /*nodes 这个map代表的是 我真正要存储的v是key 它对应的value 是我包装以后的node<v> */
        public HashMap<V, Node<V>> nodes;
        /*记录包装后的节点他向上指的parents  这就是为什么不需要向上指的引用了 这个map表中都已经进行了记录 */
        public HashMap<Node<V>, Node<V>> parents;
        /* 代表节点 他连接的 nodes 数量*/
        public HashMap<Node<V>, Integer> sizeMap;


        public UnionFindOperation(List<V> values) {
            nodes = new HashMap<V, Node<V>>();
            parents = new HashMap<Node<V>, Node<V>>();
            sizeMap = new HashMap<Node<V>, Integer>();

            for (V cur : values) {
                Node<V> node = new Node<V>(cur);
                nodes.put(cur, node);
                //初始化 是他自己指向自己
                parents.put(node, node);

                sizeMap.put(node, 1);

            }

        }

        /**
         *  如何判断两个节点集合是否相等
         *  从当前节点 往上找他的parent 直到找到自己了  然后 如果两个东西相等  那么就定义为这两个集合 是相等的
         *  说白了最终的代表点相同 就认为两个集合相同
         *
         */

        public boolean isSameSet(V a, V b){
            //先找到 a b 的代表点
            Node<V> aNode = nodes.get(a);
            Node<V> bNode = nodes.get(b);

            //这两个点向上找父 如果父指向代表点相同 表示两个集合相同 否则不同

            return findFather(aNode) == findFather(bNode);

        }

        private Node<V> findFather(Node<V> cur) {

            Stack<Node<V>> path = new Stack<Node<V>>();

            //怎么根据 cur 找父
            //说明还有父 不是自己指自己
            while(cur != parents.get(cur)){
                //还有父我就继续让他找
                path.push(cur);
                cur = parents.get(cur);
            };

            //现在还要做一件什么事情呢 某个节点向上找他的父的过程的链路 进行压缩  路径上的节点全部挂到父上
            //方便下次寻找的更快 所以说并查集的事件复杂度可以变成O(1)
            //我是不是得先记录下 我这个路径上的value  得有个容器 栈吧  什么时候存呢  在我找我的父的时候呢
            while (! path.isEmpty()){
                //路径上的节点 都变成一个父 进行路径压缩
                parents.put(path.pop(),cur);
            }
            //你找到的父
            return cur;

        }


        /**
         *  如何合并两个集合呢？
         *  首先什么样的需要 union呢 两个不一样的需要和  和的规则 小集合挂在大集合上
         *
         */

        public void union(V a, V b){

            //先看他俩集合是不是一个东西 只有不是需要和
            Node<V> aFather = findFather(nodes.get(a));
            Node<V> bFather = findFather(nodes.get(b));

            if(aFather != bFather){
                //先看这两个集合他们的nodes数量
                Integer aSize = sizeMap.get(aFather);
                Integer bSize = sizeMap.get(bFather);
                if(aSize > bSize){
                    /**
                     * b 挂在 a上
                     * 1，parent b的parent变成a
                     * 2. a的size 数量 变成 a+b
                     * 3. 把b删掉
                     */
                    parents.put(bFather,aFather);
                    sizeMap.put(aFather,aSize + bSize);
                    sizeMap.remove(bFather);
                } else {
                  // a 挂 b
                    parents.put(aFather,bFather);
                    sizeMap.put(bFather,aSize + bSize);
                    sizeMap.remove(aFather);
                }

            }

        }

    }


}
