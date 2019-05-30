package leetCode;


import java.util.ArrayList;
import java.util.List;

public class _在每个树中找最大值 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        largestValues(root);
    }

    //先根节点，在左节点，最后右节点
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        System.out.println(list);
        return list;
    }

    public static int Max(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        if (root.left == null) return root.right.val;
        if (root.right == null) return root.left.val;
        return Math.max(root.left.val, root.right.val);
    }

    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (Max(root) != 0) {
            list.add(Max(root));
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }


}
