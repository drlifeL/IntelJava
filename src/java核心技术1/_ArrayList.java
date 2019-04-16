package java核心技术1;

import java.util.ArrayList;

public class _ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//        list.ensureCapacity(10000000);//ArrayListy一开始就创建100个空间，不用扩容空间。
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        Long endTime = System.currentTimeMillis()-startTime;
        System.out.println(endTime);
        System.out.println("------------------");
        ArrayList<Integer> list2 = new ArrayList<>();//通过默认的加载因子和扩容函数对数据进行数组进行动态扩展
        /*
            假设第一次开辟1000个空间，当这1000个空间存储满了时，ArrayList会根据加载因子，在创建一个更大的新的数组了，把以前的值拷贝进去。速度上要比提前开辟空间的办法要慢一点
            如果数量级达到1000W，提前开辟空间的速度是利用加载因子和函数的两倍 3672ms  ---  6375ms
            如果这个时候内存的空间已经固定，就可以使用trimToSize()方法，垃圾回收器就会回收多余的空间，
            上诉是错误言论
            现在存在新问题：
                都是1000W数量级别的ArrayList插入数据
                但是后一个的速度要快于前一个  中间快，两边慢
         */
        startTime = System.currentTimeMillis();
        for (int i = 40000000; i !=50000000 ; i++) {
            list2.add(i);
        }
        endTime = System.currentTimeMillis()-startTime;
        System.out.println(endTime);
        System.out.println("-------------");
        ArrayList<Integer> list3 = new ArrayList<>();
        startTime = System.currentTimeMillis();
        for (int i = 20000000; i !=30000000 ; i++) {
            list3.add(i);
        }
        endTime = System.currentTimeMillis()-startTime;
        System.out.println(endTime);
    }
}
