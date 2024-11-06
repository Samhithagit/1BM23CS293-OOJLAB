import java.util.Scanner;

class quadratic {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values of a, b, and c:");
        
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = b * b - 4 * a * c;
        
        if (a != 0) {
            if (d > 0) {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("The equation has two real solutions: x1 = " + x1 + ", x2 = " + x2);
            } else if (d == 0) {
                double x = -b / (2 * a);
                System.out.println("The equation has one real solution: x = " + x);
            } else {
                System.out.println("The equation has imaginary roots. There is no real solution.");
            }
        } else {
            System.out.println("Invalid input: 'a' cannot be zero.");
        }
        
        sc.close();
    }
}
