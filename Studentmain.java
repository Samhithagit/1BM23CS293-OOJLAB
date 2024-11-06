import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int num;

    // Method to accept details of the student
    public void accept() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = scanner.nextLine();

        System.out.print("Enter Name: ");
        name = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        num = scanner.nextInt();

        credits = new int[num];
        marks = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = scanner.nextInt();

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Close scanner to prevent resource leaks
        scanner.close();
    }

    // Method to display details of the student
    public void display() {
        System.out.println("Student Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Subject-wise Details:");
        for (int i = 0; i < num; i++) {
            System.out.println("Subject " + (i + 1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]);
        }
    }

    // Method to calculate SGPA
    public double calculate() {
        int Credits = 0;
        double Grade = 0.0;

        for (int i = 0; i < num; i++) {
            int points = GradePoint(marks[i]);
            Credits += credits[i];
            Grade += points * credits[i];
        }

        // SGPA = Weighted Grade Points / Total Credits
        return Grade / Credits;
    }

    // Method to convert marks to grade points
    public int GradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else return 0; // Fail
    }
}

public class Studentmain {
    public static void main(String[] args) {
        // Create a student object
        Student student = new Student();

        // Accept student details
        student.accept();

        // Display student details
        student.display();

        // Calculate and display SGPA
        double sgpa = student.calculate();
        System.out.printf("SGPA: %.2f\n", sgpa);
    }
}
