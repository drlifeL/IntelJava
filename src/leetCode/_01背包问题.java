package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class _01背包问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        Bag[] bags = new Bag[n];
        for (int i = 0; i < n; i++) {
            int vi = sc.nextInt();
            int wi = sc.nextInt();
            bags[i] = new Bag(vi, wi);
        }
        Arrays.sort(bags);
        for (int i = 0; i < bags.length; i++) {
            System.out.println(bags[i].v + "::" + bags[i].w);
        }

    }

    private static class Bag implements Comparable<Bag> {
        int v;//体积
        int w;//价值

        public Bag(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Bag other) {//错误代码
            int there = (this.v - this.w)-(other.v - other.w);
            return there==0?other.v-this.v:there;
        }
    }
}
