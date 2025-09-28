class Question1 extends Thread {
    private Object lock;

    Question1(Object lock) {
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Question1 t1 = new Question1(lock);
        Question1 t2 = new Question1(lock);
        t1.start();
        t2.start();
    }
}
