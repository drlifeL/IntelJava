package java核心技术1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class InstanceOfTest {
    public static void main(String[] args) throws FileNotFoundException {
        A1 a1 = new A1();
        A2 a2 = new A2();
        //   instanceof 对象判断符， 判断类A是否是类B的子类，　　该运算符的左边应该是该类的实例，　右边应该是该类的全名称
        System.out.println(a2 instanceof A1);

        Object s = "abc";
        File file = new File("C:\\Users\\Administrator\\Desktop\\Message.txt");
        FileInputStream in = new FileInputStream(file);

        System.out.println(in instanceof InputStream);
    }
}

class A1{

}

class A2 extends A1{

}
