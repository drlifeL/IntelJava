package leetCode;

public class _验证二叉搜索树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    static boolean flag = true;
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(20);
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(10);
        root.right.left.right = new TreeNode(15);
        root.right.left.right.right = new TreeNode(45);


//        System.out.println( dfs(root.left,root.val,1,root.val,1) && dfs(root.right,root.val,2,root.val,2));
        System.out.println(isSearchTree(root));
    }

    /**
     * 实际上一个正确的二叉搜索树，如果按照中序遍历，他一定是返回一个升序的数组，我们就可以根据这个特征来判断该树是不是二叉搜索树
     *
     * @param root
     * @return
     */
    public static boolean isSearchTree(TreeNode root){
        if(root == null) return true;
        if(root.left!=null && root.right!=null){
            return dfs(root.left,root.val,1,root.val,1) && dfs(root.right,root.val,2,root.val,2);
        }else if(root.left==null){
            return dfs(root.right,root.val,2,root.val,2);
        }else if(root.right ==null){
            return dfs(root.left,root.val,1,root.val,1);
        }
        return true;
    }


    public static boolean dfs(TreeNode root,int lastVal,int state,int rootVal,int startState){
        if(root==null){
            return true;
        }

        if(state==1 && root.val >=lastVal ){
            return false;
        }
        if(state==2 && root.val <=lastVal){
            return false;
        }
        if(startState==1 && root.val >=rootVal){
            return false;
        }
        if(startState==2 && root.val <=rootVal){
            return false;
        }
        lastVal = root.val;

        return dfs(root.left,lastVal,1,rootVal,startState) && dfs(root.right,lastVal,2,rootVal,startState);
    }
}
