public class CompanyStats {

    private final Employee[] employees;
    private DepartmentStatitistcs[] departments;
    private int deptCounter = 0;

    private int lowestSalary;
    private int averageSalary;
    private int highestSalary;

    public CompanyStats(Employee[] employees) {
        this.employees = employees;
        createDepartmentStatistics();
        findHighestSalary();
        findLowestSalary();
        calculateAverageSalary();
    }

    private void createDepartmentStatistics() {
        deptCounter = 0;
        departments = new DepartmentStatitistcs[employees.length];

        for (Employee employee : employees) {
            if (notDuplicate(employee.getDepartment())) {
                departments[deptCounter] = new DepartmentStatitistcs(employee.getDepartment(), 1);
                deptCounter++;
            } else {
                addEmployeeToDepartment(employee.getDepartment());
            }
        }
    }

    private void addEmployeeToDepartment(String department) {
        for (int i = 0; i < deptCounter; i++) {
            if (departments[i].getDepartment().equals(department)) {
                departments[i].incNumberOfEmployees();
                break;
            }
        }
    }

    private boolean notDuplicate(String department) {

        for (int i = 0; i < deptCounter; i++) {
            String dept = departments[i].getDepartment();
            if (dept.equals(department)) {
                return false;
            }
        }
        return true;
    }

    private void findHighestSalary() {
        int tempHighestSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            int salary = employee.getSalary();
            if (tempHighestSalary < salary) {
                tempHighestSalary = salary;
            }
        }
        this.highestSalary = tempHighestSalary;
    }

    private void findLowestSalary() {
        int tempLowestSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            int salary = employee.getSalary();
            if (salary < tempLowestSalary) {
                tempLowestSalary = salary;
            }
        }
        this.lowestSalary = tempLowestSalary;
    }

    private void calculateAverageSalary() {
        int tempAverageSalary = 0;
        for (Employee employee : employees) {
            tempAverageSalary += employee.getSalary();
        }
        this.averageSalary = tempAverageSalary / employees.length;
    }

    public void printInfo() {
        System.out.println(getInfo());
    }

    public String getInfo() {
        StringBuilder statString = new StringBuilder();

        statString.append("Średnia wypłata: ").append(averageSalary).append("\n");
        statString.append("Minimalna wypłata: ").append(lowestSalary).append("\n");
        statString.append("Maksymalna wypłata: ").append(highestSalary).append("\n");

        for (int i = 0; i < deptCounter; i++) {
            statString.append("Liczba pracowników ").append(departments[i].getDepartment())
                    .append(": ").append(departments[i].getNumberOfEmployees()).append("\n");
        }
        return String.valueOf(statString);
    }

}
