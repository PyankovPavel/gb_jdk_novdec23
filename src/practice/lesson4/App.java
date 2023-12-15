package practice.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println();
        List<Employee> people = new ArrayList<>(Arrays.asList(
                new Employee(1, "911-2551166", "Oleg Ivanov", 7),
                new Employee(2, "812-3448899", "Ivan Olegov", 7),
                new Employee(3, "921-5577231", "Andrey Petrov", 20),
                new Employee(4, "495-1239874", "Nadezhda Py", 12)
        ));
        EmployeeList emplList = new EmployeeList(people);

        // adding new employee
        emplList.add(new Employee(5, "904-6365587", "Anna Shpak", 3));

        // find by Id
        System.out.println(emplList.findPersonById(5));

        // find by seniority
        System.out.println(new EmployeeList(emplList.findPersonBySeniority(7)));

        // find by name
        System.out.println(emplList.getPhoneNumByName("Andrey Petrov"));
    }
}
