import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class APINIO2 {

    public static void main(String[] args) throws IOException {

        // Path path = Paths.get("file_nio2.txt");
        Path path = Files.createTempFile("prefix", "suffix");
        System.out.println(path);

        // Write Sring
        Files.writeString(path, "Line 99" + System.lineSeparator());
        Files.writeString(path, "Line 100" + System.lineSeparator(), StandardOpenOption.APPEND);

        Files.readAllLines(path).stream()
                .forEach(System.out::println);

        // BufferedWriter

        BufferedReader raeder = Files.newBufferedReader(Paths.get("/path/to/files/myFile.txt"));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("/path/to/files/myFile.txt"));
    }
}
