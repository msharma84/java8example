package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,1,5,2,7,8);
        List<Integer> distinctList = integerList.stream().distinct().collect(Collectors.toList());
        distinctList.forEach(System.out::println);
    }
}
