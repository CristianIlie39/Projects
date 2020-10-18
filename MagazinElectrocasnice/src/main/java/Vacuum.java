import java.util.Objects;

public class Vacuum extends Product implements Wireless {

    public int power;

    public Vacuum(String mark, String color, String energeticEfficiency, double price, int stock, int power) {
        super(mark, color, energeticEfficiency, price, stock);
        this.power = power;
    }

    public Vacuum() {

    }

    public void start() {
        System.out.println("Vacuum is starting");
    }

    public void running() {
        System.out.println("Vacuum running");
    }

    public void connectToWiFi() {
        System.out.println("The vacuum connects to Wi-Fi");
    }

    public void stop() {
        System.out.println("Vacuum is stopping");
    }

    public int getPower() {
        return power;
    }

    public void setPower() {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Vacuum{" +
                "power=" + power +
                ", mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", energeticEfficiency='" + energeticEfficiency + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public boolean equals(Object object) {
        if (object instanceof Vacuum) {
            if (this.mark.equals(((Vacuum) object).getMark()) && this.color.equals(((Vacuum) object).getColor())
            && this.energeticEfficiency.equals(((Vacuum) object).getEnergeticEfficiency())
            && this.price == ((Vacuum) object).getPrice() && this.stock == ((Vacuum) object).getStock()
            && this.power == ((Vacuum) object).getPower()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(mark) + Objects.hash(color) + Objects.hash(energeticEfficiency) + Objects.hash(price) +
                Objects.hash(stock) + Objects.hash(power);
    }
}
