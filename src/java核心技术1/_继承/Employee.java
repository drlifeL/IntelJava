package java核心技术1._继承;

public class Employee {
    public Employee(double salary){
        this.salary = salary;
    }

    public Employee(){
        System.out.println("调用我了");
    }

    public int x = 100;
    private double salary = 100;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
