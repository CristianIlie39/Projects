public class Mom extends Person {

    //folosim Design Pattern Singleton

    private Mom(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    private static Mom instance = new Mom("Popescu", "Elena", 43);

    public static Mom getInstance() {
        return instance;
    }
}
