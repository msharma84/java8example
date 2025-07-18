package streams.advanced;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByMultipleFields {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Ramesh", 35));
        personList.add(new Person("Suresh", 30));
        personList.add(new Person("Mahesh", 20));
        personList.add(new Person("Rakesh", 20));

        List<Person> sortedPeople = personList.stream()
                .sorted(Comparator.comparingInt((Person person) -> person.getAge())
                        .thenComparing(person -> person.getName()))
                .collect(Collectors.toList());

        System.out.println("Sorted people by age and name: " + sortedPeople);
    }
}
