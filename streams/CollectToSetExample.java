package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectToSetExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,1,5,6,7,5);
        Set<Integer> integerSet = integerList.stream().collect(Collectors.toSet());
        integerSet.forEach(System.out::println);
    }
}
