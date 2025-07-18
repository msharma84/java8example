package streams;

import java.util.Arrays;
import java.util.List;

public class AllMatchExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2,4,6,8);
        boolean allEven = integerList.stream().allMatch(n->n%2==0);
        System.out.println("All Even :- "+allEven);
    }
}
