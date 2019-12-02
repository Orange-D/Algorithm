package com.orange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  2018/10/9.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中 都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并 返回
 * 思路：先找出根节点，然后利用递归方法构造二叉树
 *
 *   知识补充
 *      1
 *     / \
 *    2   3
 *   / \   \
 *  5   6   8
 *
 *  前序： 1 2 5 6 3 8  (中左右)
 *  中序： 5 2 6 1 3 8 （左中右）
 *  后序： 5 6 2 8 3 1  (左右中)
 */
public class Demo4 {

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        ArrayList<Integer> preArrlist = createData(pre);

        ArrayList<Integer> inorderArrList = createData(inorder);

        TreeNode treeNode = createTree(preArrlist, inorderArrList);

        printTree(treeNode);
    }

    public static void printTree(TreeNode treeNode) {
        System.out.println(treeNode.val);
        if (treeNode.leftNode != null)
            printTree(treeNode.leftNode);
        if (treeNode.rightNode != null) {
            printTree(treeNode.rightNode);
        }
    }

    public static TreeNode createTree(List<Integer> pre, List<Integer> inorder) {
        TreeNode parentNode = new TreeNode();
        parentNode.val = (int) pre.get(0);
        //根节点在中序序列所在的位置
        int midIndex = inorder.indexOf(pre.get(0));

        //midindex 大于等于1 表示右左子树
        if (midIndex >= 1) {
            //构建左子树
            List<Integer> leftChildPre = pre.subList(1, midIndex + 1);
            List<Integer> leftChildInorder = inorder.subList(0, midIndex);
            parentNode.leftNode = createTree(leftChildPre, leftChildInorder);
        }

        //midIndex 小于中序最大值表示有右子树
        if (midIndex < inorder.size() - 1) {
            //构建右子树
            List rightChildPre = null;
            List rightChildInorder = null;
            if (pre.size() - 1 > 0) {
                rightChildPre = pre.subList(midIndex + 1, pre.size());
                rightChildInorder = inorder.subList(midIndex + 1, pre.size());
            }
            parentNode.rightNode = createTree(rightChildPre, rightChildInorder);
        }
        return parentNode;
    }

    static class TreeNode {
        TreeNode leftNode;
        TreeNode rightNode;
        int val;
    }

    public static ArrayList<Integer> createData(int[] arr) {
        ArrayList<Integer> list = new ArrayList();
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }

}
