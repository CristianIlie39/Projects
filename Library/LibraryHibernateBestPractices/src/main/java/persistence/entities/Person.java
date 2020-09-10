package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "findPersonBySurname", query = "select person from Person person where person.surname = :surname"),
        @NamedQuery(name = "findPersonByAge", query = "select person from Person person where person.age < :age")
})

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    //cream relatia ManyToMany intre entitatile Book si Person; Person este entitatea care initiaza operatiile de CRUD
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "books_persons",
            joinColumns = {@JoinColumn(name = "persons_id")}, //am spus care-i FK pt entitatea curenta - Person, apoi am scris FK pt cealalta entitate - Book
            inverseJoinColumns = {@JoinColumn(name = "books_id")}
    )
    private Set<Book> bookSet;

    //cream relatia ManyToMany intre entitatile Author si Person; Person este entitatea care initiaza operatiile de CRUD
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "authors_persons",
            joinColumns = {@JoinColumn(name = "persons_id")},
            inverseJoinColumns = {@JoinColumn(name = "authors_id")}
    )
    private Set<Author> authorSet;

    //cream relatia ManyToMany intre entitatile Section si Person;Person este entitatea care initiaza operatiile de CRUD
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "sections_persons",
            joinColumns = {@JoinColumn(name = "persons_id")},
            inverseJoinColumns = {@JoinColumn(name = "sections_id")}
    )
    private Set<Section> sectionSet;


    public Person(String surname, String firstName, String address, int age, Set<Book> bookSet, Set<Author> authorSet,
                  Set<Section> sectionSet) {
        this.surname = surname;
        this.firstName = firstName;
        this.address = address;
        this.age = age;
        this.bookSet = bookSet;
        this.authorSet = authorSet;
        this.sectionSet = sectionSet;
    }

    public Person(String surname, String firstName, String address, int age) {
        this.surname = surname;
        this.firstName = firstName;
        this.address = address;
        this.age = age;
    }

    public Person() {

    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public Set<Section> getSectionSet() {
        return sectionSet;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public void setSectionSet(Set<Section> sectionSet) {
        this.sectionSet = sectionSet;
    }

    public String toString() {
        return this.surname + " " + this.firstName + " " + this.address + " " + this.age;
    }

}
