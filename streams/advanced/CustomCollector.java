package streams.advanced;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

class Person{

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

public class CustomCollector {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Ramesh", 35));
        personList.add(new Person("Suresh", 30));
        personList.add(new Person("Mahesh", 25));
        personList.add(new Person("Rakesh", 20));

        TreeSet<Person> sortedPerson = personList.stream()
                .collect(new TreeSetCollector<>(Comparator.comparingInt(person -> person.getAge())));

        sortedPerson.forEach(p -> System.out.println(p));
    }
}

class TreeSetCollector<T> implements Collector<T, TreeSet<T>, TreeSet<T>> {

    private final Comparator<? super T> comparator;

    public TreeSetCollector(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Supplier<TreeSet<T>> supplier() {
        return () -> new TreeSet<>(comparator);
    }

    @Override
    public BiConsumer<TreeSet<T>, T> accumulator() {
        return TreeSet::add;
    }

    @Override
    public BinaryOperator<TreeSet<T>> combiner() {
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<TreeSet<T>, TreeSet<T>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }
}
