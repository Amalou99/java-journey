import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {

        List<String> strings = List.of("I", "am", "a", "list", "of", "strings");

        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        // List<String> result = limit.collect(Collectors.toList());

        List<String> result = strings.stream()
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
