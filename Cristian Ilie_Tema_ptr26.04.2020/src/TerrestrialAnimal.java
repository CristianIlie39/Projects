public class TerrestrialAnimal extends Animal {

    protected String move;
    protected boolean hunt;

    public TerrestrialAnimal(String color, int memberNumber, String specimen, String move, boolean hunt) {
        this.color = color;
        this.memberNumber = memberNumber;
        this.specimen = specimen;
        this.move = move;
        this.hunt = hunt;
    }
    public TerrestrialAnimal() {

    }
    public String getMove() {
        return move;
    }
    public boolean getHunt() {
        return hunt;
    }
    public String bites() {
        return "This Animal bites an land";
    }


}
