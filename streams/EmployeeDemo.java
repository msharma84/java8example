package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDemo {

    public static void main(String[] args) {
        NewEmployee emp1 = new NewEmployee(1, "Promise", "IT", 40.0);
        NewEmployee emp2 = new NewEmployee(2, "John", "HR", 70.0);
        NewEmployee emp3 = new NewEmployee(3, "Peter", "Facility", 70.0);
        NewEmployee emp4 = new NewEmployee(4, "Tayo", "Facility", 30.0);

        List<NewEmployee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        // Print all employee Name
        List<String> employeeName = employeeList.stream().map(NewEmployee::getName).collect(Collectors.toList());
        employeeName.forEach(System.out::println);

        // Create mapping for Id and New Employee object
        Map<Integer,NewEmployee> employeeIdMap = employeeList.stream().collect(Collectors.toMap(NewEmployee::getId, employee -> employee));
        System.out.println(employeeIdMap);

        // Create mapping of employee id and their names
        Map<Integer, String> employeeIdNameMap = employeeList.stream().collect(Collectors.toMap(NewEmployee::getId,NewEmployee::getName));
        System.out.println(employeeIdNameMap);

        // Get Employees by their department
        Map<String,List<NewEmployee>> employeesByDept = employeeList.stream()
                .collect(Collectors.groupingBy(NewEmployee::getDept));
        System.out.println(employeesByDept);

        // Find employee with the maximum salary
        NewEmployee empWithMaxSalary  = employeeList.stream().max(Comparator.comparing(NewEmployee::getSalary)).get();
        System.out.println("Employee with max salary : "+empWithMaxSalary);

        // Find employee with minimum salary
        NewEmployee empWithMinSalary = employeeList.stream().min(Comparator.comparing(NewEmployee::getSalary)).get();
        System.out.println("Employee with min salary : "+empWithMinSalary);

        // Find the average salary
        double avgSalary = employeeList.stream().mapToDouble(NewEmployee::getSalary).average().orElse(-1);
        System.out.println("Average Salary : "+avgSalary);

        // Calculate total Salary
        double totalSalary = employeeList.stream().reduce(0.00, (a,b)->a +b.getSalary(),Double::sum);
        System.out.println("Total Salary : "+totalSalary);

        // Filter Even number from the list
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> evenNumList = numbers.stream().filter(n -> n %2==0).collect(Collectors.toList());
        System.out.println(evenNumList);

        List<String> words = Arrays.asList("an", "boy", "the", "apple");
        String word = words.stream().filter(n -> n.length()>2).findFirst().orElse("-1");
        System.out.println(word);

        List<String> fruits = Arrays.asList("banana", "apple", "Avocado", "orange");
        long count = fruits.stream().filter(a -> a.toLowerCase().startsWith("a")).count();
        System.out.println(count);

        // Convert a list of String to uppercase
        List<String> names = Arrays.asList("Java", "John", "Doe");
        List<String>  namesToUpper  =names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(namesToUpper);

        // Group String by their length
        List<String> strings = Arrays.asList("apple", "boy", "girl", "man", "woman");
        Map<Integer,List<String>> stringLengthMap  = strings.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(stringLengthMap);

        // Flattern a list of lists
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("x", "y", "z"),
                Arrays.asList("a", "b", "c"),
                Arrays.asList("1", "2", "3")
        );
        List<String> flatternedList = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatternedList);

        // Find duplicate
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        Set<String> set = new HashSet<>();
        Set<String> duplicate = input.stream().filter(w -> !set.add(w)).collect(Collectors.toSet());
        System.out.println("Duplicate - "+duplicate);
        System.out.println("Unique - "+set);

        //
        List<String> uniqueList = input.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique List - "+uniqueList);


        //
        List<String> nameList = Arrays.asList("John", "doe", "smith", "promise", "akeni");
        String joinedNames = nameList.stream().collect(Collectors.joining(","));
        System.out.println("Joined Names - "+joinedNames);

        Map<Boolean,List<Integer>> partitionByEvenNum  = numbers.stream().collect(Collectors.partitioningBy(n-> n%2==0));
        System.out.println(partitionByEvenNum);

        List<Integer> evenList = partitionByEvenNum.get(true);
        List<Integer> oddList = partitionByEvenNum.get(false);
        System.out.println("evenList :" + evenList);
        System.out.println("oddList :" + oddList);

        List<String> wordList = Arrays.asList("a", "bfgij", "abc", "abcd", "abcde");
        List<String> top3LongestWords =  wordList.stream().sorted(Comparator.comparing(String::length).reversed()).limit(3).collect(Collectors.toList());
        System.out.println(top3LongestWords);

        List<Integer> nums = Arrays.asList(6, 1, 9, 6, 5, 7, 3, 3, 2, 2, 1);
        int num = nums.stream().sorted().distinct().skip(1).findFirst().orElse(-1);
        System.out.println(num);

        int num2 = nums.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(1);
        System.out.println(num2);

        Set<Integer> set1 = Set.of(1,2,3,4,5);
        int[] setToArray = set1.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(setToArray));

        List<String> fruits1 = List.of("apple", "pineapple", "mango", "guava", "orange", "banana");
        List<String> sortedFruits = fruits1.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedFruits);

        List<String> sortedFruitsInDesc = fruits1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedFruitsInDesc);

        // Find the longest String in a list
        Optional<String> longestString = fruits1.stream().max(Comparator.comparingInt(String::length));
        System.out.println(longestString.get());

        // Merge two sorted List into a single sorted list using streams
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> sortedIntegersList =
                Stream.concat(list1.stream(),list2.stream())
                       .sorted().collect(Collectors.toList());
        System.out.println(sortedIntegersList);

        // Find the intersection of two lists using Java streams:
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list4 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> intersection = list3.stream().filter(list4::contains).collect(Collectors.toList());
        System.out.println(intersection);

        // Find the kth smallest element in an array using Java streams:
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 5; // Find the 3rd smallest element
        int kthSmallest = Arrays.stream(array)
                .sorted()
                .skip(k-1)
                .findFirst()
                .orElse(-1);

        System.out.println(kthSmallest);

    }
}

class NewEmployee{

    private int id;
    private String name;
    private String dept;
    private double salary;

    public NewEmployee(int id, String name, String dept,double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "NewEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
