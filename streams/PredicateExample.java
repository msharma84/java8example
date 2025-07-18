package streams;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        Predicate<String> startPredicate = x -> x.toLowerCase().startsWith("a");
        Predicate<String> endPredicate = x -> x.toLowerCase().endsWith("t");

        Predicate<String> finalPredicate = startPredicate.and(endPredicate);
        boolean result1 = finalPredicate.test("ankit");
        boolean result2 = finalPredicate.test("akshay");

        System.out.println(result1);
        System.out.println(result2);
    }
}
