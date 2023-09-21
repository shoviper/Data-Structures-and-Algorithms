package code;

public class Employee651304 {
    private String Name;
    public int salary;

    public Employee651304(String Name, int salary) {
        this.Name = Name;
        this.salary = salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public int getsalary() {
        return salary;
    }

    public void setsalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp " + Name + "(" + salary + ")";
    }
}
