package _算法竞赛入门经典;

import java.util.Scanner;

public class _3NAdd1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int count = 0;
        for (; n !=1 ; ) {
            if(n%2==0){
                n/=2;
            }else{
                n = 3*n+1;
            }
            count++;
        }
        System.out.println(count);
    }

}
