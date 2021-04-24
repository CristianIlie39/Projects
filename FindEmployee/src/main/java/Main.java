import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

     /*
    Given a list of employees (Employee(id,firstName,lastName,employmentYears,salary)).
    Requirement: Get the employee with the smallest salary working for less than 3 years.
     */

    public static void main(String[] args) {

        Employee employee1 = new Employee(1, "Corina", "Dumitrescu", 2, 4500);
        Employee employee2 = new Employee(1, "Mariana", "Panait", 1, 4300);
        Employee employee3 = new Employee(1, "Dorin", "Popa", 3, 6500);
        Employee employee4 = new Employee(4, "Stefania", "Marinescu", 5, 5500);
        Employee employee5 = new Employee(5, "Mariana", "Codreanu", 2, 4800);
        Employee employee6 = new Employee(6, "Alina", "Marin", 2, 5800);
        Employee employee7 = new Employee(7, "Marcelina", "Pop", 1, 7500);
        Employee employee8 = new Employee(8, "Dorina", "Panaitescu", 3, 5700);
        Employee employee9 = new Employee(9, "Stefan", "Barbu", 5, 10500);
        Employee employee10 = new Employee(10, "Marinel", "Codrescu", 4, 8200);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
        employeeList.add(employee7);
        employeeList.add(employee8);
        employeeList.add(employee9);
        employeeList.add(employee10);
        List<Employee> employeesListWithLessThan3Years = getEmployeesListWithLessThan3Years(employeeList);
        displayEmployeeWithSmallestSalary(employeesListWithLessThan3Years);
    }

    public static List<Employee> getEmployeesListWithLessThan3Years(List<Employee> employeeList) {
        List<Employee> employeesListWithLessThan3Years = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getEmploymentYears() < 3) {
                employeesListWithLessThan3Years.add(employee);
            }
        }
        return employeesListWithLessThan3Years;
    }

    public static void displayEmployeeWithSmallestSalary(List<Employee> employeeList) {
        List<Integer> salaryList = new ArrayList<>();
        for (Employee employee : employeeList) {
            salaryList.add(employee.getSalary());
        }
        Collections.sort(salaryList);
        int smallestSalary = salaryList.get(0);
        if (!salaryList.isEmpty()) {
            for (Employee employee : employeeList) {
                if (employee.getSalary() == smallestSalary) {
                    System.out.println("The wanted employee is: " + employee);
                }
            }
        } else {
            System.out.println("There is no employee");
        }
    }
}
