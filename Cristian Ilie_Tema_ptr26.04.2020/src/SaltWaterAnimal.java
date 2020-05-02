public class SaltWaterAnimal extends AquaticAnimal {

    private int weightKg;

    public SaltWaterAnimal(String color, int memberNumber, String specimen, int deep, boolean hunt, int weightKg) {
        this.color=color;
        this.memberNumber=memberNumber;
        this.specimen=specimen;
        this.deep=deep;
        this.hunt=hunt;
        this.weightKg=weightKg;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public boolean getHunt() {
        System.out.println("acest peste vaneaza ca sa supravietuiasca.");
    }
}
