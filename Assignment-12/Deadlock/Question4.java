class Resource {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();

    public void methodA() {
        synchronized (lock1) {
            System.out.println("Thread 1: Acquired lock1, trying for lock2...");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
            synchronized (lock2) {
                System.out.println("Thread 1: Acquired lock2");
            }
        }
    }

    public void methodB() {
        synchronized (lock2) {
            System.out.println("Thread 2: Acquired lock2, trying for lock3...");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
            synchronized (lock3) {
                System.out.println("Thread 2: Acquired lock3");
            }
        }
    }

    public void methodC() {
        synchronized (lock3) {
            System.out.println("Thread 3: Acquired lock3, trying for lock1...");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
            synchronized (lock1) {
                System.out.println("Thread 3: Acquired lock1");
            }
        }
    }
}

public class Question4 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(resource::methodA).start();
        new Thread(resource::methodB).start();
        new Thread(resource::methodC).start();
    }
}
