public class Trainee extends Person{

    private boolean knowProgramming;

    public Trainee(String name, String surname, int age, boolean knowProgramming) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.knowProgramming = knowProgramming;
    }

    public boolean isKnowProgramming() {
        return knowProgramming;
    }

    public String toString() {
        return this.name + ";" + this.surname + ";" + this.age + ";" + this.knowProgramming;
    }

    public int getAge() {
        return age;
    }


}
