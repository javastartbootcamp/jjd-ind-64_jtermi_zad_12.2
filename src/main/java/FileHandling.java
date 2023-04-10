import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandling {

    public String[] fileToArray(File file) {

        int lines = countLines(file);
        String[] arrayOfLines = new String[lines];

        try (Scanner scanner = new Scanner(file)) {
            for (int i = 0; i < arrayOfLines.length; i++) {
                arrayOfLines[i] = scanner.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayOfLines;
    }

    private int countLines(File file) {
        int lines = 0;
        try (
                Scanner scanner = new Scanner(file)
                ) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lines++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public void writeToFile(File file, String dataToWrite) {

        try (FileWriter fileWriter = new FileWriter(file)) {
            file.createNewFile();
            fileWriter.write(dataToWrite);
        } catch (IOException e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
