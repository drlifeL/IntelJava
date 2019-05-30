package java核心技术1._多线程.ThreadStudy_01;

public class lambdaTest {
    //静态内部类
    static class Mylambda implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 200; i++) {
                System.out.println("一边听歌");
            }
        }
    }

    public static void main(String[] args) {
//        new Thread(new Mylambda()).start();

        //局部内部类
        class Mylambda implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    System.out.println("一边听歌");
                }
            }
        }

        new Thread(new Mylambda()).start();

        //匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    System.out.println("匿名内部类");
                }
            }
        }).start();

        //lambda表达式
        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                System.out.println("lambda表达式");
            }
        }).start();


    }
}
