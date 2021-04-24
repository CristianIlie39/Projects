public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int employmentYears;
    private int salary;

    public Employee(int id, String firstName, String lastName, int employmentYears, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentYears = employmentYears;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmploymentYears() {
        return employmentYears;
    }

    public void setEmploymentYears(int employmentYears) {
        this.employmentYears = employmentYears;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return firstName + " " + lastName + " " + employmentYears + " employment years; " + salary + "RON salary";
    }
}
