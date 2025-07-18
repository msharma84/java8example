package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple","banana","orange","mango","apple","orange");
        Set<String> seen = new java.util.HashSet<>();
        List<String> duplicateWords = words.stream()
                .filter(word -> !seen.add(word))
                .collect(Collectors.toList());
        duplicateWords.forEach(System.out::println);
    }
}
