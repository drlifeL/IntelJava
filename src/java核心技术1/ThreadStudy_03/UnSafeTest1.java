package java核心技术1.ThreadStudy_03;

import java.util.ArrayList;
import java.util.List;

/**
 * 买票，取钱
 *
 * 多线程操作同一个容器的时候可能会造成数据的覆盖和丢失
 */
public class UnSafeTest1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        System.out.println(list.size());
    }
}
