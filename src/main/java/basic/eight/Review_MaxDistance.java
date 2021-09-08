package basic.eight;

/**
 * @author whz
 *
 * 给定一颗二叉树的头节点head，任何两个节点之间都存在距离 返回整课二叉树的最大距离
 *
 * 使用套路进行分析 已x节点为例
 * 当最大距离与x有关 啥意思 就是经过x 那就是x左树最远的点 到x右树最远的点
 * 我需要啥 左树的最大距离 右树的最大距离  左树 右树的高度 才能知道距离
 * 当最大距离与x无关 最大距离出现在左树 或者 右树上 我要的还是最大距离 *
 *
 */
public class Review_MaxDistance {


    public static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
        }

    }


    public static class Info{
        int height;
        int maxDistance;

        public Info(int height,int maxDistance){
            this.height = height;
            this.maxDistance = maxDistance;
        }


    }

    public static int maxDistance(Node head){

        return process(head).maxDistance;
    }

    private static Info process(Node head) {
        if(head == null){
            return new Info(0,0);
        }

        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int height = Math.max(leftInfo.height,rightInfo.height) + 1;

        //最大距离 分x有关无关 有关时是 左树最大高度 加  右树最大高度 + 1
        // 无关 左树最大距离 右树最大距离 他们三个取最大的那个  就是二叉树head见的最大
        int maxDistance = Math.max(leftInfo.height + rightInfo.height + 1 ,
                Math.max(leftInfo.maxDistance,rightInfo.maxDistance));

        return new Info(height,maxDistance);
    }


}
