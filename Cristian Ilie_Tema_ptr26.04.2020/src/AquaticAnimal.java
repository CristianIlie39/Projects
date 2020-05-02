public class AquaticAnimal extends Animal {

    protected int deep;
    protected boolean hunt;

    public AquaticAnimal(String color, int memberNumber, String specimen, int deep, boolean hunt) {
        this.color=color;
        this.memberNumber=memberNumber;
        this.specimen=specimen;
        this.deep=deep;
        this.hunt=hunt;
    }

    public AquaticAnimal() {

    }

    public int getDeep() {
        return deep;
    }

    public boolean getHunt() {
        return hunt;
    }

}
