# java-journey

A code journal documenting my Java programming journey through practical examples and projects.

## Table of Contents

- [File Handling in Java](#file-handling-in-java)
  - [The java.io.File Class](#the-javaiofile-class)

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
