package java核心技术1._多线程.ThreadStudy_01;

/**
 * 模拟龟兔赛跑
 */
public class Racer implements Runnable {
    private String winner;
    //谁先到达，flag就是谁
    private boolean flag;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            //模拟兔子跑10睡觉
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (flag) {//如果已经有人到了，那么其他人就不用跑了
                break;
            }
        }
        if (!flag) {
            System.out.println(winner + Thread.currentThread().getName());
            winner = Thread.currentThread().getName();
            flag = true;
        }
    }

    public static void main(String[] args) {
        Racer r = new Racer();
        new Thread(r, "乌龟").start();
        new Thread(r, "兔子").start();
        //因为是用主线程来判断，所以说我们必须让主线程等待一下其他线程执行完在执行他。让他睡一会
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(r.winner);
    }
}
