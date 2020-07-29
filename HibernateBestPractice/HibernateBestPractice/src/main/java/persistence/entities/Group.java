package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "findGroupByName", query = "select group from Group group where group.name = :name")
})

@Entity
@Table(name = "classes")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<Student> studentSet;

    public Group(String name, Set<Student> studentSet) {
        this.name = name;
        this.studentSet = studentSet;
        for (Student student : this.studentSet) {
            student.setGroup(this);
        }
    }

    public Group(String name) {
        this.name = name;
    }

    public Group() {

    }

    public String getName() {
        return name;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public String toString() {
        return this.name;
    }

}
