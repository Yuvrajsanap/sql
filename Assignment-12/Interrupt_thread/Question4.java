class MyThread extends Thread {
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is working");
                performTask();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted during task");
        }
    }

    private void performTask() throws InterruptedException {
        // Simulate a long-running task
        for (int i = 0; i < 5; i++) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            System.out.println("Task running... step " + i);
            Thread.sleep(1000);
        }
    }
}

public class Question4 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(3000); // Let the thread work for 3 seconds
        t.interrupt(); // Interrupt the thread
    }
}
