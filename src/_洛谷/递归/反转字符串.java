package _洛谷.递归;

public class 反转字符串 {
    public static void main(String[] args) {
        System.out.println(revse("kmpIs"));
    }

    public static String revse(String str) {
        if (str.length() == 1) {
            return str;
        }
        return str.charAt(str.length() - 1) + revse(str.substring(0, str.length() - 1));
    }
}
