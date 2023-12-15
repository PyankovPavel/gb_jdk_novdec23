package practice.lesson4;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeList {
    private final List<Employee> employeeList;

    public EmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee findPersonById(int id) {
        return employeeList.stream()
                .filter(empl -> empl.getId() == id)
                .findAny().orElse(null);
    }

    public List<Employee> findPersonBySeniority(int seniority) {
        return employeeList.stream()
                .filter(empl -> empl.getSeniority() == seniority)
                .collect(Collectors.toList());
    }

    public List<String> getPhoneNumByName(String name) {
        return employeeList.stream()
                .filter(empl -> Objects.equals(empl.getName(), name))
                .map(Employee::getPhoneNum).toList();
    }

    public void add(Employee empl) {
        employeeList.add(empl);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Employee empl : employeeList)
            result.append(empl.getId()).append(" ").append(empl.getName()).append(" ").append(empl.getPhoneNum())
                    .append(" ").append(empl.getSeniority()).append("\n");
        return result.toString();
    }
}
