package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxMinUsingStreams {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Optional<Integer> max = list.stream().max(Integer::compareTo);
        Optional<Integer> min = list.stream().min(Integer::compareTo);

        max.ifPresent(System.out::println);
        min.ifPresent(System.out::println);
    }
}
