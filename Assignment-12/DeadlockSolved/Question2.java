import java.util.concurrent.Semaphore;

public class Question2 {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(1);
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Runnable task1 = () -> {
            try {
                semaphore.acquire();
                synchronized (lock1) {
                    synchronized (lock2) {
                        System.out.println("Task 1");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        };

        Runnable task2 = () -> {
            try {
                semaphore.acquire();
                synchronized (lock2) {
                    synchronized (lock1) {
                        System.out.println("Task 2");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
}
