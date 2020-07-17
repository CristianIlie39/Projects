public class Car {

    private String brand;
    private String model;
    private String year;
    private String color;
    private String fuel_type;
    //colegul a avut si un foreign key in BD -> rar_id pe care l-a dat aici ca atribut; eu nu l-am dat ca atribut pt ca nu-l am in BD

    public Car(String brand, String model, String year, String color, String fuel_type) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.fuel_type = fuel_type;
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public void setBrand(String mark) {
        this.brand = brand;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String toString() {
        return this.brand + " " + this.model + " " + this.year + " " + this.color + " " + this.fuel_type;
    }
}
