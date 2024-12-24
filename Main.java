//package CIE
package CIE;

public class Student {
String usn;
String name;
int sem;

public Student(String u, String n, int s) {
usn = u;
name = n;
sem = s;
}

public void printDetails() {
System.out.println("Student Name: " + name);
System.out.println("USN: " + usn);
System.out.println("Semester: " + sem);
}
}

public class Internals {
int[] marks = new int[5];

public Internals(int[] marks) {
this.marks = marks;
}

public void printMarks() {
System.out.println("Internal Marks: ");
for (int i = 0; i < 5; i++) {
System.out.println("Course " + (i + 1) + ": " + marks[i]);
}
}
}

//package SEE
package SEE;

import CIE.Student;
import java.util.scanner;

public class External extends Student {
int[] seeMarks = new int[5];

public External(String usn,String name,int sem,int[] seeMarks) {
super(usn,name,sem);
this.seeMarks = seeMarks;
}

public void printMarks() {
System.out.println("SEE Marks: ");
for (int i = 0; i < 5; i++) {

System.out.println("Course " + (i + 1) + ": " + seeMarks[i]);
}
}
}

//main program
import CIE.Student;
import CIE.Internals;
import SEE.External;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter Student Name: ");
String name = sc.nextLine();
System.out.print("Enter USN: ");
String usn = sc.nextLine();
System.out.print("Enter Semester: ");
int sem = sc.nextInt();

int[] internalMarks = new int[5];
System.out.println("Enter Internal Marks for 5 subjects: ");
for (int i = 0; i < 5; i++) {
internalMarks[i] = sc.nextInt();

}

int[] seeMarks = new int[5];
System.out.println("Enter SEE Marks for 5 subjects: ");
for (int i = 0; i < 5; i++) {
seeMarks[i] = sc.nextInt();
}

Student student = new Student(usn, name, sem);
Internals internals = new Internals(internalMarks);
External external = new External(name,usn,sem,seeMarks);

System.out.println("Student Details: ");
student.printDetails();
System.out.println("Internal Marks: ");
internals.printMarks();
System.out.println("SEE Marks: ");
external.printMarks();

System.out.println("Final Marks (50% Internals + 50% SEE): ");

for (int i = 0; i < 5; i++) {
int finalMark = (internalMarks[i]) + (seeMarks[i] / 2);
System.out.println("Course " + (i + 1) + ": " + finalMark);
}
}
}
