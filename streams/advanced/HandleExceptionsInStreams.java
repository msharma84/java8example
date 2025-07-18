package streams.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HandleExceptionsInStreams {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "orange", "mango");
        List<Integer> length = words.stream()
                .map(word -> {
                    try {
                        return getLength(word);
                    } catch (Exception e) {
                        System.err.println("Error while processing the word : " + word);
                        return -1;
                    }
                }).collect(Collectors.toList());
    }


    private static int getLength(String word) throws Exception {
        if (word.equals("banana")) {
            throw new CustomException("Banana is not allowed");
        }
        return word.length();
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
