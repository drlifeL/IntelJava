package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _递增顺序查找树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
    }

    static List<Integer> list = new ArrayList<>();

    public static void print(TreeNode root) {
        if (root == null) return;
        print(root.left);
        list.add(root.val);
//        System.out.println(root.val);
        print(root.right);

    }

    /**
     * 该方法不正确.
     * @param root
     * @param head
     * @param curNode
     * @return
     */
    public static TreeNode BST(TreeNode root, TreeNode head, TreeNode curNode) {
        if (root == null) return null;
        BST(root.left, head, curNode);
        if (head == null) {
            head = new TreeNode(root.val);
            curNode = head;
        } else {
            curNode.right = new TreeNode(root.val);
            curNode = curNode.right;
        }
        BST(root.right, head, curNode);
        return head;
    }

    ;

    /**
     * 先对其进行中序遍历，在重新链接返回即可。但是比较浪费效率
     * 如果对递归的返回值在能理解一点，就可以直接一遍递归返回
     *
     * @param root
     * @return
     */
    public static TreeNode increasingBST(TreeNode root) {
        print(root);
        if (list.size() == 0) {
            return null;
        }
        TreeNode head = new TreeNode(list.get(0));
        TreeNode curNode = head;
        for (int i = 1; i < list.size(); i++) {
            curNode.right = new TreeNode(list.get(i));
            curNode = curNode.right;
        }
        return head;
    }
}
