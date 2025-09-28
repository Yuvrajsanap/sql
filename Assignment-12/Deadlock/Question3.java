import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void methodA() {
        lock1.lock();
        System.out.println("Thread 1: Acquired lock1, trying for lock2...");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        lock2.lock();
        try {
            System.out.println("Thread 1: Acquired lock2");
        } finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

    public void methodB() {
        lock2.lock();
        System.out.println("Thread 2: Acquired lock2, trying for lock1...");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        lock1.lock();
        try {
            System.out.println("Thread 2: Acquired lock1");
        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }
}

public class Question3 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(resource::methodA).start();
        new Thread(resource::methodB).start();
    }
}
