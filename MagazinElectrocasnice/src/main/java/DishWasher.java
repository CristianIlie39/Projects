import java.util.Objects;

public class DishWasher extends Product implements Wireless, WashDishes {

    private boolean incorporated;

    public DishWasher(String mark, String color, String energeticEfficiency, double price, int stock, boolean incorporated) {
        super(mark, color, energeticEfficiency, price, stock);
        this.incorporated = incorporated;
    }

    public DishWasher() {

    }

    public void start() {
        System.out.println("Dishwasher is started");
    }

    public void running() {
        System.out.println("Dishwasher is running");
    }

    public void connectToWiFi() {
        System.out.println("The dishwasher connects to Wi-Fi");
    }

    public void washDishes() {
        System.out.println("The dishwasher wash dishes");
    }

    public void dryDishes() {
        System.out.println("The dishwasher dry dishes");
    }

    public void stop() {
        System.out.println("The dishwasher is stoping");
    }

    public boolean getIncorporated() {
        return incorporated;
    }

    public void setIncorporated(boolean incorporated) {
        this.incorporated = incorporated;
    }

    @Override
    public String toString() {
        return "DishWasher{" +
                "incorporated=" + incorporated +
                ", mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", energeticEfficiency='" + energeticEfficiency + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public boolean equals(Object object) {
        if (object instanceof DishWasher) {
            if (this.mark.equals(((DishWasher) object).getMark()) && this.color.equals(((DishWasher) object).getColor())
            && this.energeticEfficiency.equals(((DishWasher) object).getEnergeticEfficiency())
            && this.price == ((DishWasher) object).getPrice() && this.stock == ((DishWasher) object).getStock()
            && this.incorporated == ((DishWasher) object).getIncorporated()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(mark) + Objects.hash(color) + Objects.hash(energeticEfficiency) + Objects.hash(price) +
                Objects.hash(stock) + Objects.hash(incorporated);
    }


}
