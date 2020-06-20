import java.util.Set;

public class SoftwareDevelopmentAcademy {

    private Set<Group> groups;

    //folosim Singleton

    private static SoftwareDevelopmentAcademy instance = new SoftwareDevelopmentAcademy();

    private SoftwareDevelopmentAcademy() {

    }

    public static SoftwareDevelopmentAcademy getInstance() {
        return instance;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

}
