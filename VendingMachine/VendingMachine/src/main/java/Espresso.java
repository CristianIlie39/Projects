public class Espresso extends Coffee {

    public Espresso(String productName, int productPrice,int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public Espresso() {

    }

    public String toString() {
        return this.productName + ";" + this.productPrice + ";" + this.productQuantity;
    }

}
