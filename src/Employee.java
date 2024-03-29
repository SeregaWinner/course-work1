import java.util.Objects;

public class Employee {
    private final String fullName;
    private int department;
    private double salary;
    static private int staticId = 1;
    private final int id;


    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = staticId++;
    }


    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "№" + id + " " + "ФИО: " + fullName + ". " + "Отдел: " + department +
                ". " + "Зарплата: " + salary;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return getId() == employee.getId();


    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
