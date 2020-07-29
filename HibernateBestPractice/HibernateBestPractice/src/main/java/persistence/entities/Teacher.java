package persistence.entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "findTeacherByName", query = "select teacher from Teacher teacher where teacher.name = :name"),
        @NamedQuery(name = "findTeacherByAge", query = "select teacher from Teacher teacher where teacher.age = :age"),
        @NamedQuery(name = "deleteTeacherByName", query = "delete Teacher where name = :name"),
        @NamedQuery(name = "deleteTeacherByAge", query = "delete Teacher where age = :age")
})

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "subject")
    private String subject;

    @Column(name = "tenure")
    private boolean tenure;

    @Column(name = "group_master")
    private String groupMaster;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identifier_id")
    private Identifier identifier;

    public Teacher(String name, String surname, int age, String subject, boolean tenure, String groupMaster,
                   Address address, Identifier identifier) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.subject = subject;
        this.tenure = tenure;
        this.groupMaster = groupMaster;
        this.address = address;
        this.identifier = identifier;
    }

    public Teacher() {

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

    public String getSubject() {
        return subject;
    }

    public boolean isTenure() {
        return tenure;
    }

    public String getGroupMaster() {
        return groupMaster;
    }

    public Address getAddress() {
        return address;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTenure(boolean tenure) {
        this.tenure = tenure;
    }

    public void setGroupMaster(String groupMaster) {
        this.groupMaster = groupMaster;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public String toString() {
        return this.name + " " + this.surname + " " + this.age + " " + this.subject + " " + this.tenure + " " +
        this.groupMaster + " " + this.address + " " + this.identifier;
    }

}