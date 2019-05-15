package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _自除数 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner()\

//        System.out.println(isNum(128));
        List<Integer>list = selfDividingNumbers(1,10000);
        System.out.println(list);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isNum(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isNum(int i) {
        int t = i;
        while (t != 0) {
            int x = (t % 10);
            if (x == 0) return false;
            if (i % x != 0) {
                return false;
            }
            t /= 10;
        }
        return true;
    }
}
