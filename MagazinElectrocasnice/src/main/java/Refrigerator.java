import java.util.Objects;

public class Refrigerator extends Product implements Wireless, Cold {

    private int volume;

    public Refrigerator(String mark, String color, String energeticEfficiency, double price, int stock, int volume) {
        super(mark, color, energeticEfficiency, price, stock);
        this.volume = volume;
    }

    public Refrigerator() {

    }

    public void start() {
        System.out.println("Refrigerator is starting");
    }

    public void running() {
        System.out.println("Refrigerator running");
    }

    public void connectToWiFi() {
        System.out.println("The refrigerator connects to Wi-Fi");
    }

    public void cools() {
        System.out.println("The refrigerator cools");
    }

    public void freeze() {
        System.out.println("The refrigerator freeze");
    }

    public void defrosts() {
        System.out.println("The refrigerator defrosts");
    }

    public void stop() {
        System.out.println("Refrigerator is stopping");
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "volume=" + volume +
                ", mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", energeticEfficiency='" + energeticEfficiency + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public boolean equals(Object object) {
        if (object instanceof Refrigerator) {
            if (this.mark.equals(((Refrigerator) object).getMark()) && this.color.equals(((Refrigerator) object).getColor())
            && this.energeticEfficiency.equals(((Refrigerator) object).getEnergeticEfficiency()) && this.price == ((Refrigerator) object).getPrice()
            && this.stock == ((Refrigerator) object).getStock() && this.volume == ((Refrigerator) object).getVolume()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(mark) + Objects.hash(color) + Objects.hash(energeticEfficiency) + Objects.hash(price) +
                Objects.hash(stock) + Objects.hash(volume);
    }

}
