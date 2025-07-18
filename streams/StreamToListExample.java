package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToListExample {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(5,4,3,2,1);
        List<Integer> integerList = stream.collect(Collectors.toList());
        integerList.forEach(System.out::println);
    }
}
