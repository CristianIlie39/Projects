public abstract class Person {

    protected String surname;
    protected String name;
    protected String department;

    public Person(String surname, String name, String department) {
        this.surname = surname;
        this.name = name;
        this.department = department;
    }

    public Person() {

    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public abstract String toString();

}
