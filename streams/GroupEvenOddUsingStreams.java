package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEvenOddUsingStreams {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Map<Boolean,List<Integer>> evenOdd = list.stream().collect(Collectors.partitioningBy(num -> num%2==0));

        List<Integer> evenList = evenOdd.get(true);
        List<Integer> oddList = evenOdd.get(false);

        System.out.println(evenList);
        System.out.println(oddList);
    }
}
