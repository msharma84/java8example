package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewQuestion1 {

    public static void main(String[] args) {

        // Change all element to uppercase
        List<String> list = Arrays.asList("apple","banana","cherry","pineapple");
        List<String> upperCaseList = list.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        upperCaseList.forEach(System.out::println);

        // Longest String in a list
        // 1.
        String longest1 = list.stream().max(Comparator.naturalOrder()).orElse("-1");
        // 2.
        String longest2 = list.stream().max(Comparator.comparingInt(String::length)).orElse("-1");

        System.out.println("longest 1 - "+longest1);
        System.out.println("longest 2- "+longest2);

        // Average age from a list
        List<AnotherPerson> persons = Arrays.asList(
                new AnotherPerson("Alice", 25),
                new AnotherPerson("Bob", 30),
                new AnotherPerson("Charlie", 35)
        );

        double averageAge = persons.stream().mapToInt(AnotherPerson::getAge).average().orElse(0);
        System.out.println("Average Age : - "+averageAge);

        // Merged two sorted list into a single sorted list
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> mergedList = Stream.concat(list1.stream(),list2.stream())
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        mergedList.forEach(System.out::println);

        // Intersection of two list
        List<Integer> list3= Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list4 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> intersectionList = list3.stream()
                .filter(list4::contains)
                .collect(Collectors.toList());

        intersectionList.forEach(System.out::println);

        // Remove duplicate from a list while preserving the order
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        List<Integer> removeDuplicate = numbersWithDuplicates.stream().distinct().collect(Collectors.toList());
        removeDuplicate.forEach(System.out::println);

        // Find the sum of transaction
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

       Map<String,Integer> sumByDay = transactions.stream().collect(Collectors.groupingBy(Transaction::getDate,
                Collectors.summingInt(Transaction::getAmount)));

       sumByDay.forEach( (day,amount) ->
               System.out.println("Day  : "+day + " amount : "+amount));

       // Find frequency of each word
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple","kiwi");

        Map<String, Long>  frequency =  words.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        frequency.forEach( (word,fre)
                -> System.out.println("Word : "+ word + " frequency : "+fre));

        // Partitioned List based on certain condition
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partioned =numbers.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));

        System.out.println("Even List : "+partioned.get(true));
        System.out.println("Odd List : "+partioned.get(false));

        // Sum of all even numbers in a list of integers
        List<Integer> allNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Integer evenCount = allNumbers.stream().filter(n->n%2==0).mapToInt(Integer::intValue).sum();
        System.out.println("Even count - "+evenCount);

        // Count person whose age greater than 30
        Long personGT30 = persons.stream().filter( p -> p.getAge() > 30).count();
        System.out.println("Person Greater then 30 - "+personGT30);

        // Square of each numbers in a list
        List<Integer> squaredNumbers = allNumbers.stream().map( n -> n*n).collect(Collectors.toList());
        System.out.println("Square : -"+squaredNumbers);
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    void printPrime(){

        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
        numbers.stream().anyMatch(this::isPrime);
    }

}

class AnotherPerson{

    private String name;
    private int age;

    public AnotherPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Transaction{

    private String date;
    private int amount;

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}