public class EmployeesHandling {

    Employee[] employees;
    DepartmentStatitistcs[] departments;
    int deptCounter = 0;

    public void createEmployeesTable(String[] arrayOfStringData) {

        employees = new Employee[arrayOfStringData.length];
        for (int i = 0; i < arrayOfStringData.length; i++) {
            String[] arrayOfEmployeeDetails = arrayOfStringData[i].split(";", 5);
            employees[i] = new Employee(arrayOfEmployeeDetails[0], arrayOfEmployeeDetails[1],
                    arrayOfEmployeeDetails[2], arrayOfEmployeeDetails[3], Integer.parseInt(arrayOfEmployeeDetails[4]));
        }
    }

    public String createStats() {

        return calculateAverageSalary() + "\n" +
        findLowestSalary() + "\n" +
        findHighestSalary() + "\n" +
        createDepartmentStatistics();
    }

    private String createDepartmentStatistics() {
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
        StringBuilder statString = new StringBuilder();
        for (int i = 0; i < deptCounter; i++) {
            statString.append("Liczba pracowników ").append(departments[i].getDepartment())
                    .append(": ").append(departments[i].getNumberOfEmployees()).append("\n");
        }

        return statString.toString();
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

    private String findHighestSalary() {
        int highestSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            int salary = employee.getSalary();
            if (highestSalary < salary) {
                highestSalary = salary;
            }
        }
        return "Maksymalna wypłata: " + highestSalary;
    }

    private String findLowestSalary() {
        int lowestSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            int salary = employee.getSalary();
            if (lowestSalary > salary) {
                lowestSalary = salary;
            }
        }
        return "Minimalna wypłata: " + lowestSalary;
    }

    private String calculateAverageSalary() {
        int totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return "Średnia wypłata: " + totalSalary / employees.length;
    }
}
