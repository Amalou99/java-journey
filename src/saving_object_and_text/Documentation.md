# java-journey

A code journal documenting my Java programming journey through practical examples and projects.

## Table of Contents

- [File Handling in Java](#file-handling-in-java)
  - [The java.io.File Class](#the-javaiofile-class)
  - [FileReader and FileWriter](#FileReader-and-FileWriter)
  - [The beauty of buffers](#the-beauty-of-buffers)

## File Handling in Java

### The java.io.File Class

The `java.io.File` is an older class in the Java API that has been largely replaced by classes in the `java.nio.file` package in newer Java versions.

Basic usage:

```java
import java.io.File;

File file = new File(fileName);
```

the file Object represents the name and the path of a file or directory on disk. But it doesn't represent , or give you access to, the data in the file!

Important concept: An address is NOT the same as the actual house! A File object is like a street address... it represents the name and location of a particular file, but it isn't the file itself.

For more code details and examples, check the implementation in FileClass.java.

### FileReader and FileWriter

The FileReader class is used to read character-by-character. FileWriter is used to write character-by-character.

### The beauty of buffers

Give you a temporary holding place to group things until the the holder( like a shoping cart) is full. You get to make far fewer trips when you use a buffer.

```
        String fluxCaracterefileName = "flux_caractere_file.txt";

        // File Reader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fluxCaracterefileName))) {

            bufferedReader.lines()
                    .forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.out.println("the file " + fluxCaracterefileName + " doesn't exist !");
        } catch (IOException e) {
            e.printStackTrace();// print the details of
        }

        // File Writter

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fluxCaracterefileName, true))) {

            bufferedWriter.write("line 1");
            bufferedWriter.newLine();
            bufferedWriter.write("line 2");
        } catch (IOException e) {
            e.printStackTrace();
        }
```
