package streams;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(8,2,3,4,5);
        Optional<Integer> firstElement = integerList.stream().findFirst();
        firstElement.ifPresent(System.out::println);
    }
}
