package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

       int result = list.stream()
               .filter(n->n%2==1)
               .map(n-> n*2)
               .reduce(0, Integer::sum);

        System.out.println(result);
    }
}
