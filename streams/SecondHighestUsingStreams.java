package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SecondHighestUsingStreams {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> second = list.stream().sorted((a, b) -> b-a).skip(1).findFirst();
        second.ifPresent(value -> System.out.println("Second : " +value));
    }
}
