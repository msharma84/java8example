package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringLengthMap {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "orange", "grape");
        Map<String,Integer> wordLengthMap = words.stream()
                .collect(Collectors.toMap(word -> word, word -> word.length()));
        wordLengthMap.forEach((word, length) -> System.out.println(word +" : "+length));
    }
}
