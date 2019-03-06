package _洛谷.dfs;

import java.util.Scanner;

public class p_demo {
    public static int[][] arry;//棋盘，放皇后
    public static int map=0;//存储方案结果数量
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arry = new int[n][n];
        findQueen(0);
        System.out.println(map);
    }

    public static void findQueen(int i){//寻找皇后节点
        if(i>(n-1)){//有解
            map++;
            if(map<=3){
                print();  //打印N皇后的解
            }

            return;
        }

        for(int m=0;m<n;m++){//深度回溯,递归算法
            if(check(i,m)){//检查皇后摆放是否合适
                arry[i][m]=1;
                findQueen(i+1);
                arry[i][m]=0;//清零，以免回溯的时候出现脏数据
            }
        }
    }

    public static boolean check(int k,int j){//判断节点是否合适
        for(int i=0;i<n;i++){//检查行列冲突
            if(arry[i][j]==1){
                return false;
            }
        }
        for(int i=k-1,m=j-1; i>=0 && m>=0; i--,m--){//检查左对角线
            if(arry[i][m]==1){
                return false;
            }
        }
        for(int i=k-1,m=j+1; i>=0 && m<=(n-1); i--,m++){//检查右对角线
            if(arry[i][m]==1){
                return false;
            }
        }
        return true;
    }

    public static void print(){//打印结果
        for(int i=0;i<n;i++){
            for(int m=0;m<n;m++){
                    if(arry[i][m]==1){
                        System.out.print((m+1)+" ");
                    }
            }
        }
        System.out.println();
    }
}
