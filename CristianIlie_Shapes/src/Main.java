public class Main {

    public static void main(String[] args) {

        Circle A = new Circle(4);
        Triangle B = new Triangle(3, 3, 4, 5, 4);
        Quadrilateral C = new Quadrilateral(4, 2, 3, 4, 5);
        EquilateralTriangle D = new EquilateralTriangle(3, 3, 2);
        Square E = new Square(4, 3);

        System.out.println(A.draw());
        System.out.println(B.draw());
        System.out.println(C.draw());
        System.out.println(D.draw());
        System.out.println(E.draw());
        System.out.println();
        System.out.println("The perimeter of the circle A is: " + A.perimeter());
        System.out.println("The perimeter of the triangle B is: " + B.perimeter());
        System.out.println("The perimeter of the quadrilateral C is: " + C.perimeter());
        System.out.println("The perimeter of the equilateral triangle D is: " + D.perimeter());
        System.out.println("The perimeter of the square E is: " + E.perimeter());
        System.out.println();
        System.out.println("The area of the circle A is: " + A.area());
        System.out.println("The area of the triangle B is: " + B.area());
        System.out.println("The area of the quadrilateral C is: " + C.area());
        System.out.println("The area of the equilateral triangle D is: " + D.area());
        System.out.println("The area of the square E is: " + E.area());
        System.out.println(B.toString());
        System.out.println(C.toString());


    }

}
