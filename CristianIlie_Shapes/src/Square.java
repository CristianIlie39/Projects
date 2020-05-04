public class Square extends Quadrilateral {

    public Square(int nrEdges, int edge1) {
        this.nrEdges=nrEdges;
        this.edge1=edge1;
    }

    //suprascriem functia draw din clasa Quadrilateral
    public String draw() {
        return "I draw a square: ";
    }

    //suprascriem functia perimeter din clasa Quadrilateral
    public double perimeter() {
        return edge1 * 4;
    }

    //suprascriem functia area din clasa Quadrilateral
    public double area() {
        return edge1 * edge1;
    }
}
