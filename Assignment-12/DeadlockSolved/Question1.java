public class Question1 {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Runnable task1 = () -> {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println("Task 1");
                }
            }
        };

        Runnable task2 = () -> {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println("Task 2");
                }
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
}
