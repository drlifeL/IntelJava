package _蓝桥._2014;
/**
 *   写日志是程序的常见任务。现在要求在 t1.log, t2.log, t3.log 三个文件间轮流写入日志。
 *   也就是说第一次写入t1.log，第二次写入t2.log，... 第四次仍然写入t1.log，如此反复。
 */
public class _5写日志 {

    private static int n = 1;

    public static void write(String msg) {
        String filename = "t" + n + ".log";
        n = n % 3 + 1;//对3取余+1
        //自己想的是
        //n = n+1==3?n:1;
        System.out.println("write to file: " + filename + " " + msg);
    }
}
