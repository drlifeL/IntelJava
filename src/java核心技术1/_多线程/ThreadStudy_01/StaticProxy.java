package java核心技术1._多线程.ThreadStudy_01;

/**
 * 通过婚庆公司给你布置现场，你负责结婚，来体现静态代理
 * 步骤：
 * 1.实现共同接口
 * 2.代理类有对象引用
 * 3.代理类中写增强方法
 */
public class StaticProxy {
    public static void main(String[] args) {
        new Company(new You()).marry();
    }
}
//真实角色
class You implements Marry {
    @Override
    public void marry() {
        System.out.println("你和你的心上人走进了婚姻殿堂！");
    }
}
//代理者
class Company implements Marry {
    private Marry other;
    public Company(Marry marry) {
        this.other = marry;
    }
    @Override
    public void marry() {
        ready();
        other.marry();
        after();
    }
    public void ready() {
        System.out.println("婚庆公司布置现场！");
    }
    public void after() {
        System.out.println("婚庆公司收拾现场！");
    }
}
interface Marry {
    void marry();
}
