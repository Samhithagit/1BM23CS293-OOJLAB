import java.util.Scanner;
abstract class Shape {
    private int dimension1;
    private int dimension2;

    // Constructor to initialize dimensions
    public Shape(int dimension1, int dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    abstract void printArea();
}


class Rectangle extends Shape {
    public Rectangle(int length, int breadth) {
        super(length, breadth);
    }

   
    void printArea() {
        int area = dimension1 * dimension2;
        System.out.println("Area of Rectangle: " + area);
    }
}


class Triangle extends Shape {
    public Triangle(int base, int height) {
        super(base, height);
    }

   
    void printArea() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of Triangle: " + area);
    }
}

// Circle class that extends Shape
class Circle extends Shape {
    public Circle(int radius) {
        super(radius, 0); 
    }

   
    void printArea() {
        double area = Math.PI * dimension1 * dimension1;
        System.out.println("Area of Circle: " + area);
    }
}

// Main class to test the functionality
public class area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter length and breadth of the rectangle: ");
        int length = sc.nextInt();
        int breadth = sc.nextInt();
        Shape rectangle = new Rectangle(length, breadth);
        rectangle.printArea();

   
        System.out.print("Enter base and height of the triangle: ");
        int base = sc.nextInt();
        int height = sc.nextInt();
        Shape triangle = new Triangle(base, height);
        triangle.printArea();

      
        System.out.print("Enter radius of the circle: ");
        int radius = sc.nextInt();
        Shape circle = new Circle(radius);
        circle.printArea();

        sc.close();
    }
}
