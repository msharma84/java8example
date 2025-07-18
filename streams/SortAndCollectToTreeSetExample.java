package streams;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SortAndCollectToTreeSetExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,5,3,2,9,8,7,6);
        TreeSet<Integer> integerTreeSet = integerList
                .stream()
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
        integerTreeSet.forEach(System.out::println);
    }
}
