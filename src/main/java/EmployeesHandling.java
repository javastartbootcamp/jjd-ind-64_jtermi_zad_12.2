public class EmployeesHandling {

    private Employee[] createEmployeesTable(String[] linesOfData) {
        Employee[] employees = new Employee[linesOfData.length];
        for (int i = 0; i < linesOfData.length; i++) {
            String[] arrayOfEmployeeDetails = linesOfData[i].split(";");
            employees[i] = new Employee(arrayOfEmployeeDetails[0], arrayOfEmployeeDetails[1],
                    arrayOfEmployeeDetails[2], arrayOfEmployeeDetails[3], Integer.parseInt(arrayOfEmployeeDetails[4]));
        }
        return employees;
    }

    public CompanyStats createStats(String[] linesOfData) {

        Employee[] employees = createEmployeesTable(linesOfData);

        return new CompanyStats(employees);
    }

}
