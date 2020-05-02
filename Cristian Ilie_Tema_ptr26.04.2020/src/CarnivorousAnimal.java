public class CarnivorousAnimal extends TerrestrialAnimal {

    private boolean eatMeat;

    public CarnivorousAnimal(String color, int memberNumber, String specimen, String move, boolean hunt, boolean eatMeat) {
        this.color=color;
        this.memberNumber=memberNumber;
        this.specimen=specimen;
        this.move=move;
        this.hunt=hunt;
        this.eatMeat=eatMeat;
    }

    public boolean getEatMeat() {
        return eatMeat;
    }

    public String bites() {
        return "This animal bites in order to survive"
    }

}
