import java.util.*;

public class TestTree {
    public static void main(String[] args) {
        new TestTree().go();
    }

    public void go() {
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix your Body");
        Book b3 = new Book("Finding Emo");
        Set<Book> tree = new TreeSet<>((one, two) -> one.getTitle().compareTo(two.getTitle()));
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);
    }
}

class Book {
    private String title;

    public Book(String t) {
        title = t;
    }

    public String getTitle() {
        return title;
    }
}

class Book1 implements Comparable<Book> {
    private String title;

    public Book1(String t) {
        title = t;
    }

    public String getTitle() {
        return title;
    }

    public int compareTo(Book o) {
        return title.compareTo(o.getTitle());
    }
}
