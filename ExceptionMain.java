import java.util.Scanner;
class WrongAgeException extends Exception {
public String toString() {
return "WrongAgeException: Age cannot be negative.";
}
}
class SonOlderThanFatherException extends Exception {
public String toString() {
return "SonOlderThanFatherException: Son's age cannot be greater than or equal to Father's age.";
}
}
class Father {
int age;
Father(int age) throws WrongAgeException {
if (age < 0) {
throw new WrongAgeException();
}
this.age = age;
System.out.println("Father's age: " + age);
}
}
class Son extends Father {
int sonAge;
Son(int fatherAge, int sonAge) throws WrongAgeException, SonOlderThanFatherException {
super(fatherAge);
if (sonAge < 0) {
throw new WrongAgeException();
}
if (sonAge >= fatherAge) {
throw new SonOlderThanFatherException();
}
this.sonAge = sonAge;
System.out.println("Son's age: " + sonAge);
}
}
class ExceptionMain {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
try {
System.out.println("Enter Father's Age:");
int fatherAge = sc.nextInt();
System.out.println("Enter Son's Age:");
int sonAge = sc.nextInt();
Son son = new Son(fatherAge, sonAge);
} catch (WrongAgeException e) {
System.out.println(e);
} catch (SonOlderThanFatherException e) {
System.out.println(e);
}
}
}
