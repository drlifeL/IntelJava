package _算法竞赛入门经典;

import java.util.Scanner;

/**
 * 韩信点兵，只让士兵3人一排、5人一排、七人一排的变化队形
 * 每次只掠一眼队伍的排尾就知道总人数  直接思路：枚举  数据量小  10>= x <=100
 *  a<3 b<5 c<7
 */
public class _韩信点兵 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        for (int i = 10; i <=100; i++) {
            if(i%3==a && i%5==b && i%7==c){
                System.out.println(i);
                return;
            }
        }
        System.out.println("No answer");

    }
}
