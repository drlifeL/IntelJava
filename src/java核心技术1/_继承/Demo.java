package java核心技术1._继承;

public class Demo {
    public static void main(String[] args) {
        Manager m = new Manager(200);

        Employee [] e = new Employee[3];
        e[0] = m;
        e[1] = new Employee();
        e[2] = new Employee();

        System.out.println(""+m);//在输出语句中，只要使用了+号运算符后面跟一个对象，java会自动的调用其对象的toString()方法


//        for(Employee x : e){
//            System.out.println(x.getSalary());
//        }

    }
}
