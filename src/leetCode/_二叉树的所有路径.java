package leetCode;

import java.util.ArrayList;
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
    static List<List<Integer>> list1 = new ArrayList<List<Integer>>();
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



        dfs(root, "");
        System.out.println(list);
        System.out.println(pathSum(root, 22));

    }




    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        dfs(root, sum, new ArrayList<Integer>(), 0);
        return list1;
    }

    public static void dfs(TreeNode root, int sum, String path, int curSum) {

        /*
        自己写的代码，太多没有必要的操作了
         */

        if (root.left == null && root.right == null && curSum + root.val == sum) {
            path += root.val;
            List<Integer> ans = new ArrayList<>();
            String[] t = path.split(",");
            for (int i = 0; i < t.length; i++) {
                ans.add(Integer.parseInt(t[i]));
            }
            list1.add(ans);
            return;
        }
        path += root.val + ",";
        curSum += root.val;
        if (curSum > sum) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum, path, curSum);
        }
        if (root.right != null) {
            dfs(root.right, sum, path, curSum);
        }
    }

    public static void dfs(_二叉树的所有路径.TreeNode root, int sum, List<Integer> curList, int curSum) {
        if(root==null){
            return;
        }

        curSum+=root.val;

        curList.add(root.val);

        if(curSum==sum && root.left==null && root.right==null){
            list1.add(curList);
        }
        dfs(root.left,sum,new ArrayList<>(curList),curSum);//必须创建一个新的对象传递过去

        dfs(root.right,sum,new ArrayList<>(curList),curSum);
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
