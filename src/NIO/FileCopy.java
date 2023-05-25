package NIO;
import java.io.IOException;
import java.nio.file.*;

public class CopyFile {
    public static void main(String[] args) {
        Path inputFile = Paths.get("src/kirby.png");
        Path outputFile = Paths.get("src/kirby_copy.png");

        try {
            Files.copy(inputFile, outputFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error copying file.");
            e.printStackTrace();
        }
    }
}
