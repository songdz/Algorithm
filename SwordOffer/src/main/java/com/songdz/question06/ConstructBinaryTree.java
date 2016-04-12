package com.songdz.question06;

import org.junit.Test;

/**
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并输出它的后序遍历序列。
 *
 * 思路：前序的第一个元素是二叉树的根元素，该元素在中序中的位置的左边是左子树，右边是右子树；
 * 通过中序得到左右子树各自的元素个数，在前序中截取后进行递归计算。
 *
 * Created by SongDz on 2016/3/21.
 *
 * @author SongDz
 */
public class ConstructBinaryTree {

    private class TreeNode<T> {

        T data;

        TreeNode<T> left;
        TreeNode<T> right;

    }

    public TreeNode constructBinaryTree(int[] pre, int[] mid, int pre_start, int pre_end, int mid_start, int mid_end) {

        if (pre_start > pre_end || mid_start > mid_end) return null;

        int mid_pre = mid_start;
        while (mid_pre <= mid_end) {
            if (mid[mid_pre] == pre[pre_start]) {
                break;
            } else {
                mid_pre++;
            }
        }
        if (mid_pre > mid_end) {
            throw new RuntimeException("输入的前序和中序有误！！！");
        }

        TreeNode<Integer> root = new TreeNode<Integer>();
        root.data = pre[pre_start];

        int length = mid_pre - mid_start;

        root.left = constructBinaryTree(pre, mid, pre_start + 1, pre_start + length, mid_start, mid_pre - 1);
        root.right = constructBinaryTree(pre, mid, pre_start + length + 1, pre_end, mid_pre + 1, mid_end);

        System.out.println(root.data);


        return root;

    }

    public void printBinaryTreeLastOrder(TreeNode root) {

        if (root == null) return;

        if (root.left != null) printBinaryTreeLastOrder(root.left);
        if (root.right != null) printBinaryTreeLastOrder(root.right);
        System.out.printf(root.data + " ");


    }

    @Test
    public void testConstructBinaryTree() {
        int pre[] = {1,2,4,7,3,5,6,8};
        int mid[] = {4,7,2,1,5,3,8,6};
        TreeNode<Integer> root = constructBinaryTree(pre, mid, 0, pre.length - 1, 0, mid.length - 1);
        //printBinaryTreeLastOrder(root);
    }




}
