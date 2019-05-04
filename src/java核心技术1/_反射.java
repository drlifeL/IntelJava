package java核心技术1;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class _反射 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Node node = new Node();
        Class<Node> clz = (Class<Node>) node.getClass();
        Node node1 = (Node) Class.forName("java核心技术1.Node").newInstance();
        Field[] fields = clz.getFields();
        //获取类中所有的的公开字段，如果想要获取到私有的字段，我们需要设置一下开启虚拟机的访问权限

        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName() + "::" + fields[i].getType());
        }

        System.out.println(node == node1);
        System.out.println("<----------------------------------->");
        Integer i  =  new Integer(10);
        String className = i.getClass().getName();
        System.out.println(className);
        Class clzz = Class.forName("java核心技术1.Node");
        Constructor[] constor = clzz.getDeclaredConstructors();
        //获取所有的公开字段
        Field [] fields1 = clzz.getDeclaredFields();
        for (int j = 0; j < fields1.length; j++) {
            System.out.println(fields1[j].toGenericString());
        }
        System.out.println("<----------------------------------->");
        for (int j = 0; j < constor.length; j++) {
            System.out.println(constor[j].toGenericString());
        }
        System.out.println("<----------------------------------->");


        Method [] methods = clzz.getMethods();
        AccessibleObject.setAccessible(methods,true);
        Method.setAccessible(methods,false);
        for (Method m:methods) {
            System.out.println(m.toGenericString());
        }

    }
}


