package streams;

import java.util.Arrays;
import java.util.List;

public class SkipStreamExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        integerList
                .stream()
                .skip(3)
                .forEach(System.out::println);
    }
}
