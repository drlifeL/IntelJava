package leetCode;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _在每个树行中找最大值 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        largestValues(root);
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root!=null)//根节点不为空的情况下在进行遍历
            bfs(root, list);
        return list;
    }

    public static void bfs(TreeNode root, List<Integer> list) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode curPNode = root;
        q.add(root);
        int curNodeNum = 1;//当前层节点的数量
        int nextNodeNum = 0;//下一层节点的数量
        int curMaxValue = Integer.MIN_VALUE;//当前层的最大值

        while (!q.isEmpty()) {
            TreeNode t = q.poll();//出队
            curNodeNum--;//当前节点递减
            curMaxValue = t.val > curMaxValue ? t.val : curMaxValue;//判断最大值
            if (t.left != null) {
                q.add(t.left);
                nextNodeNum++;
            }
            if (t.right != null) {
                q.add(t.right);
                nextNodeNum++;
            }
            if (curNodeNum == 0) {//当前层的所有节点都已经被遍历过了
                curNodeNum = nextNodeNum;
                nextNodeNum = 0;
                list.add(curMaxValue);
                curMaxValue = Integer.MIN_VALUE;
            }
        }
    }


}
