package persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Teacher teacher;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public Address() {

    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String toString() {
        return this.city + " " + this.street;
    }

}
