package persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "identifiers")
public class Identifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private int number;

    @OneToOne(mappedBy = "identifier", cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(mappedBy = "identifier", cascade = CascadeType.ALL)
    private Teacher teacher;

    public Identifier(int number, Student student, Teacher teacher) {
        this.number = number;
        this.student = student;
        this.teacher = teacher;
    }

    public Identifier(int number) {
        this.number = number;
    }

    public Identifier() {

    }

    public int getNumber() {
        return number;
    }

    public Student getStudent() {
        return student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
