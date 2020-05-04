public class Shapes {
    //atribute (stari)
    protected int nrEdges;

    //constructor
    public Shapes(int nrEdges) {
        this.nrEdges=nrEdges;
    }
    //constructor default
    public Shapes() {

    }

    //metode (comportamente)
    public String draw() {
        return "I draw a shape: ";
    }

    public double perimeter() {
        return 12;
    }

    public double area() {
        return 9;
    }

    public int getNrEdges(){
        return nrEdges;
    }


}
