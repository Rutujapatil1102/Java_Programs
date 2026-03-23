package experiment3;
class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    void display() {
        System.out.println(id + " " + name + " " + salary);
    }
    void calculateSalary(double bonus) {
        System.out.println("Salary with Bonus: " + (salary + bonus));
    }

    void calculateSalary(double bonus, double allowance) {
        System.out.println("Salary with Bonus & Allowance: " + (salary + bonus + allowance));
    }
}

class Manager extends Employee {

    Manager(int id, String name, double salary) {
        super(id, name, salary);
    }

    void display() {
        System.out.println("Manager:");
        super.display();
    }
}


public class employeemanagementsystem {
	public static void main(String[] args) {

        Employee e = new Employee(1, "Rohit", 30000);
        Manager m = new Manager(2, "Sangram", 50000);

        // Display
        e.display();
        m.display();

        // Method Overloading
        e.calculateSalary(2000);
        e.calculateSalary(2000, 1500);
    }
}


