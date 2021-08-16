package basic.eight;

/**
 * @author whz
 *
 * 在一棵二叉树中 给定头节点 寻找出节点间的最大距离
 *
 */
public class MaxDistance {

    /**
     * 树形dp 二叉树的递归套路
     * *     1.假设以x为头节点，假设可以向x左树和x右树要任何信息
     * *     2.在上一步的假设下，讨论以x为头节点的树，得到答案的可能性（最重要），通常情况考虑与x有关的情况 与x无关的情况
     * *     3.列出所有可能性后，确定到底需要向左树和右树要什么的信息
     * *     4.把左树信息和右树信息求全集，就是任何一颗子树都需要返回的信息s
     * *     5.递归函数都返回s 每一颗子树都这么要求
     * *     6.写代码，在代码中考虑如何把左数的信息和右树的信息整合出整棵树的信息
     */

    //这道题 很容易想到的是  是否与x有关  说白了就是你的最长路径是否经过 x
}
