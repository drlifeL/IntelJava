package _洛谷.字符串;

import java.util.Scanner;

public class p1553数字反转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.contains("%")){//如果是百分数
            StringBuffer sb = new StringBuffer(s.substring(0,s.length()-1));
            sb.reverse();
            s = sb.toString();
            while (s.charAt(0)=='0' && s.length()>1){
               s = s.substring(1);
            }
            System.out.println(s+"%");
            return;
        }else if(s.contains(".")){//如果是小数
            StringBuffer s1 = new StringBuffer(s.substring(0,s.indexOf('.')));
            s1.reverse();
            String temp = s1.toString();
            while (temp.charAt(0)=='0' && temp.length()>1){
             temp =  temp.substring(1);
            }
            temp+='.';
            s1 = new StringBuffer(s.substring(s.indexOf('.')+1));
            s1.reverse();
            s =s1.toString();
            while(s.charAt(s.length()-1)=='0' && s.length()>1){
                s = s.substring(0,s.length()-1);
            }
            System.out.println(temp+s);
            return;
        }else if(s.contains("/")){
            StringBuffer sb = new StringBuffer(s.substring(0,s.indexOf('/')));
            sb.reverse();
            String temp = sb.toString();
            while(temp.charAt(0)=='0' && temp.length()>1){
                temp = temp.substring(1);
            }
            temp+='/';
            sb = new StringBuffer(s.substring(s.indexOf('/')+1));
            sb.reverse();
            s = sb.toString();
            while(s.charAt(0)=='0'){
                s = s.substring(1);
            }
            System.out.println(temp+s);
            return;
        }else{
            StringBuffer sb = new StringBuffer(s);
            sb.reverse();
            s = sb.toString();
            while(s.charAt(0)=='0' && s.length()>1){
                s = s.substring(1);
            }
            System.out.println(s);
        }
    }
}
