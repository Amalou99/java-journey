import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileClass {

    public static void main(String[] args) throws IOException {

        String fileName = "fileClassfile.txt";
        File file = new File(fileName);
        File repository = new File("build");

        System.out.println("--------- File && Directory ------------");
        System.out.println("file: " + file.isDirectory());
        System.out.println("file " + file.exists());
        System.out.println("repository: " + repository.isDirectory());
        System.out.println("repository: " + repository.exists());

        System.out.println("--------- File details ------------");
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getPath());
        System.out.println("File Path Absolute: " + file.getAbsolutePath());
        System.out.println("File Acces Right: " + file.canWrite());

        System.out.println("--------- Repository details ------------");
        Arrays.stream(repository.listFiles())
                .forEach(System.out::print);

        System.out.println("--------- Read && Write Stream ------------");
        new FileReader(file);
        new FileWriter(file);
    }
}
