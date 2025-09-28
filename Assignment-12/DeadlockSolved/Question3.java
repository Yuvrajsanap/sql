import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Question3 {
    public static void main(String[] args) {
        final Lock lock1 = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();

        Runnable task1 = () -> {
            lock1.lock();
            try {
                lock2.lock();
                try {
                    System.out.println("Task 1");
                } finally {
                    lock2.unlock();
                }
            } finally {
                lock1.unlock();
            }
        };

        Runnable task2 = () -> {
            lock2.lock();
            try {
                lock1.lock();
                try {
                    System.out.println("Task 2");
                } finally {
                    lock1.unlock();
                }
            } finally {
                lock2.unlock();
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
}
