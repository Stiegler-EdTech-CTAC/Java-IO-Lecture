package Traditional_IO;
import java.io.*;
public class CopyFile {
    public static void main(String[] args) {
        String inputFile = "src/kirby.png";
        String outputFile = "src/kirby_copy.png";
        byte[] buffer = new byte[1024];
        int bytesRead;

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile))) {

            while ((bytesRead = bis.read(buffer)) != -1) {
                System.out.println(bytesRead + " bytes read from file.");

                // Processing data
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print(buffer[i] + " ");
                }
                System.out.println();

                // Writing data
                bos.write(buffer, 0, bytesRead);
                System.out.println("Data written to file.");
            }

        } catch (IOException e) {
            System.out.println("Error reading or writing file");
            e.printStackTrace();
        }
    }
}



