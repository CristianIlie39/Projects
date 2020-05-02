public class HerbivorousAnimal extends TerrestrialAnimal {

    private boolean eatHerb;

    public HerbivorousAnimal(String color, int memberNumber, String specimen, String move, boolean hunt, boolean eatHerb) {
        this.color=color;
        this.memberNumber=memberNumber;
        this.specimen=specimen;
        this.move=move;
        this.hunt=hunt;
        this.eatHerb=eatHerb;
    }

    public boolean getEatHerb() {
        return eatHerb;
    }

    public String bites() {
        return "This animal does not bite."
    }

}
