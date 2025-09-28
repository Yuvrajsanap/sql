class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("Thread going to sleep");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted during sleep");
        }
    }
}

public class Question2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(2000); // Let the thread sleep for 2 seconds
        t.interrupt(); // Interrupt the thread
    }
}
