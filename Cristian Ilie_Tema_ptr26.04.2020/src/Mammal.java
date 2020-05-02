public class Mammal extends TerrestrialAnimal {

    private int maxBreeding;

    public Mammal(String color, int memberNumber, String specimen, String move, boolean hunt, int maxBreeding) {
        this.color=color;
        this.memberNumber=memberNumber;
        this.specimen=specimen;
        this.move=move;
        this.hunt=hunt;
        this.maxBreeding=maxBreeding;
    }

    public int getMaxBreeding() {
        return maxBreeding;
    }

    public String bites() {
        return "This animal bites if you attack its children.";
    }

}
