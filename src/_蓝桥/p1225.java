package _蓝桥;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p1225 {
    static int ans;
    static int k;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = n;
        f(n,arr);
        System.out.println(ans);
    }

    private static void f(int n,ArrayList arr) {
        if(n==0){
            ans+=1;
            System.out.println(Arrays.toString(arr.toArray()));
            return ;
        }
        if(n<0){
            return ;
        }
        arr.add(k-n);
        f(n-1,arr);
        f(n-2,arr);
    }
}
