package _洛谷.字符串;

import java.util.Scanner;

public class P1914小书童 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            char temp  = s.charAt(i);
            if(temp+n>'z'){
                temp+=n;
                while(temp>'z'){
                    temp = (char)(96+(temp-'z'));
                }
                System.out.print(temp);
            }else{
                System.out.print((char)(temp+n));
            }
        }
    }
}
