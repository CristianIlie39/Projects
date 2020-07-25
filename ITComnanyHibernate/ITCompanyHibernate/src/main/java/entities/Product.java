package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Delete_Product_By_Number_Of_Customers", query = "delete Product where numberOfCustomers < :numberOfCustomers"),
        @NamedQuery(name = "Update_Product_By_Price", query = "update Product set price = (1.2 * price)"),
        @NamedQuery(name = "Select_Product_By_Number_Of_Customers", query = "select product from Product product where numberOfCustomers > :numberOfCustomers"),
        @NamedQuery(name = "Select_Product_By_Version", query = "select product from Product product where productName = :productName")
})

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_version")
    private String productVersion;

    @Column(name = "number_of_customers")
    private int numberOfCustomers;

    @Column(name = "price")
    private int price;

    public Product(String productName, String productVersion, int numberOfCustomers, int price) {
        this.productName = productName;
        this.productVersion = productVersion;
        this.numberOfCustomers = numberOfCustomers;
        this.price = price;
    }

    public Product() {

    }

    public String getProductName() {
        return productName;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public int getPrice() {
        return price;
    }

    public int getNewPrice() {
        return (int) (price + 0.2 * price);
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return this.productName + " " + this.productVersion + " " + this.numberOfCustomers + " " + this.price;
    }

}
