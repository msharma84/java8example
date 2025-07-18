package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee{

    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

public class GroupByDepartmentUsingStreams {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Manish","IT"));
        employeeList.add(new Employee("Ramesh","HR"));
        employeeList.add(new Employee("Mahesh","IT"));
        employeeList.add(new Employee("Suresh","HR"));

        Map<String,List<Employee>> employeeByDepartment =  employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

       employeeByDepartment.forEach( (department, emplList) ->{
           System.out.println("Department : "+department);
           emplList.forEach(System.out::println);
       });
    }
}
