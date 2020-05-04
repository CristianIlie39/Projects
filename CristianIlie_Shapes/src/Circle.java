public class Circle extends Shapes {

    private int ray;

    public Circle(int ray) {
        this.ray=ray;
    }

    //suprascriem functia draw din clasa Shapes
    public String draw() {
        return "I draw a circle: ";
    }

    //suprascriem functia perimeter din clasa Shapes
    public double perimeter() {
        return ray * 2 * 3.14;
    }

    //suprascriem functia area din clasa Shapes
    public double area() {
        return 3.14 * ray * ray;
    }

    public int getRay() {
        return ray;
    }

}
