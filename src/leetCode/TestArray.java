package leetCode;


import java.util.ArrayList;
import java.util.List;

public class TestArray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2, 3);
        System.out.println(list);

        KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println( k.add(3));   // returns 4
        System.out.println( k.add(5));   // returns 5
        System.out.println(k.add(10));  // returns 5
        System.out.println( k.add(9));   // returns 8
        System.out.println(k.add(4));   // returns 8
    }
}
