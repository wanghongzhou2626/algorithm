package basic.eight;

/**
 * @author whz
 *
 * 如何判断一颗树是否为满二叉树    2^n - 1 = nodes   n是层数
 */
public class Review_IsFull {

    public static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static boolean isFull(Node head){
        if(head == null){
            return false;
        }

        Info info = process(head);
        return (1 << info.height) - 1 == info.nodes;

    }

    private static Info process(Node head) {
        if(head == null){
            return new Info(0,0);
        }

        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height,nodes);


    }

    public static class Info{
        //树的高度
        int height;
        //树的节点数量
        int nodes;

        public Info(int height, int nodes){
            this.height = height;
            this.nodes = nodes;
        }
    }
}
