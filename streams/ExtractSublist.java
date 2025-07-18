package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractSublist {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 12, 3, 18, 7, 10, 21);
        List<Integer> list = numbers.stream()
                .filter(n -> n>10)
                .filter(n -> n%2==0)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
