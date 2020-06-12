public class Calculator {

    public Calculator() {

    }

    public long adunare(long a, long b) {
        return a + b;
    }

    public long scadere(long a, long b) {
        return a - b;
    }

    public double inmultire(double a, double b) { // rezultatul inmultirii iese din range-ul lui long => merge cu float sau double
        return a * b;
    }

    public long impartire(long a, long b) {
        return a / b;
    }

}
