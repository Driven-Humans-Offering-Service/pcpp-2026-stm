package exercises01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterTest {

    public static void main(String[] args) {
        Printer p = new Printer();

        Thread t1 = new Thread(() -> {
            for (;;) {
                p.print();
            }
        });
        Thread t2 = new Thread(() -> {
            for (;;) {
                p.print();
            }
        });
        t1.start(); t2.start();
        try { t1.join(); t2.join(); }
        catch (InterruptedException exn) {
            System.out.println("Some thread was interrupted");
        }
    }

    static class Printer {
        Lock l = new ReentrantLock();

        public void print() {
            l.lock();
            System.out.print("-");
            try { Thread.sleep(50); } catch (InterruptedException exn) { }
            System.out.print("|");
            l.unlock();
        }
    }
}
