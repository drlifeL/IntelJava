package leetCode;
import java.util.ArrayList;
import java.util.List;
public class _路径总和2 {
    static List<List<Integer>> list1 = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        //这里即使导包的方法也不能解决，因为该类是一个静态类
        _二叉树的所有路径.TreeNode root = new _二叉树的所有路径.TreeNode(5);
        root.left = new _二叉树的所有路径.TreeNode(4);
        root.left.left = new _二叉树的所有路径.TreeNode(11);
        root.left.left.left = new _二叉树的所有路径.TreeNode(7);
        root.left.left.right = new _二叉树的所有路径.TreeNode(2);
        root.right = new _二叉树的所有路径.TreeNode(8);
        root.right.left = new _二叉树的所有路径.TreeNode(13);
        root.right.right = new _二叉树的所有路径.TreeNode(4);
        root.right.right.left = new _二叉树的所有路径.TreeNode(5);
        root.right.right.right = new _二叉树的所有路径.TreeNode(1);
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
}
