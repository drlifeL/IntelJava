package _算法竞赛进阶指南.图_Graph;

import java.util.Scanner;

/**
 * 翰翰和达达饲养了N只小猫，这天，小猫们要去爬山。
 *
 * 经历了千辛万苦，小猫们终于爬上了山顶，但是疲倦的它们再也不想徒步走下山了（呜咕>_<）。
 *
 * 翰翰和达达只好花钱让它们坐索道下山。
 *
 * 索道上的缆车最大承重量为W，而N只小猫的重量分别是C1、C2……CN。
 *
 * 当然，每辆缆车上的小猫的重量之和不能超过W。
 *
 * 每租用一辆缆车，翰翰和达达就要付1美元，所以他们想知道，最少需要付多少美元才能把这N只小猫都运送下山？
 *
 * 输入格式
 * 第1行：包含两个用空格隔开的整数，N和W。
 *
 * 第2..N+1行：每行一个整数，其中第i+1行的整数表示第i只小猫的重量Ci。
 *
 * 输出格式
 * 输出一个整数，表示最少需要多少美元，也就是最少需要多少辆缆车。
 *
 * 数据范围
 * 1≤N≤18,
 * 1≤Ci≤W≤108
 * 输入样例：
 */
public class _小猫爬山 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int []catWeight = new int[N];
        for (int i = 0; i < N; i++) {
            catWeight[i] = sc.nextInt();
        }


    }
}
