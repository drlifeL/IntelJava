package leetCode;

public class _验证回文串 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
        test("0P");
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            while (i <= j && !(s.charAt(i) >= 65 && s.charAt(i) <= 90 || s.charAt(i) >= 97 && s.charAt(i) <= 122)) {
                i++;
            }
            while (j >= i && !(s.charAt(j) >= 65 && s.charAt(j) <= 90 || s.charAt(j) >= 97 && s.charAt(j) <= 122)) {
                j--;
            }
            if ((arr[i] + "").equalsIgnoreCase((arr[j] + ""))) {
                i++;
                j--;
            } else {
                return false;
            }

        }
        return true;
    }

    public static void test(String s) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                System.out.println(new Integer(s.charAt(i)));
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        System.out.println(s);
        System.out.println(sb.reverse().toString().equalsIgnoreCase(s));

//        System.out.println();
    }

}
