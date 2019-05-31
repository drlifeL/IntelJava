package java核心技术1.ThreadStudy_02;

/**
 * 使用Sleep方法模拟倒计时
 */
public class BlockedSleep {
    public static void main(String[] args) throws InterruptedException {
        int time = 10;
        while (time > 0) {
            System.out.println(time--);
            Thread.sleep(1000);//没运行一次，让其沉睡一秒
        }
        System.out.println("OK");

    }
}
