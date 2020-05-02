public class FreshWaterAnimal extends AquaticAnimal {

        private boolean runningWater;

        public FreshWaterAnimal(String color, int memberNumber, String specimen, int deep, boolean hunt, boolean runningWater) {
            this.color=color;
            this.memberNumber=memberNumber;
            this.specimen=specimen;
            this.deep=deep;
            this.hunt=hunt;
            this.runningWater=runningWater;
        }

        public boolean getRunningWater() {
            return runningWater;
        }

}
