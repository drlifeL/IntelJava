package _算法竞赛入门经典;

import java.util.Arrays;
import java.util.Scanner;

public class _字母重排 {
    public static void main(String[] args) {
        String [] dir = new String[50];
        String [] dz ;
        Scanner sc = new Scanner(System.in);
        int x = 0;
        while(true){
            String s = sc.next();
            if(!s.equals("******")){
                dir[x++] = s;
            }else{
                sc.nextLine();
                String s1 = sc.nextLine();
                dz = s1.split(" ");
                break;
            }
        }
        sort(dir,x);
        find(dir,x,dz);
    }

    private static void find(String d[],int len,String z[]) {
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < len; j++) {
                if(sSort(z[i]).equals(sSort(d[j]))){
                    System.out.println(d[j]);
                }
            }
        }
    }

    private static void sort(String[] dir,int len) {
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if(dir[i].compareTo(dir[j])>0){
                    String t = dir[i];
                    dir[i] = dir[j];
                    dir[j] = t;
                }
            }
        }
    }

    private static String sSort(String s) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
