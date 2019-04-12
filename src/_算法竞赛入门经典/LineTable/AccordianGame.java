package _算法竞赛入门经典.LineTable;

import java.util.*;

/**
 * uvG 127 手风琴游戏
 */
public class AccordianGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        while (true) {
            String s = sc.nextLine();
            if (s.equals("#")) {
                break;
            }
            list.add(s);
        }
        //第一个字符是点数：（A、 2-9、T=10、J、Q, K）；第二个字符是花色：（C=梅花、D=方块、H=红心、S=黑桃）。
        int k = 0;
        for (int i = 0; i < list.size(); i += 2) {
            String[] arr = list.get(i).split(" ");
            String[] arr2 = list.get(i + 1).split(" ");
            String[] final_arr = merge(arr, arr2);
            jujde(final_arr);
        }


    }

    private static void jujde(String[] final_arr) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 1; i < final_arr.length; i++) {

        }


    }

    private static String[] merge(String[] arr, String[] arr2) {
        int totalLen = arr.length + arr2.length;
        String[] final_arr = new String[totalLen];
        for (int i = 0; i < arr.length; i++) {
            final_arr[i] = arr[i];
        }
        for (int i = arr.length; i < totalLen; i++) {
            final_arr[i] = arr2[i - arr.length];
        }
        return final_arr;
    }

}
