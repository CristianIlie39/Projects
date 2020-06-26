public class Chips extends Snack {

    public Chips(String productName, int productPrice,int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public Chips() {

    }

    public String toString() {
        return this.productName + ";" + this.productPrice + ";" + this.productQuantity;
    }

}
