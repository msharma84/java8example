package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortNumbersExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(4,2,7,3,5,1);
        List<Integer> sortedList = integerList
                .stream()
                .sorted()
                .collect(Collectors.toList());
        sortedList.forEach(System.out::println);
    }
}
