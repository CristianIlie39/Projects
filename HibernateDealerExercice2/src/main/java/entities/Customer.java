package entities;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "car_id")
    private int carId;

    public Customer(String name, String surname, int age, String address, int carId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.carId = carId;
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

    public String getAddress() {
        return address;
    }

    public int getCarId() {
        return carId;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}
