class Question5 extends Thread {
    private static int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " count: " + count);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            increment();
            try {
                Thread.sleep(500); // sleep for 0.5 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Question5 t1 = new Question5();
        Question5 t2 = new Question5();
        t1.start();
        t2.start();
    }
}
