package _笔试;

import java.util.ArrayList;
import java.util.List;


/**
 * ArrayList在构造时可以传递一个可迭代的迭代对象(Collection的子类)，他会把可迭代对象中的值按迭代器取出并复制给新的list
 *
 */
public class _ArrayList {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List list1 = new ArrayList(list);
        System.out.println(list1);
    }
}
