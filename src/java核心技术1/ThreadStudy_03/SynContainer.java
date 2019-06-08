package java核心技术1.ThreadStudy_03;

import java.util.concurrent.CopyOnWriteArrayList;

public class SynContainer {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> list.add(Thread.currentThread().getName())).start();
        }
        try {
            Thread.sleep(5000);//必须让主线程先睡一会，否则其他还没结束，但主线程已经挂了！
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
