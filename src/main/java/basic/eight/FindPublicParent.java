package basic.eight;

/**
 * @author whz
 *
 * 在一棵二叉树中 给定头节点 再额外给定两个节点  寻找这两个节点的最近公共父节点  公共祖先
 *
 * o1 o2 都在不x上
 * o1 o2 有一个在x上
 * o1 o2 都在  只有这种情况下以x为头才会产生公共祖先
 *
 *       左右各一个   左 两个  右 两个  x自己是o1 o2 x是o1 在左或右收集 o2  x是o2 在左或右收集o1
 *       每颗子树的info得信息 找到的node  01有没有被发现 02有没有被发现
 *
 */
public class FindPublicParent {
}
