import java.io.File;

public class Main {

    public static void main(String[] args) {

        FileHandling fileHandling = new FileHandling();
        EmployeesHandling employeesHandling = new EmployeesHandling();

        File file = new File("employees.csv");
        File stats = new File("stats.txt");
        String[] arrayOfStringsEmployeesInfo = fileHandling.fileToArray(file);

        CompanyStats companyStats = employeesHandling.createStats(arrayOfStringsEmployeesInfo);

        companyStats.printInfo();

        fileHandling.writeToFile(stats, companyStats.getInfo());
    }
}
