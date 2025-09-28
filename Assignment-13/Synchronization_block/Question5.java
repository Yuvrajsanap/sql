class Counter {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            count++;
            displayCount();
        }
    }

    public void displayCount() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " - " + count);
        }
    }
}

class Question5 extends Thread {
    Counter counter;

    Question5(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Question5 t1 = new Question5(counter);
        Question5 t2 = new Question5(counter);
        t1.start();
        t2.start();
    }
}
