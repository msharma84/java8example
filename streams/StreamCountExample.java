package streams;

import java.util.Arrays;
import java.util.List;

public class StreamCountExample {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,2,3,4);
        long count = integerList.stream().count();
        System.out.println(count);
    }
}
