public class Trainer extends Person {

    private boolean isAuthorized;
    public Trainer(String name, String surname, int age, boolean isAuthorized) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isAuthorized =isAuthorized;
    }

    public boolean getIsAuthorized() {
        return isAuthorized;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return this.name + ";" + this.surname;
    }


}
