import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Question4 {
    public static void main(String[] args) {
        final ReadWriteLock lock = new ReentrantReadWriteLock();

        Runnable readTask = () -> {
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired read lock");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.readLock().unlock();
                System.out.println(Thread.currentThread().getName() + " released read lock");
            }
        };

        Runnable writeTask = () -> {
            lock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired write lock");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.writeLock().unlock();
                System.out.println(Thread.currentThread().getName() + " released write lock");
            }
        };

        Thread t1 = new Thread(readTask);
        Thread t2 = new Thread(readTask);
        Thread t3 = new Thread(writeTask);
        Thread t4 = new Thread(writeTask);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
