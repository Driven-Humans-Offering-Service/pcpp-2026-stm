package exercises02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantMonitor{
    private int readers         = 0;
    private boolean writer      = false;
    ReentrantLock lock  = new ReentrantLock();

    Condition readerCondition = lock.newCondition();
    Condition writerCondition = lock.newCondition();


    //////////////////////////
    // Read lock operations //
    //////////////////////////

    public void readLock() {
        lock.lock();
        try {
            while (writer)
                readerCondition.await();
            readers++;
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting ");
        } finally {
            lock.unlock();
        }

    }

    public void readUnlock() {
        lock.lock();
        try {
            readers--;
            if(readers==0) {
                readerCondition.signalAll();
                writerCondition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }


    ///////////////////////////
    // Write lock operations //
    ///////////////////////////



    public void writeLock() {
        lock.lock();
        try {
            while(writer)
                writerCondition.await();
            writer=true;// This
            while(readers > 0)
                writerCondition.await();
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted while waiting in writeLock");
        } finally {
            lock.unlock();
        }
    }

    public void writeUnlock() {
        lock.lock();
        try {
            writer=false;
            readerCondition.signalAll();
            writerCondition.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        ReentrantMonitor m = new ReentrantMonitor();
        final int numReadersWriters = 10;

        for (int i = 0; i < numReadersWriters; i++) {

            // start a reader
            new Thread(() -> {
                m.readLock();
                System.out.println(" Reader " + Thread.currentThread().threadId() + " started reading");
                // read
                System.out.println(" Reader " + Thread.currentThread().threadId() + " stopped reading");
                m.readUnlock();
            }).start();

            // start a writer
            new Thread(() -> {
                m.writeLock();
                System.out.println(" Writer " + Thread.currentThread().threadId() + " started writing");
                // write
                System.out.println(" Writer " + Thread.currentThread().threadId() + " stopped writing");
                m.writeUnlock();
            }).start();

        }
    }
}
