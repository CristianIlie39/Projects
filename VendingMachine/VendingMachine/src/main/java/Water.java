public class Water extends Drink {

    public Water(String productName, int productPrice,int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public Water() {

    }

    public String toString() {
        return this.productName + ";" + this.productPrice + ";" + this.productQuantity;
    }
}
