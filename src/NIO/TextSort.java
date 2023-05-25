package NIO;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class SortTextFile {
    public static void main(String[] args) {
        Path path = Paths.get("path-to-your-file.txt");
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }

        System.out.println(lines); // to check if lines are read properly
    }
}
