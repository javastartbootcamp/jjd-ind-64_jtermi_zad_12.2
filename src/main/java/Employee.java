public class Employee {
    private final String firstName;
    private final String lastName;
    private final String pesel;
    private final String department;
    private final int salary;

    public Employee(String firstName, String lastName, String pesel, String department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
