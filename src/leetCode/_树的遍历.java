package leetCode;

public class _树的遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        frontSerach(root);

        System.out.println("<------------------------>");

        middleSerach(root);

        System.out.println("<------------------------>");

        lastSerach(root);
    }

    /**
     * 中序遍历
     * 按照左、根、右遍历
     *
     * @param root
     */
    public static void middleSerach(TreeNode root) {
        if (root == null) return;
        middleSerach(root.left);
        System.out.print(root.val + "  ");
        middleSerach(root.right);
    }

    /**
     * 前序遍历
     * 按照 根、左、右遍历
     *
     * @param root
     */
    public static void frontSerach(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + "  ");
        frontSerach(root.left);
        frontSerach(root.right);
    }

    /**
     * 后序遍历
     *  按照左、右、根遍历
     * @param root
     */
    public static void lastSerach(TreeNode root) {
        if (root == null) return;
        frontSerach(root.left);
        frontSerach(root.right);
        System.out.print(root.val + "  ");
    }

}
