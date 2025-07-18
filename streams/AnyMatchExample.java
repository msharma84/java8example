package streams;

import java.util.Arrays;
import java.util.List;

public class AnyMatchExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2,4,5,6,8);
        boolean anyMatch = integerList.stream().anyMatch(n->n%2==1);
        System.out.println("Is Odd in Even list :- "+anyMatch);
    }
}
