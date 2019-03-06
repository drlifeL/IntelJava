package _蓝桥._2014;

import java.util.Scanner;

/**
 问题描写叙述
 　　兰顿蚂蚁。是于1986年，由克里斯·兰顿提出来的，属于细胞自己主动机的一种。
 　　平面上的正方形格子被填上黑色或白色。在当中一格正方形内有一仅仅“蚂蚁”。
 　　蚂蚁的头部朝向为：上下左右当中一方。
 　　蚂蚁的移动规则十分简单：
 　　若蚂蚁在黑格，右转90度，将该格改为白格。并向前移一格；
 　　若蚂蚁在白格，左转90度。将该格改为黑格，并向前移一格。
 　　规则尽管简单。蚂蚁的行为却十分复杂。
 刚刚開始时留下的路线都会有接近对称，像是会反复。但不论起始状态怎样。蚂蚁经过漫长的混乱活动后，会开辟出一条规则的“快速公路”。
 　　蚂蚁的路线是非常难事先预測的。
 　　你的任务是依据初始状态，用计算机模拟兰顿蚂蚁在第n步行走后所处的位置。
 输入格式
 　　输入数据的第一行是 m n 两个整数（3 < m, n < 100）。表示正方形格子的行数和列数。
 　　接下来是 m 行数据。
 　　每行数据为 n 个被空格分开的数字。
     0 表示白格。1 表示黑格。
 　　接下来是一行数据：x y s k, 当中x y为整数，表示蚂蚁所在行号和列号（行号从上到下增长，列号从左到右增长，都是从0開始编号）。
     s 是一个大写字母，表示蚂蚁头的朝向，我们约定：上下左右分别用：UDLR表示。k 表示蚂蚁走的步数。
 输出格式
 　　输出数据为两个空格分开的整数 p q, 分别表示蚂蚁在k步后。所处格子的行号和列号。
 例子输入
     5 6
     0 0 0 0 0 0
     0 0 0 0 0 0
     0 0 1 0 0 0
     0 0 0 0 0 0
     0 0 0 0 0 0
     2 3 L 5
 例子输出
    1 3
 例子输入
     3 3
     0 0 0
     1 1 1
     1 1 1
     1 1 U 6
 例子输出
    0 0
 */
public class _8兰顿蚂蚁 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] g = new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        // 0 表示白格。1 表示黑格。黑格子右转 白格子左转
        int x = sc.nextInt();
        int y = sc.nextInt();
        String s = sc.next();
        int f = getD(s);
        int k = sc.nextInt();//蚂蚁走的步数
        int step = 0;//实际挪动步数
        //上下左右分别用：UDLR表示
        while(true) {
            if (g[x][y] == 1) {
                f = f % 4 + 1;
                g[x][y] = 0;
            } else {
                f--;
                if (f == 0) f = 4;
                g[x][y] = 1;
            }
            //前进一步
            if (f == 1) x--;
            if (f == 2) y++;
            if (f == 3) x++;
            if (f == 4) y--;

            step++;
            if(step==k){
                System.out.println(x+" "+y);
                break;
            }
        }
    }

    private static int getD(String s) {
        if(s.equals("U")) return 1;
        if(s.equals("R")) return 2;
        if(s.equals("D")) return 3;
        if(s.equals("L")) return 4;
        return 0;
    }
}
