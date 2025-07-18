package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple","banana","orange","mango","apple","orange");
        Map<String,Long> wordCount =  words.stream()
                .collect(Collectors.groupingBy(word -> word,Collectors.counting()));
        wordCount.forEach((word,count) -> System.out.println(word + " : " +count));
    }
}
