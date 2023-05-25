package NIO;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CopyFile2 {
    public static void main(String[] args) {
        Path inputFile = Paths.get("src/kirby.png");
        Path outputFile = Paths.get("src/kirby_copy.png");

        try {
            Files.copy(inputFile, outputFile);
            System.out.println("File copied successfully.");
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists, creating a new file with a unique name.");

            // Create a new file name by appending the current timestamp
            String newFileName = outputFile.toString() + "_" +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".png";

            outputFile = Paths.get(newFileName);

            try {
                Files.copy(inputFile, outputFile);
                System.out.println("File copied successfully to " + newFileName);
            } catch (IOException e2) {
                System.out.println("Error copying file.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Error copying file.");
            e.printStackTrace();
        }
    }
}