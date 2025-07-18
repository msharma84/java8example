package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ConcatenateStreams {

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1,2);
        List<Integer> l2 = Arrays.asList(3,4);
        List<Integer> l3 = Arrays.asList(5,6);

        Stream<Integer> concatenatedStream  = Stream.concat(l1.stream(),l2.stream());
        concatenatedStream = Stream.concat(concatenatedStream,l3.stream());

        concatenatedStream.forEach(System.out::println);
    }
}
