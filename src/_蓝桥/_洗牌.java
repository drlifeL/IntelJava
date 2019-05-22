package _蓝桥;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _洗牌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        while (sc.hasNext("\\d+")){
            String s= sc.nextLine();
            System.out.println(s);
            String [] a = s.split(" ");
            list.addAll(Arrays.asList(a));
            System.out.println(list);
        }
        System.out.println(list);
    }
}
