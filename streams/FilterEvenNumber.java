package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenNumber {

    public static void main(String[] args) {

       List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9);
       List<Integer> evenList = integerList
                .stream()
                .filter(n->n%2==0)
                .collect(Collectors.toList());
       evenList.forEach(System.out::println);
    }
}
