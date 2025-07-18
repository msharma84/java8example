package streams.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MostFrequenOccurrence {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple","banana","orange","apple","orange","mango");
        Optional<Map.Entry<String, Long>> frequency = list.stream()
                .collect(Collectors.groupingBy(e -> e,Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        frequency.ifPresent(entry ->{
            System.out.println("Most frequent element : "+entry.getKey() + " with frequency "+entry.getValue());
        });
    }
}
