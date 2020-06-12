public enum Planets {

    EARTH(0, "Medium Earth"),
    JUPITER(5, "Huge Jupiter"),
    SATURN(7, "Big Saturn"),
    PLUTO(10, "Small Pluto");

    int distance;
    String relativeSize;

    Planets(int distance, String relativeSize) {
        this.distance = distance;
        this.relativeSize = relativeSize;
    }

    @Override
    public String toString() {
        return relativeSize;
    }

    public int distanceFromEarth() {
        return distance;
    }

}
