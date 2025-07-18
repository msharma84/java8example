package streams;

import java.util.stream.Stream;

public class StreamFromArrayExample {

    public static void main(String[] args) {
        Integer[] numberArray = {1, 2, 3, 4, 5};
        Stream<Integer> integerStream = Stream.of(numberArray);
        integerStream.forEach(System.out::println);
    }
}
