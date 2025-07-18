package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TopThreeNumbers {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        List<Integer> topThree =  list.stream()
                .sorted((a,b)-> b-a)
                .limit(3)
                .collect(Collectors.toList());
        topThree.forEach(System.out::println);
    }
}
