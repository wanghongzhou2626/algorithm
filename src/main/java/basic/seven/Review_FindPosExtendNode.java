package basic.seven;

/**
 * 寻找一个节点的后继 节点  首先是中序遍历的结果 对应后继
 * 要求直接找 而不是先中序遍历后在找
 */
public class Review_FindPosExtendNode {

    public static class Node{
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int value){
            this.value = value;
        }

    }


    public static Node findNode(Node node){
        if(node == null){
            return null;
        }
        //有右树 那么后继节点在右树的最左节点上
        if(node.right != null){
            return leftNode(node.right);
        }else {
            //没有右树
            //找到他的父
            Node parent = node.parent;
            //我的父不为空 并且我不是我父的左孩子
            while(parent != null && parent.left != node){
                //父做当前节点
                node = parent;
                //父的父 下一次的parent
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node leftNode(Node right) {
        if(right.left == null){
            return right;
        }
        while (right.left != null){
            right = right.left;
        }
        return right;
    }


}
