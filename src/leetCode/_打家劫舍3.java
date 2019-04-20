package leetCode;

/*
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
该题类似于树的前序遍历，然后在其中添加状态
无法找到结束条件，很伤、思路不过明显
 */
public class _打家劫舍3 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(5);
        dfs(node,0,1,"");
        System.out.println("---------------");
        dfs(node,0,0,"");
    }

    public static int rob(TreeNode root) {

        return 0;
    }

    public static void dfs(TreeNode root, int num, int state,String path) {
        if (root == null){
            System.out.println(num+"::"+path);
            return ;
        }
        if(state==1){//只要我的上一个节点被选中了，那么我的下两个节点就必然不能选
            dfs(root.left,num,0,path);
            dfs(root.right,num,0,path);
        }
        if(state==0){
            dfs(root.left,num,0,path);//可以连续几次不选
            dfs(root.right,num,0,path);
            dfs(root.left,num+ root.val,1,path+root.val+"-》");
            dfs(root.right,num+ root.val,1,path+root.val+"-》");
        }

}
}
