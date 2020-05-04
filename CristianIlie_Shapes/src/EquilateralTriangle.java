public class EquilateralTriangle extends Triangle {

    public EquilateralTriangle(int nrEdges, int edge1, int height) {
        this.nrEdges = nrEdges;
        this.edge1 = edge1;
        this.height = height;
    }

    public String draw() {
        return "I draw a equilateral triangle: ";
    }

    //suprascriem functia perimeter din clasa Triangle
    public double perimeter() {
        return 3 * edge1;
    }

    //suprascriem functia area din clasa Triangle
    public double area() {
        return (edge1 * height) / 2;
    }

}
