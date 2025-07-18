package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseExample {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("apple","banana","orange");
        List<String> upperStringList = stringList
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        upperStringList.forEach(System.out::println);
    }
}
