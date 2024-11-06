import java.util.Scanner;

class Book {
    private String name;
    private String author;
    private double price;
    private int n;

    Book(String name, String author, double price, int n) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.n = n;
    }

    public String toString() {
        return "Book name: " + this.name + "\n" + "Author name: " + this.author + "\n" + "Price: " + this.price + "\n" + "Number of pages: " + n;
    }
}

public class Bookdemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter number of books: ");
        n = sc.nextInt();
        sc.nextLine();

        Book[] b = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Book " + (i + 1) + ":");
            System.out.print("Enter name of Book: ");
            String name = sc.nextLine();
            System.out.print("Enter Author name: ");
            String author = sc.nextLine();
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            System.out.print("Enter number of pages: ");
            int numPages = sc.nextInt();
            sc.nextLine();
            b[i] = new Book(name, author, price, numPages);
        }

        System.out.println("Book details:");
        for (int i = 0; i < n; i++) {
            System.out.println(b[i].toString());
        }

        sc.close();
    }
}