package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestWord {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple","banana","orange","mango","pineapple");
        Optional<String> longest =  words.stream()
                .max(Comparator.comparingInt(String::length));
        longest.ifPresent(word -> System.out.println("Longest Word : "+word));
    }
}
