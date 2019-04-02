package java核心技术1;

/**
 * 推荐在下面两种情况下使用静态方法：
 *  1.一个方法不需要访问对象状态，其所需要的参数都是用过显示参数提供（例如：Math.pow）
 *  2.一个方法只需要访问类的静态域，例如（Employee.getNext_id()）;
 */
public class _静态方法 {
    public static void main(String[] args) {
        /**
         * 静态方法是不能访问id的实例域，但是实例域可以访问自身类中的静态域
         */
        Employee mark = new Employee();
        System.out.println(mark.getNext_id_NoStatic());//通过对象来获取静态域
        System.out.println(Employee.getNext_id());//直接通过类名调用

    }
}
class Employee{
    private static int next_id = 100;
    private int id;

    /**
     * 调用类中的静态方法
     * @return
     */
    public static int getNext_id(){
        return next_id;
    }

    /**
     * 通过实例来获取静态域中的值（不推荐使用，因为本身静态域中的值和对象没有任何关联，如果这样写的话会造成我们的概念混淆）
     * @return
     */
    public int getNext_id_NoStatic(){
        return next_id;
    }
}
