class Question3 extends Thread {
    private Object lock1;
    private Object lock2;

    Question3(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " - Lock1 acquired");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " - Lock2 acquired");
            }
        }
    }

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Question3 t1 = new Question3(lock1, lock2);
        Question3 t2 = new Question3(lock2, lock1);
        t1.start();
        t2.start();
    }
}
