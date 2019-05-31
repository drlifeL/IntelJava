package java核心技术1.ThreadStudy_02;

public class YieldDemo2 {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("我的线程" + i);
            }
        }).start();
        for (int i = 0; i < 100; i++) {

            System.out.println("主线程" + i);
            if (i % 10 == 0) {
                Thread.yield();
            }
        }
    }
}
