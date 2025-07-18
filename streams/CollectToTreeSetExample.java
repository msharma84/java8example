package streams;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectToTreeSetExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        TreeSet<Integer> integerTreeSet = integerList.stream().collect(Collectors.toCollection(TreeSet::new));
        integerTreeSet.forEach(System.out::println);
    }
}
