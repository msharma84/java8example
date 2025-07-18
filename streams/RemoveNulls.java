package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveNulls {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple","banana",null,"mango",null,"orange");
        List<String> nonNullList =  words.stream()
                .filter(word -> word != null)
                .collect(Collectors.toList());

        System.out.println("Non Null List : "+nonNullList);
    }
}
