public abstract class Person {

    protected String name;
    protected String surname;
    protected int age;

    public String toString() {
        return this.name + " " + this.surname + " " + this.age;
    }
}
