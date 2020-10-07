public class Product {

    private String type;
    private String mark;
    private String color;
    private int size;
    private int price;

    public Product(String type, String mark, String color, int size, int price) {
        this.type = type;
        this.mark = mark;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public Product() {

    }

    public String getType() {
        return type;
    }

    public String getMark() {
        return mark;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.type + ";" + this.mark + ";" + this.color + ";" + this.size + ";" + this.price;
    }

}
