public class Triangle extends Shapes {

    protected int edge1;
    protected int edge2;
    protected int edge3;
    protected int height;

    public Triangle(int nrEdges, int edge1, int edge2, int edge3, int height) {
        this.nrEdges=nrEdges;
        this.edge1=edge1;
        this.edge2=edge2;
        this.edge3=edge3;
        this.height=height;
    }

    public Triangle() {

    }

    //suprascriem functia draw din clasa Shapes
    public String draw() {
        return "I draw a triangle: ";
    }

    //suprascriem functia perimeter din clasa Shapes
    public double perimeter() {
        return edge1+edge2+edge3;
    }

    //suprascriem functia area din clasa Shapes
    public double area() {
        return (edge3 * height) / 2;
    }

    public int getEdge1(){
        return edge1;
    }

    public int getEdge2() {
        return edge2;
    }

    public int getEdge3() {
        return edge3;
    }

    public int getHeight() {
        return height;
    }

}
