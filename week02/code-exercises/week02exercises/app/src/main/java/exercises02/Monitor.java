package exercises02;

public class Monitor {
    private int readers         = 0;
    private boolean writer      = false;

    //////////////////////////
    // Read lock operations //
    //////////////////////////

    public synchronized void readLock() {
        try {
            while (writer)
                this.wait();
            readers++;
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting ");
        }

    }

    public synchronized void readUnlock() {
        readers--;
        if(readers==0)
            this.notifyAll();
    }


    ///////////////////////////
    // Write lock operations //
    ///////////////////////////

    public synchronized void writeLock() {
        try {
            while(writer)
                this.wait();
            writer=true;// This
            while(readers > 0)
                this.wait();
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted while waiting in writeLock");
        }
    }

    public synchronized void writeUnlock() {
        writer = false;
        this.notifyAll();
    }
    
    public static void main(String[] args){
        Monitor m = new Monitor();

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
