class Counter {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            count++;
            System.out.println(Thread.currentThread().getName() + " - " + count);
        }
    }
}

class Question2 extends Thread {
    Counter counter;

    Question2(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Question2 t1 = new Question2(counter);
        Question2 t2 = new Question2(counter);
        t1.start();
        t2.start();
    }
}
