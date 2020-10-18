public abstract class Product {
    protected String mark;
    protected String color;
    protected String energeticEfficiency;
    protected double price;
    protected int stock;

    public Product(String mark, String color, String energeticEfficiency, double price, int stock) {
        this.mark = mark;
        this.color = color;
        this.price = price;
        this.stock = stock;
        this.energeticEfficiency = energeticEfficiency;
    }

    public Product() {

    }

    public abstract void start();

    public abstract void running();

    public abstract void stop();

    public String getMark() {
        return mark;
    }

    public String getColor() {
        return color;
    }

    public String getEnergeticEfficiency() {
        return energeticEfficiency;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setEnergeticEfficiency(String energeticEfficiency) {
        this.energeticEfficiency = energeticEfficiency;
    }

}
