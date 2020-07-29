package persistence.entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "findStudentByName", query = "select student from Student student where student.name = :name"),
        @NamedQuery(name = "findStudentByYear", query = "select student from Student student where student.yearOfBirth = :yearOfBirth"),
        @NamedQuery(name = "deleteStudentByName", query = "delete Student where name = :name"),
        @NamedQuery(name = "deleteStudentByYear", query = "delete Student where yearOfBirth = :yearOfBirth")
})

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "electives")
    private String elective;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identifier_id")
    private Identifier identifier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id")
    private Group group;

    public Student(String name, String firstName, int yearOfBirth, String elective, Address address,
                   Identifier identifier, Group group) {
        this.name = name;
        this.firstName = firstName;
        this.yearOfBirth = yearOfBirth;
        this.elective = elective;
        this.address = address;
        this.identifier = identifier;
        this.group = group;
    }

    //facem un constructor fara grupa ca sa-l putem folosi in main la cerinta: se adauga o grupa noua cu o lista noua de studenti
    public Student(String name, String firstName, int yearOfBirth, String elective, Address address,
                   Identifier identifier) {
        this.name = name;
        this.firstName = firstName;
        this.yearOfBirth = yearOfBirth;
        this.elective = elective;
        this.address = address;
        this.identifier = identifier;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getElective() {
        return elective;
    }

    public Address getAddress() {
        return address;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Group getGroup() {
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setElective(String elective) {
        this.elective = elective;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String toString() {
        return this.name + " " + this.firstName + " " + this.yearOfBirth + " " + this.elective + " " + this.address;
    }
}
