package streams;

import java.util.Arrays;
import java.util.List;

public class AverageUsingStreams {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        double average = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("Average - "+average);
    }
}
