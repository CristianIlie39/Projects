package entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "color")
    private String color;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "rar_id")
    private int rarId;

    public Car(String brand, String model, int year, String color, String fuelType, int rarId) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.fuelType = fuelType;
        this.rarId = rarId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getRarId() {
        return rarId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setRarId(int rarId) {
        this.rarId = rarId;
    }
}
