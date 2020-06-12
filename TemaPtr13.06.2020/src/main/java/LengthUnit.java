public enum LengthUnit {
    METER(1),
    CENTIMETER(0.01),
    FOOT(0.3),
    INCH(0.025);

    double value;

    LengthUnit(double value) { //am creat constructor
        this.value = value;
    }

    double convertToMeters() {
        return value;
    }

}

