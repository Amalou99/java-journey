import java.util.List;
import java.util.stream.Stream;

public class LambdaExamp {

    public static void main(String[] args) {

        List<String> strings = List.of("I", "am", "a", "list", "of", "strings");

        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);

        System.out.println(limit);
    }
}
