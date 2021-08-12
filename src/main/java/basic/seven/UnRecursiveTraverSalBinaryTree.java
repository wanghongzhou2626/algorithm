package basic.seven;


import java.util.Stack;

/**
 * @author whz
 * 二叉树的 先序 中序 后序 的三种遍历方式的迭代版本
 */
public class UnRecursiveTraverSalBinaryTree {


    public static class Node{

        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 迭代版本先序遍历
     * 1.头节点不为空放入栈中
     * 2.弹出打印  如果右节点不为空压入栈中 如果左节点不为空 压入栈中
     * @param head
     */
    public static void pre(Node head){

        if(head == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        //头节点压入栈中
        stack.push(head);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.value);
            //因为先序遍历 是 头左右  栈是先进后出 先压入右 后面先出来的就是左
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }


    /**
     * 迭代版本后续遍历   其实就是把压栈变成先压左在压右   这样出来的顺序就是 头 右 左  然后弹出的时候不进行打印 把他存储在栈中 最后依次弹栈
     * 得到的就是后续遍历的结果。只不过这样需要额外的一个栈空间
     *
     * 是否右不用栈的额外空间对应来实现
     */
    public static void pos(Node head){

        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            Stack<Node> res = new Stack<Node>();
            stack.push(head);
            while(!stack.isEmpty()){
                Node cur = stack.pop();
                res.push(cur);
                if(cur.left != null) {
                    stack.push(cur.left);
                }
                if(cur.right != null){
                    stack.push(cur.right);
                }
            }
        }
    }

    /**
     * 二叉树中序遍历 迭代版本
     * 1.二叉树的中序遍历 是左头右 所以栈首先应该沿着谋棵子树的左节点一直压住栈中 直到为空后在指向他的右 他的右继续沿着左数一直到底
     *
     */

    public static void in(Node cur){

        if(cur != null){
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || cur != null){
                //如果当前节点不为空我就一直把当前节点的左子树一直压入栈中
                if(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }else {
                    //表示当前节点为空了 这时我应该在栈中弹出一个 这个就是最后压入的那个不为空的左节点
                    cur = stack.pop();
                    System.out.println(cur.value);
                    //然后我在看他的右节点 然后右节点继续这个操作 往左侧继续怼
                    cur = cur.right;
                }
            }
        }
    }


}
