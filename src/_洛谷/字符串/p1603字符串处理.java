package _洛谷.字符串;


import java.util.Scanner;

public class p1603字符串处理 {
    static String [] arr = new String[]{"one", "two", "three", "four", "five",
                                    "six","seven","eight","nine","ten",
                                        "eleven","twelve","thirteen","fourteen","fifteen",
                                      "sixteen","seventeen","eighteen","nineteen","twenty"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();
        s = s.substring(0,s.length()-1);
        String []t = s.split(" ");
        String []ans = new String [6];
        int flag = 0;
        for (int i = 0; i <t.length ; i++) {
            int temp = check(t[i]);
            if(temp>0){
                temp = temp*temp %100;
                ans[flag++] = temp+"";
            }
        }
        s = sort(ans,flag);
        while(s.length()>1&&s.charAt(0)=='0'){
            s = s.substring(1);
        }
        System.out.println(s.equals("")?0:s);
    }

    private static String sort(String[] ans, int flag) {
        for (int i = 0; i <flag ; i++) {
            for (int j = 0; j <flag-i ; j++) {
                    if(Integer.parseInt(ans[i])<Integer.parseInt(ans[j])){
                        String temp = ans[i];
                        ans[i] = ans[j];
                        ans[j] = temp;
                    }
            }
        }
        String s = "";
        for (int i = 0; i <flag ; i++) {
            s+=ans[i];
        }
        return s;
    }

    private static int check(String s) {
        for (int i = 0; i <arr.length ; i++) {
            if(s.equals(arr[i])){
                return i+1;
            }
        }
        return -1;
    }
}
