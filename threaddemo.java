class DisplayBMS implements Runnable {
public void run() {
try {
while (true) {
System.out.println("BMS College of Engineering");
Thread.sleep(10000);
}
} catch (InterruptedException e) {
System.out.println("Thread interrupted");
}
}
}

class DisplayCSE implements Runnable {
public void run() {
try {
while (true) {
System.out.println("CSE");
Thread.sleep(2000);
}
} catch (InterruptedException e) {
System.out.println("Thread interrupted");
}
}
}

public class threaddemo {

public static void main(String[] args) {
Thread t1 = new Thread(new DisplayBMS());
Thread t2 = new Thread(new DisplayCSE());
t1.start();
t2.start();
}
}
