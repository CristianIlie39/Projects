public class AerialAnimal extends Animal {

    protected int flyingHeight;
    protected boolean migratory;

    public AerialAnimal(String color, int memberNumber, String specimen, int flyingHeight, boolean migratory) {
        this.color=color;
        this.memberNumber=memberNumber;
        this.specimen=specimen;
        this.flyingHeight=flyingHeight;
        this.migratory=migratory;
    }

    public AerialAnimal() {

    }

    public int getFlyingHeight() {
        return flyingHeight;
    }

    public boolean getMigratory() {
        return migratory;
    }

}

