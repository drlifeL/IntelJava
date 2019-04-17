package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _二叉树的所有路径 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);


//
//        dfs(root, "");
//
//        System.out.println(list);
        System.out.println(pathSum(root, 22));
    }

    static List<List<Integer>> list1 = new ArrayList<List<Integer>>();

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        dfs(root, sum, new ArrayList<Integer>(), 0);
        return list1;
    }

    public static void dfs(TreeNode root, int sum, List<Integer> zz, int curSum) {
        curSum += root.val;
        zz.add(root.val);
        if (curSum > sum) return;
        if (root.left == null && root.right == null && curSum == sum) {
            list1.add(zz);
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum, zz, curSum);
        }
        if (root.right != null) {
            dfs(root.right, sum, zz, curSum);
        }

    }


    public static void dfs(TreeNode root, String path) {
        if (root.left == null && root.right == null) {//已经到达根节点
            list.add(path + root.val);
            return;
        }
        path += root.val + "->";

        if (root.left != null) {
            dfs(root.left, path);
        }

        if (root.right != null) {
            dfs(root.right, path);
        }

    }

}
