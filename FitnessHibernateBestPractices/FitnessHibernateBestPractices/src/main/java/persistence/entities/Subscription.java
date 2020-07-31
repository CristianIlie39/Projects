package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "starting_date")
    private String startingDate;

    @Column(name = "end_date")
    private String endDate;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private Set<Person> personSet;

    public Subscription(String name, int price, String startingDate, String endDate, Set<Person> personSet) {
        this.name = name;
        this.price = price;
        this.startingDate = startingDate;
        this.endDate = endDate;
        this.personSet = personSet;
    }

    public Subscription(String name, int price, String startingDate, String endDate) {
        this.name = name;
        this.price = price;
        this.startingDate = startingDate;
        this.endDate = endDate;
    }

    public Subscription() {

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public String toString() {
        return this.name + " " + this.price + " " + this.startingDate + " " + this.endDate;
    }
}

