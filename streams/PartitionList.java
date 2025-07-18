package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionList {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,13,4,14,5,15,6,16);

        Map<Boolean,List<Integer>> partitionMap = list.stream()
                .collect(Collectors.partitioningBy(n-> n>10 ));

        List<Integer> greaterThan10List = partitionMap.get(true);
        List<Integer> lessThan10List = partitionMap.get(false);

        System.out.println("Greater Than 10 :- "+greaterThan10List);
        System.out.println("Less Than 10 :- "+lessThan10List);
    }
}
