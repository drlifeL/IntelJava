package java核心技术1.ThreadStudy_03;

/**
 * 演示死锁现象
 * 死锁：过多的同步可能造成相互不释放资源
 * 从而相互等待，一般发生于同步中持有多个对象的锁
 * <p>
 * 避免：不要在同一个代码块中，同时持有多个对象的锁
 */
public class DeadLock {
    public static void main(String[] args) {
        new MarkUp(1, "二丫").start();
        new MarkUp(2, "三傻").start();

    }
}

class MarkUp extends Thread {
    //使用静态的原因是为了实现死锁的情况
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choose;//镜子是1,
    String grid;

    public MarkUp(int choose, String grid) {
        this.choose = choose;
        this.grid = grid;
    }

    @Override
    public void run() {
        mark();

    }

    private void mark() {
        if (choose == 1) {
            synchronized (lipstick) {
                System.out.println(this.grid + "拿了口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                synchronized (mirror) {
//                    System.out.println(this.grid + "拿了镜子");
//                }
            }
            synchronized (mirror) {
                System.out.println(this.grid + "拿了镜子");
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.grid + "拿了镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                synchronized (lipstick) {
//                    System.out.println(this.grid + "拿了口红");
//                }
            }
            synchronized (lipstick) {
                System.out.println(this.grid + "拿了口红");
            }
        }

    }
}

class Lipstick {

}

class Mirror {

}
