package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = integerList.stream();
        stream.forEach(System.out::println);
    }
}
