class Counter {
    private static int count = 0;

    public static void increment() {
        synchronized (Counter.class) {
            count++;
            System.out.println(Thread.currentThread().getName() + " - " + count);
        }
    }
}

class Question4 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            Counter.increment();
        }
    }

    public static void main(String[] args) {
        Question4 t1 = new Question4();
        Question4 t2 = new Question4();
        t1.start();
        t2.start();
    }
}
