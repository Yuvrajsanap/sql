import java.io.*;

class MyThread extends Thread {
    private PipedInputStream in;

    public MyThread(PipedInputStream in) {
        this.in = in;
    }

    public void run() {
        try {
            System.out.println("Thread is waiting for input");
            int data = in.read(); // Blocking I/O operation
        } catch (IOException e) {
            System.out.println("Thread was interrupted during I/O");
        }
    }
}

public class Question3 {
    public static void main(String[] args) throws InterruptedException, IOException {
        PipedInputStream in = new PipedInputStream();
        MyThread t = new MyThread(in);
        t.start();
        Thread.sleep(2000); // Let the thread wait for input for 2 seconds
        t.interrupt(); // Interrupt the thread
    }
}
