import java.util.ArrayList;
import java.util.List;

public class Family {

    //Folosim Design Pattern Singleton

    private List<Person> familyMembers = new ArrayList<Person>();

    private static Family instance = new Family();

    private Family() {

    }

    public List<Person> getFamilyMembers() {
        return familyMembers;
    }

    public static Family getInstance() {
        return instance;
    }
}
