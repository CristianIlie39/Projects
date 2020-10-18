import java.util.Objects;

public class WashingMachine extends Product implements Wireless, WashClothes {

    private int numberOfPrograms;

    public WashingMachine(String mark, String color, String energeticEfficiency, double price, int stock, int numberOfPrograms) {
        super(mark, color, energeticEfficiency, price, stock);
        this.numberOfPrograms = numberOfPrograms;
    }

    public WashingMachine() {

    }

    public int getNumberOfPrograms() {
        return numberOfPrograms;
    }

    public void setNumberOfPrograms(int numberOfPrograms) {
        this.numberOfPrograms = numberOfPrograms;
    }

    public void start() {
        System.out.println("Washing machine is starting");
    }

    public void running() {
        System.out.println("Washing machine running");
    }

    public void connectToWiFi() {
        System.out.println("The washing machine connects to Wi-Fi");
    }

    public void washClothes() {
        System.out.println("The washing machine wash clothes");
    }

    public void stop() {
        System.out.println("Washing machine is stopping");
    }

    @Override
    public String toString() {
        return "WashingMachine{" +
                "numberOfPrograms=" + numberOfPrograms +
                ", mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", energeticEfficiency='" + energeticEfficiency + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public boolean equals(Object object) {
        if (object instanceof WashingMachine) {
            if (this.mark.equals(((WashingMachine) object).getMark()) && this.color.equals(((WashingMachine) object).getColor())
            && this.energeticEfficiency.equals(((WashingMachine) object).getEnergeticEfficiency())
            && this.price == ((WashingMachine) object).getPrice() && this.stock == ((WashingMachine) object).getStock()
            && this.numberOfPrograms == ((WashingMachine) object).getNumberOfPrograms()) {
                return true;
            };
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(mark) + Objects.hash(color) + Objects.hash(energeticEfficiency) + Objects.hash(price) +
                Objects.hash(stock) + Objects.hash(numberOfPrograms);
    }

}
