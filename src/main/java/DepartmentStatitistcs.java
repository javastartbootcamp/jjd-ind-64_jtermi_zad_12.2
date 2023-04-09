public class DepartmentStatitistcs {
    String department;
    int numberOfEmployees;

    public DepartmentStatitistcs(String department, int numberOfEmployees) {
        this.department = department;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getDepartment() {
        return department;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void incNumberOfEmployees() {
        this.numberOfEmployees++;
    }
}
