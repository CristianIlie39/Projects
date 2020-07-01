public class Dad extends Person {

    //folosim Design Pattern Singleton

    private Dad(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    private static Dad instance = new Dad("Popescu", "Ion", 45);

    public static Dad getInstance() {
        return instance;
    }
}
