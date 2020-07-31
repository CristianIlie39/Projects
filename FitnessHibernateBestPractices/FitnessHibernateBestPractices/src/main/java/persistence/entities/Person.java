package persistence.entities;

import javax.persistence.*;

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

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscriptions_id")
    private Subscription subscription;

    public Person(String surname, String firstName, int yearOfBirth, Subscription subscription) {
        this.surname = surname;
        this.firstName = firstName;
        this.yearOfBirth = yearOfBirth;
        this.subscription = subscription;
    }

    public Person() {

    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public String toString() {
        return this.surname + " " + this.firstName + " " + this.yearOfBirth;
    }

}
