package Traditional_IO;
import java.io.*;
import java.util.*;

public class SortTextFile {
    public static void main(String[] args) {
        String inputFilePath = "src/data_file.txt";
        String outputFilePath = "src/data_file_sorted.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
        // Print file content
        System.out.println("Unsorted: " + lines);

        // Sort the lines
        Collections.sort(lines);

        // Print sorted file content
        System.out.println("Sorted: " + lines);

        // Write sorted lines to a new file
        try {
            File outputFile = new File(outputFilePath);
            // Create the output file if it does not exist
            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFile.getName());
            } else {
                System.out.println("File already exists. Will be updated with new content.");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            for (String sortedLine : lines) {
                writer.write(sortedLine);
                writer.newLine();
            }
            writer.close();
            System.out.println("Data written to file.");

        } catch (IOException e) {
            System.out.println("Error writing to file");
            e.printStackTrace();
        }
    }
}
