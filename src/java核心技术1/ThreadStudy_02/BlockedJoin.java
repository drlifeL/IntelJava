package java核心技术1.ThreadStudy_02;

/**
 * 插队
 */
public class BlockedJoin {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                System.out.println("Other -->" + i);
            }
        });
        t.start();
        for (int i = 1; i < 100; i++) {
            if (i == 20) {//调用插队
                try {
                    t.join();//其他线程阻塞，必须等t运行完毕其他线程才进入就绪状态，
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main -->" + i);
        }
    }
}
