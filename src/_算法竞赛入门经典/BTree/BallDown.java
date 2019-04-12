package _算法竞赛入门经典.BTree;

import java.util.Scanner;

/**
 *  二叉树 深度为D 所有叶子深度相同 所有结点从上到下从左到右编号1-2的d次方-1 在结点1
 *  放一个小球，他会下落，每个结点上都有一个开关（初始全部关闭），每次有小球落在开关上时，状态会改变，
 *  开关关闭则左走，否则往右走，直到走到叶子结点
 *  从1开始下落，最后一个小球将会落在哪里 输入叶子深度D 和小球个数I  输出第
 *  I个小球最后所在的叶子编号 。I不超过整棵树的叶子个数 D<=20
 *
 */
public class BallDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int I = sc.nextInt();
        boolean []arr = new boolean[1<<D];//位运算

        for (int i = 0; i < I; i++) {
            int j = 1;
            while(j<arr.length/2){
                if(!arr[j]){
                    arr[j] = !arr[j];
                    j = 2*j;
                }else{
                    arr[j] = !arr[j];
                    j = 2*j+1;
                }
            }
            if(i+1==I){
                System.out.println(j);
            }
        }

    }
}
