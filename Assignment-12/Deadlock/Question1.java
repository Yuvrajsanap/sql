class Resource {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void methodA() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("MethodA");
            }
        }
    }

    public void methodB() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("MethodB");
            }
        }
    }
}

public class Question1 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(resource::methodA).start();
        new Thread(resource::methodB).start();
    }
}
