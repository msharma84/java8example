package streams;

import java.util.Arrays;
import java.util.List;

public class SumUsingStreams {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int count = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(count);
    }
}
