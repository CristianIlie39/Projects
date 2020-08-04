package persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "first_name")
    private String firstName;

    //In entitatea Book avem deja creata relatia de ManyToMany intre entitatile Author si Book;
    //Book este entitatea care initiaza operatiile de CRUD

    //In entitatea Section avem deja creata relatia de ManyToMany intre entitatile Author si Section
    //Section este entitatea care initiaza operatiile de CRUD

    //In entitatea Person avem deja creata relatia de ManyToMany intre entitatile Author si Person
    //Person este entitatea care initiaza opratiile de CRUD

    public Author(String surname, String firstName) {
        this.surname = surname;
        this.firstName = firstName;
    }

    public Author() {

    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String toString() {
        return this.surname + " " + this.firstName;
    }

}
