public class Quadrilateral extends Shapes {

    protected int edge1;
    protected int edge2;
    protected int edge3;
    protected int edge4;

    public Quadrilateral(int nrEdges, int edge1, int edge2, int edge3, int edge4) {
        this.nrEdges=nrEdges;
        this.edge1=edge1;
        this.edge2=edge2;
        this.edge3=edge3;
        this.edge4=edge4;
    }

    public Quadrilateral() {

    }

    //suprascriem functia draw din clasa Shapes
    public String draw() {
        return "I draw a quadrilateral: ";
    }

    //suprascriem functia perimeter din clasa Shapes
    public double perimeter() {
        return edge1+edge2+edge3+edge4;
    }

    //suprascriem functia area din clasa Shapes
    public double area() {
        return edge1 * edge2;
    }

    public int getEdge1() {
        return edge1;
    }

    public int getEdge2() {
        return edge2;
    }

    public int getEdge3() {
        return edge3;
    }

    public int getEdge4() {
        return edge4;
    }

    public String toString() {
        return "the result is: " + edge1+edge2+edge3+edge4;
    }

}
