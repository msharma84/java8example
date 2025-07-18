package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Person{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class SortCustomObjectsExample {

    public static void main(String[] args) {

        Person p1 = new Person("Ram",17);
        Person p2 = new Person("Shyam",19);
        Person p3 = new Person("Manish",16);
        Person p4 = new Person("Suresh",18);

        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        /*List<Person> sortedPersonList = personList
                .stream()
                .filter(p-> p.getAge()>18)
                .collect(Collectors.toList());

        sortedPersonList.forEach(System.out::println);*/


        /*List<Person> sortedListPerson = personList
                .stream()
                .sorted((objP1,objP2)->Integer.compare(objP1.getAge(),objP2.getAge()))
                .collect(Collectors.toList());
        sortedListPerson.forEach(System.out::println);*/

        // Reverse Sort Order
        /*List<Person> sortedListPerson = personList
                .stream()
                .sorted((objP1,objP2)->Integer.compare(objP2.getAge(),objP1.getAge()))
                .collect(Collectors.toList());
        sortedListPerson.forEach(System.out::println);*/

        // Sort by Name
        List<Person> sortedListPerson = personList
                .stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        sortedListPerson.forEach(System.out::println);
    }
}
