package _算法竞赛进阶指南.图_Graph;

import java.util.Scanner;

public class _random {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =127;
        String s = "";
        for (int i = 0; i < n/2; i++) {
            s+=(int)(Math.random()*(Math.random()*100))+" ";
        }
        for (int i = 0; i < n/2+1; i++) {
            s+=(int)(Math.random()*(Math.random()*100))+" ";
        }
        System.out.println(s);
    }
}
