public class ProductFactory {

    public ProductFactory() {

    }

    //Facem metoda Factory
    public Product getProduct(String productName) {
        if (productName.equals("Cola")) {
            return new Cola();
        }
        if (productName.equals("Fanta")) {
            return new Fanta();
        }
        if (productName.equals("Water")) {
            return new Water();
        }
        if (productName.equals("Cappucino")) {
            return new Cappucino();
        }
        if (productName.equals("Americano")) {
            return new Americano();
        }
        if (productName.equals("Espresso")) {
            return new Espresso();
        }
        if (productName.equals("Croissant")) {
            return new Croissant();
        }
        if (productName.equals("Chips")) {
            return new Chips();
        }
        if (productName.equals("ChocolateBar")) {
            return new ChocolateBar();
        } else {
            return null;
        }

    }


}
