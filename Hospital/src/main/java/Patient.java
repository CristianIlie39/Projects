public class Patient extends Person {

    private String age;

    public Patient(String surname, String name, String age, String department) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.department = department;
    }


    public String getAge() {
        return age;
    }

    public String toString() {
        return this.surname + ";" + this.name + ";" + this.department + ";" + this.age;
    }




}
